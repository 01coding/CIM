package team.ruike.cim.controller;

/**
 * Created by Administrator on 2017/12/19.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 供应商管理控制器
 * @author 王傲祥
 * @version 1.0
 */
@Controller
public class SupplierController {
    /**
     * 跳转到供应商主页
     * @return
     */
    @RequestMapping("/supplier.do")
    public String supplier(){
        return "supplier/supplier";
    }

    /**
     * 跳转，新增供应商页面
     * @return
     */
    @RequestMapping("/addSupplier.do")
    public String addSupplier(){
        return "supplier/addSupplier";
    }

    /**
     * 跳转，修改供应商页面
     * @return
     */
    @RequestMapping("/updateSupplier.do")
    public String updateSupplier(){
        return "supplier/updateSupplier";
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
