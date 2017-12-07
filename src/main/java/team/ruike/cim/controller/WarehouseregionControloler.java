package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.WarehouseRegion;
import team.ruike.cim.service.WarehouseregionServer;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WarehouseregionControloler {
    @Resource
    private WarehouseregionServer warehouseregionServer;
    @RequestMapping("/getwarehouseregion.do")
    public String getWarehouseregion(WarehouseRegion warehouseRegion, Pager<WarehouseRegion> pager, HttpServletRequest request){
        warehouseregionServer.getWarehouseregionServer(warehouseRegion,pager);
        request.setAttribute("warehouseRegions",pager.getList());
        return "warehouses/warehouse_region";
    }
}
