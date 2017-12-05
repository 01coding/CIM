package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.Store;
import team.ruike.cim.service.StoreService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;

@Controller
@RequestMapping("store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @RequestMapping("index.do")
    public String index(){
        return "order/store/index";
    }

    @RequestMapping("list.do")
    public String list(Store store, Pager<Store> pager, Model model){
        storeService.queryStore(store,pager);
        model.addAttribute("pager",pager);
        return  "order/store/list";
    }
}
