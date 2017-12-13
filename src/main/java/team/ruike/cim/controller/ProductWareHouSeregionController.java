package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.ProductGoodsShelve;
import team.ruike.cim.pojo.ProductWarehouseRegion;
import team.ruike.cim.service.ProductGoodSShelve;
import team.ruike.cim.service.ProductWareHouSereGIonService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 成品区域
 */
@Controller
public class ProductWareHouSeregionController {
    @Resource
    private ProductWareHouSereGIonService productWareHouSereGIonService;
    @Resource
    private ProductGoodSShelve productGoodSShelve;
    @RequestMapping("/getProductwarehouseregion.do")
    public String getProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion, Pager<ProductWarehouseRegion> pager, ProductGoodsShelve productGoodsShelve,HttpServletRequest request) {
        productWareHouSereGIonService.getProductWareHouSereGIon(productWarehouseRegion,pager);
        request.setAttribute("productGoodsShelves", productGoodSShelve.getProductGoodSShelve(productGoodsShelve));
        request.setAttribute("productWarehouseRegions",pager.getList());
        return "warehouses/warehouse_region";
    }
}
