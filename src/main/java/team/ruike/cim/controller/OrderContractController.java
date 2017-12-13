package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import team.ruike.cim.pojo.ContractOrder;
import team.ruike.cim.pojo.OrderContract;
import team.ruike.cim.pojo.Store;
import team.ruike.cim.service.ContractOrderService;
import team.ruike.cim.service.OrderContractService;
import team.ruike.cim.service.StoreService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * 订单合同
 *
 * @author 甄立
 * @version 1.0
 */
@Controller
@RequestMapping("order/contract")
public class OrderContractController {

    @Resource
    private OrderContractService orderContractService;

    @Resource
    private ContractOrderService contractOrderService;

    @Resource
    private StoreService storeService;


    @RequestMapping("index.do")
    public String index(OrderContract orderContract, Pager<OrderContract> pager, Model model) {
        orderContractService.queryOrderContract(orderContract, pager);
        List<Store> storeList = storeService.queryAllStore();
        model.addAttribute("storeList", storeList);
        model.addAttribute("pager", pager);
        model.addAttribute("orderContract", orderContract);
        return "order/contractControl/index";
    }

    @RequestMapping("toEdit.cl")
    public String toEdit(@RequestParam(value = "orderContractId") Integer orderContractId, Model model) {
        OrderContract orderContract = orderContractService.queryOrderContractById(orderContractId);
        List<Store> storeList = storeService.queryAllStore();
        model.addAttribute("storeList", storeList);
        model.addAttribute("orderContract", orderContract);
        return "order/contractControl/edit";
    }

    @RequestMapping("toView.do")
    public String toView(@RequestParam(value = "orderContractId") Integer orderContractId, Model model) {
        OrderContract orderContract = orderContractService.queryOrderContractById(orderContractId);
        ContractOrder contractOrder = contractOrderService.queryContractOrderByContractId(orderContract.getOrderContractId());
        model.addAttribute("contractOrder", contractOrder);
        model.addAttribute("orderContract", orderContract);
        return "order/contractControl/view";
    }

    @RequestMapping("edit.do")
    public String edit(OrderContract orderContract, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        String filePath = upload(file, request);
        if (filePath != null && !filePath.equals("")) {
            orderContract.setOrderContractImage(filePath);
        }
        orderContract.setOrderContractImage("");
        orderContractService.updateOrderContractById(orderContract);
        return "order/contractControl/index";
    }


    @RequestMapping("add.do")
    public String add(OrderContract orderContract, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        String filePath = upload(file, request);
        if (filePath != null &&!filePath.equals("")) {
            orderContract.setOrderContractImage(filePath);
        }
        orderContract.setOrderContractImage("");
        orderContractService.addOrderContract(orderContract);
        return "redirect:/order/contract/index.do";
    }


    public String upload(CommonsMultipartFile file, HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("\\") + "\\upload\\"
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
                return filePath;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
