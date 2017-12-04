package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.Warehouse;
import team.ruike.cim.service.WarehouseService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WarehouseController {

    @Resource
    private WarehouseService warehouseService;

    @RequestMapping("/addwarehouse.do")
    public String addWarehouse(Warehouse warehouse, HttpServletRequest request) {
        int num = warehouseService.addwarehouse(warehouse);
        if (num == 0) {
            request.setAttribute("mes", "添加失败");
            return "warehouses/warehouse";
        } else {
            return "warehouses/warehouse";
        }
    }

    @RequestMapping("/updwarehouse.do")
    public String updWarehouse(Warehouse warehouse, HttpServletRequest request) {
        int num = warehouseService.addwarehouse(warehouse);
        if (num == 0) {
            request.setAttribute("mes", "修改失败");
            return "warehouses/warehouse";
        } else {
            return "warehouses/warehouse";
        }
    }
    @RequestMapping("/materiel.do")
    public String selectWarehouse(Warehouse warehouse,Pager<Warehouse>pager, HttpServletRequest request) {
        pager.setTotalRecord(warehouseService.count(warehouse));
        pager.setCurrentPage(0);
        pager.setPageSize(99);
        List<Warehouse> lists = warehouseService.getwarehouses(warehouse,pager);
        pager.setList(lists);
        request.setAttribute("lsitwar", pager.getList());
        return "warehouses/warehouse";
    }
}
