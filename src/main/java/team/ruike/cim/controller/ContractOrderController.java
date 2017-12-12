package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.dao.ContractOrderTermDao;
import team.ruike.cim.dao.MenuDao;
import team.ruike.cim.dao.MenuTypeDao;
import team.ruike.cim.pojo.ContractOrder;
import team.ruike.cim.pojo.MenuType;
import team.ruike.cim.pojo.OrderContract;
import team.ruike.cim.pojo.TemporaryOrder;
import team.ruike.cim.service.ContractOrderService;
import team.ruike.cim.service.OrderContractService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * 合同订单
 * @author 甄立
 * @version 1.0
 */
@Controller
@RequestMapping("contract/order")
public class ContractOrderController {

    @Resource
    private ContractOrderService contractOrderService;
    @Resource
    private OrderContractService orderContractService;

    @Resource
    private MenuTypeDao menuTypeDao;//暂无业务类





    @RequestMapping("index.do")
    public String index(ContractOrder contractOrder, Pager<ContractOrder> pager, Model model) {
        contractOrderService.queryContractOrder(contractOrder,pager);
        model.addAttribute("contractOrder",contractOrder);
        model.addAttribute("pager",pager);
        return "order/contract/index";
    }

    @RequestMapping("toAdd.do")
    public String toAdd(Model model) {
        List<OrderContract> orderContractList = orderContractService.selectAllOrderContract();
        List<MenuType> menuTypeList = menuTypeDao.selectAll();
        model.addAttribute("orderContractList", orderContractList);
        model.addAttribute("menuTypeList", menuTypeList);
        return "order/contract/add";
    }


    @RequestMapping("toView.do")
    public String toView(@RequestParam(value = "contractOrderId", required = false) Integer contractOrderId, Model model) {
        ContractOrder contractOrder= contractOrderService.queryContractOrderById(contractOrderId);
        model.addAttribute("contractOrder",contractOrder);
        return "order/contract/view";
    }

    @RequestMapping("add.do")
    @ResponseBody
    public String add(ContractOrder contractOrder) {
        contractOrderService.addContractOrder(contractOrder.getOrderContract(),contractOrder,contractOrder.getContractOrderTerms());
        return "1";
    }


}
