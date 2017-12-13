package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.WarehouseOutRegister;
import team.ruike.cim.service.WareHouSereGISTerOutService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 物料出库记录
 */
@Controller
public class WareHouSereGISTerKController {
    @Resource
    private WareHouSereGISTerOutService wareHouSereGISTerService;
    @RequestMapping("warehouseOutRegister.do")
    public String getWareHouSereGISTer(WarehouseOutRegister warehouseOutRegister, Pager<WarehouseOutRegister> pager,HttpServletRequest request){
        wareHouSereGISTerService.getWarehouseOutRegister(warehouseOutRegister,pager);
        request.setAttribute("outRegisterPage",pager);
        return "warehouses/materiel_register";
    }
}
