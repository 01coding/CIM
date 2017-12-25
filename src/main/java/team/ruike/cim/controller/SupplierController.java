package team.ruike.cim.controller;

/**
 * Created by Administrator on 2017/12/19.
 */

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import team.ruike.cim.pojo.MaterielTypeLevelB;
import team.ruike.cim.pojo.Supplier;
import team.ruike.cim.pojo.SupplierContract;
import team.ruike.cim.service.SupplierService;
import team.ruike.cim.util.GenerateNumber;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 供应商管理控制器
 * @author 王傲祥
 * @version 1.0
 */
@Controller
public class SupplierController {
    @Resource
    private SupplierService supplierService;
    /**
     * 跳转到供应商主页
     * @return
     */
    @RequestMapping("/supplier.do")
    public String supplier(Supplier supplier, Pager<Supplier> pager, HttpServletRequest request,MaterielTypeLevelB materielTypeLevelB){

        supplierService.getSupplier(supplier, pager);
        request.setAttribute("suppliers",pager);
        request.setAttribute("MaterielTypeLevelBs",supplierService.getMaterielTypeLevelB(materielTypeLevelB));
        return "supplier/supplier";
    }

    /**
     * 删除供应商
     * @param supplierId 供应商id
     * @return
     */
    @RequestMapping("/delectSupplier.do")
    @ResponseBody
    public String delectSupplier(Integer supplierId){
        int num=supplierService.delectSupplier(supplierId);
        return (num==1)+"";
    }

    /**
     * 添加供应商
     * @param supplier
     * @return
     */
    @RequestMapping("/addSupplier.do")
    @ResponseBody
    public String addSupplier(Supplier supplier, String date, @RequestParam MultipartFile[] photos, HttpSession session, HttpServletRequest request) throws IOException {
        Date dates=null;
        try
        {
            //转换时间
            java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
            dates =  formatter.parse(date);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }
        supplier.setCooperationStartDate(dates);
        //供应商状态，默认为1,
        supplier.setSupplierState(1);

        supplier.setSupplierImage("1");
        supplier.setSupplierCharterImage("1");

        //自动生成编号
        supplier.setSupplierNo(GenerateNumber.getGenerateNumber().getRandomFileName());


        Supplier supplierNo=supplierService.addSupplier(supplier);

        String supplier2=JSON.toJSONString(supplierNo);


       return  supplier2;

    }

    /**
     * 修改供应商信息
     * @param supplier
     * @return
     */
    @RequestMapping("/updateSupplier.do")
    @ResponseBody
    public String updateSupplier(Supplier supplier){
       int num= supplierService.updateSupplier(supplier);
        return (num==1)+"";
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @RequestMapping("/getSupplierById.do")
    @ResponseBody
    public String getSupplierById(@RequestParam(value = "id") int id){
        Supplier supplier=supplierService.getSupplierById(id);
        return JSON.toJSONString(supplier);
    }


    /**
     * 跳转，合同管理页面
     * @param supplierContract
     * @param pager
     * @param request
     * @return
     */
    @RequestMapping("/contractManagement.do")
    public String contractManagement(SupplierContract supplierContract,Pager<SupplierContract> pager,HttpServletRequest request,Supplier supplier){
        supplierService.getSupplierContract(supplierContract,pager);
        request.setAttribute("supplierContracts",pager);
        request.setAttribute("supplierList",supplierService.getSupplierList(supplier));
        return "supplier/contractManagement";
    }

    /**
     * 添加合同
     * @param supplierContract 合同对象
     * @return
     */
    @RequestMapping("/addSupplierContract.do")
    @ResponseBody
    public String addSupplierContract(SupplierContract supplierContract,String date,@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){

        String filePath = upload(file, request);
        supplierContract.setSupplierContractImage("");
        if (filePath != null && !filePath.equals("")) {/*
            String pic_time = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());*/

            supplierContract.setSupplierContractImage(filePath);
        }

        Date dates=null;
        try
        {
            //转换时间
            java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
            dates =  formatter.parse(date);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }
        supplierContract.setSupplierContractDate(dates);

        supplierContract.setStatus(0);

        SupplierContract supplierContractNo = supplierService.addSupplierContract(supplierContract);
        String supplierContract1= JSON.toJSONString(supplierContractNo);
        return supplierContract1;
    }

    /**
     * 上传文件
     * @param file
     * @param request
     * @return
     */
    public String upload(CommonsMultipartFile file, HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getResource("upload\\").getPath()
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
                return filePath;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
