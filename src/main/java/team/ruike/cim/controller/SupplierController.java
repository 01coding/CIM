package team.ruike.cim.controller;

/**
 * Created by Administrator on 2017/12/19.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import team.ruike.cim.pojo.MaterielTypeLevelB;
import team.ruike.cim.pojo.Supplier;
import team.ruike.cim.service.SupplierService;
import team.ruike.cim.util.GenerateNumber;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
    public String addSupplier(Supplier supplier,String date,@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request){

        String filePath = upload(file, request);
        supplier.setSupplierCharterImage("");
        if (filePath != null &&!filePath.equals("")) {
            supplier.setSupplierCharterImage(filePath);
        }

        String filePath1=upload(file, request);
        supplier.setSupplierImage("");
        if (filePath != null &&!filePath.equals("")) {
            supplier.setSupplierImage(filePath);
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
        supplier.setCooperationStartDate(dates);
        //供应商状态，默认为1,
        supplier.setSupplierState(1);



        //自动生成编号
        supplier.setSupplierNo(GenerateNumber.getGenerateNumber().getRandomFileName());


       supplierService.addSupplier(supplier);
       return  "1";

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

    /**
     * 跳转，合同管理页面
     * @return
     */
    @RequestMapping("/contractManagement.do")
    public String contractManagement(){
        return "supplier/contractManagement";
    }

}
