package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.pojo.ProductWarehouseRegister;
import team.ruike.cim.service.ProductWarehouseRegisterService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductWarehouseRegisterController {
    @Resource
    private ProductWarehouseRegisterService productWarehouseRegisterService;
   @RequestMapping("getProductWarehouseRegister.do")
    public String getProductWarehouseRegister(ProductWarehouseRegister productWarehouseRegister, Pager< ProductWarehouseRegister> pager,HttpServletRequest request){
        productWarehouseRegisterService.getProductWarehouseRegister(productWarehouseRegister,pager);
        request.setAttribute("RuKuPage",pager);
        return "warehouses/product";
    }
}
