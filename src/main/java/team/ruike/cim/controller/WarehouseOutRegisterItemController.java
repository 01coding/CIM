package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.WarehouseOutRegisterItem;
import team.ruike.cim.service.WarehouseOutRegisterItemService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 出库记录表项控制器
 */
@Controller
public class WarehouseOutRegisterItemController {
    @Resource
    private WarehouseOutRegisterItemService warehouseOutRegisterItemService;
    @RequestMapping("getWarehouseOutRegisterItem.do")
    public String getWarehouseOutRegisterItem(WarehouseOutRegisterItem warehouseOutRegisterItem, Pager<WarehouseOutRegisterItem> pager,HttpServletRequest request) {
            warehouseOutRegisterItemService.getOutRegisterItemByWarehouseId(warehouseOutRegisterItem,pager);
        request.setAttribute("OutRegisterItemPage",pager);
        return "warehouses/materiel_Out_Register";
    }
}
