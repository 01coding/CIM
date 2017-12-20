package team.ruike.cim.controller;

/**
 * Created by Administrator on 2017/12/19.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.pojo.MaterielTypeLevelB;
import team.ruike.cim.pojo.Supplier;
import team.ruike.cim.service.SupplierService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public String addSupplier(Supplier supplier){
        supplier.setStatus(0);
        supplierService.addSupplier(supplier);
        return "1";
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
