package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.pojo.Store;
import team.ruike.cim.service.StoreService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;

/**
 * @author 甄立
 * @version 1.0
 */
@Controller
@RequestMapping("store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @RequestMapping("index.do")
    public String index() {
        return "order/store/index";
    }

    @RequestMapping("list.do")
    public String list(Store store, Pager<Store> pager, Model model) {
        storeService.queryStore(store, pager);
        model.addAttribute("pager", pager);
        return "order/store/list";
    }

    @RequestMapping("add.do")
    @ResponseBody
    public String add(Store store) {
        storeService.addStore(store);
        return "1";
    }

    @RequestMapping("toEdit.do")
    public String toEdit(Integer storeId, Model model) {
        Store store = storeService.queryStoreById(storeId);
        model.addAttribute("store", store);
        return "order/store/edit";
    }

    @RequestMapping("edit.do")
    @ResponseBody
    public String edit(Store store, Model model) {
        storeService.updateStoreById(store);
        return "1";
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public String delete(Integer storeId) {
        storeService.deleteStoreById(storeId);
        return "1";
    }

    @RequestMapping("toView.do")
    public String toView(Integer storeId, Model model) {
        Store store = storeService.queryStoreById(storeId);
        model.addAttribute("store", store);
        return "order/store/view";
    }


}
