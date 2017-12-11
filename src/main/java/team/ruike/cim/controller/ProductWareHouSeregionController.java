package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.ProductGoodsShelve;
import team.ruike.cim.pojo.ProductWarehouseRegion;
import team.ruike.cim.service.ProductGoodSShelve;
import team.ruike.cim.service.ProductWareHouSereGIonServer;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 成品区域
 */
@Controller
public class ProductWareHouSeregionController {
    @Resource
    private ProductWareHouSereGIonServer productwarehouseregionServer;
    @Resource
    private ProductGoodSShelve productGoodSShelve;
    @RequestMapping("/getProductwarehouseregion.cl")
    public String getProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion, Pager<ProductWarehouseRegion> pager, ProductGoodsShelve productGoodsShelve,HttpServletRequest request) {
        productwarehouseregionServer.getProductWareHouSereGIon(productWarehouseRegion,pager);
        request.setAttribute("productGoodsShelves", productGoodSShelve.getProductGoodSShelve(productGoodsShelve));
        request.setAttribute("productWarehouseRegions",pager.getList());
        return "warehouses/warehouse_region";
    }
}
