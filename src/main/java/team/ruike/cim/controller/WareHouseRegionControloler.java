package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.GoodsShelve;
import team.ruike.cim.pojo.WarehouseRegion;
import team.ruike.cim.service.GoodSShelveService;
import team.ruike.cim.service.WareHouSereGIonService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 物料区域表
 */
@Controller
public class WareHouseRegionControloler {
    @Resource
    private WareHouSereGIonService warehouseregionServer;
    @Resource
    private GoodSShelveService goodsshelveService;
    @RequestMapping("/getwarehouseregion.do")
    public String getWarehouseregion(WarehouseRegion warehouseRegion, GoodsShelve goodsShelve,Pager<WarehouseRegion> pager, HttpServletRequest request){
        warehouseregionServer.getWareHouSereGIonServer(warehouseRegion,pager);
        List<GoodsShelve> good= goodsshelveService.getGoodsshelve(goodsShelve);
        request.setAttribute("goodsShelves",good);
        request.setAttribute("warehouseRegions",pager.getList());
        return "warehouses/warehouse_region";
    }
}
