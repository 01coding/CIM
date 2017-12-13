package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.dao.MenuTypeDao;
import team.ruike.cim.dao.TemporaryOrderStateDao;
import team.ruike.cim.pojo.*;
import team.ruike.cim.service.MenuService;
import team.ruike.cim.service.StoreService;
import team.ruike.cim.service.TemporaryOrderService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 临时订单控制器
 *
 * @author 甄立
 * @version 1.0
 */
@Controller
@RequestMapping("temporary/order")
public class TemporaryOrderController {

    @Resource
    private TemporaryOrderService temporaryOrderService;
    @Resource
    private StoreService storeService;
    @Resource
    private MenuService menuService;

    @Resource
    private MenuTypeDao menuTypeDao;//暂无业务类

    @Resource
    private TemporaryOrderStateDao temporaryOrderStateDao;//暂无业务类

    @InitBinder("pager")
    public void initBinder1(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("pager.");
    }

    @InitBinder("temporaryOrder")
    public void initBinder2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("temporaryOrder.");
    }

    @RequestMapping("index.do")
    public String index(Model model) {
        List<TemporaryOrderState> temporaryOrderStateList = temporaryOrderStateDao.selectAll();
        model.addAttribute("temporaryOrderStateList", temporaryOrderStateList);
        return "order/temporary/index";
    }

    @RequestMapping("list.do")
    public String list(TemporaryOrder temporaryOrder, Pager<TemporaryOrder> pager, Model model) {
        temporaryOrderService.queryTemporaryOrder(temporaryOrder, pager);
        model.addAttribute("pager", pager);
        return "order/temporary/list";
    }

    @RequestMapping("toAdd.do")
    public String toAdd(Model model) {
        List<Store> storeList = storeService.queryAllStore();
        List<MenuType> menuTypeList = menuTypeDao.selectAll();
        model.addAttribute("storeList", storeList);
        model.addAttribute("menuTypeList", menuTypeList);
        return "order/temporary/add";
    }

    @RequestMapping("add.do")
    @ResponseBody
    public String add(TemporaryOrder temporaryOrder) {
        temporaryOrderService.addTemporaryOrder(temporaryOrder, temporaryOrder.getTemporaryOrderTerms());
        return "1";
    }


    @RequestMapping("toView.do")
    public String toView(@RequestParam(value = "temporaryOrderId", required = false) Integer temporaryOrderId, Model model) {
        TemporaryOrder temporaryOrder = temporaryOrderService.queryTemporaryOrderById(temporaryOrderId);
        model.addAttribute("temporaryOrder", temporaryOrder);
        return "order/temporary/view";
    }

    @RequestMapping(value = "queryMenu.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryMenu(@RequestParam(value = "menuTypeId") Integer menuTypeId, HttpServletResponse response) {
        response.setContentType("text/xml;charset=utf-8");
        List<Menu> menuList = menuService.selectByMenuTypeId(menuTypeId);
        return menuService.muneSelectionBox(menuList);
    }


}
