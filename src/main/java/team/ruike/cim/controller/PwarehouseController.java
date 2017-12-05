package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.ProductWarehouse;
import team.ruike.cim.service.PwarehouseService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PwarehouseController {
    @Resource
    private PwarehouseService pwarehouseService;
    @RequestMapping("productWarehouse.do")
    public String getPwarehouse(ProductWarehouse productWarehouse, Pager<ProductWarehouse> pager,HttpServletRequest request){
        pwarehouseService.getwarehouse(productWarehouse,pager);
        request.setAttribute("productWarehouses", pager.getList());
        return "warehouses/warehouse";
    }
}
