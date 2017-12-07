package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.ProductWarehouseRegion;
import team.ruike.cim.service.ProductwarehouseregionServer;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductwarehouseregionController {
    @Resource
    private ProductwarehouseregionServer productwarehouseregionServer;
    @RequestMapping("/getProductwarehouseregion.do")
    public String getProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion, Pager<ProductWarehouseRegion> pager, HttpServletRequest request) {
        productwarehouseregionServer.getProductwarehouseregion(productWarehouseRegion,pager);
        request.setAttribute("productWarehouseRegions",pager.getList());
        return "warehouses/warehouse_region";
    }
}
