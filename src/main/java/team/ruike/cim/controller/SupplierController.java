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
import team.ruike.cim.pojo.MaterielTypeLevelB;
import team.ruike.cim.pojo.Supplier;
import team.ruike.cim.pojo.SupplierContract;
import team.ruike.cim.service.SupplierService;
import team.ruike.cim.util.GenerateNumber;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
        supplierService.addSupplier(supplier);

        //服务端的imges目录需要手动创建好
        /*String path = session.getServletContext().getRealPath("/upload");
        for (int i = 0; i < photos.length; i++) {
            if(!photos[i].isEmpty()){

                String fileName = photos[i].getOriginalFilename();

                if(fileName.endsWith(".jpg")||fileName.endsWith(".png")){

                    File file = new File(path, fileName);

                    //完成文件上传
                    photos[i].transferTo(file);

                }else{

                   return "2";
                }

            }
        }*/

       return  "1";

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
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String str=format.format(date);
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
    public void addSupplierContract(SupplierContract supplierContract,String date,PrintWriter printWriter){
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

        supplierContract.setSupplierContractImage("1");
        int a = supplierService.addSupplierContract(supplierContract);

        String jeonString=JSON.toJSONString(a);
        printWriter.write(jeonString);
        printWriter.flush();
        printWriter.close();
    }
}
