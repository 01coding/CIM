package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.ProductWarehouse;
import team.ruike.cim.pojo.Warehouse;
import team.ruike.cim.service.PwarehouseService;
import team.ruike.cim.service.WarehouseService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 物料仓库
 */
@Controller
public class WarehouseController {

    @Resource
    private WarehouseService warehouseService;
    @Resource
    private PwarehouseService pwarehouseService;

    @RequestMapping("/addwarehouse.do")
    public String addWarehouse(Warehouse warehouse, HttpServletRequest request) {
        int num = warehouseService.addWareHouse(warehouse);
        if (num == 0) {
            request.setAttribute("mes", "添加失败");
            return "warehouses/warehouse";
        } else {
            return "warehouses/warehouse";
        }
    }

    @RequestMapping("/updwarehouse.do")
    public String updWarehouse(Warehouse warehouse, HttpServletRequest request) {
        int num = warehouseService.updWareHouse(warehouse);
        if (num == 0) {
            request.setAttribute("mes", "修改失败");
            return "warehouses/warehouse";
        } else {
            return "warehouses/warehouse";
        }
    }

    @RequestMapping("/warehouse.do")
    public String selectWarehouse(Warehouse warehouse, HttpServletRequest request, ProductWarehouse productWarehouse) {
        request.setAttribute("lsitwar", warehouseService.getWareHouses(warehouse));
        request.setAttribute("productWarehouses",pwarehouseService.getWarehouse(productWarehouse));
        return "warehouses/warehouse";
    }
}
