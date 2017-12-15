package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.WarehouseRegisterItem;
import team.ruike.cim.service.WarehouseRegisterItemService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 入库记录项
 */
@Controller
public class WarehouseRegisterItemControloler {
    @Resource
    private WarehouseRegisterItemService warehouseRegisterItemService;
    @RequestMapping("/getWarehouseRegisterItem.do")
    public String getWarehouseRegisterItem(HttpServletRequest request, WarehouseRegisterItem warehouseRegisterItem, Pager<WarehouseRegisterItem> pager) {
        warehouseRegisterItemService.getWarehouseRegisterItemByWarehouseId(warehouseRegisterItem,pager);
        request.setAttribute("RegisterItemPager", pager);
        return "warehouses/materiel_register";
    }
}
