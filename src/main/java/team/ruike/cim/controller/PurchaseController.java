package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.StagePurchasingPlan;
import team.ruike.cim.service.PurchaseService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 采购业务控制器
 * @author 张振国
 * @version 1.0
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Resource
    private PurchaseService purchaseService;
    /**
     * 跳转周期采购计划页面并查询数据
     * @param stagePurchasingPlan 周期采购计划（参数）
     * @param pager 分页辅助类
     * @param request request
     * @return 计划页面
     */
    @RequestMapping("stagePurchasingPlan.do")
    public String stagePurchasingPlan(StagePurchasingPlan stagePurchasingPlan, Pager<StagePurchasingPlan> pager, HttpServletRequest request){
        purchaseService.getStagePurchasingPlan(stagePurchasingPlan,pager);
        request.setAttribute("pager",pager);
        return "purchase/stagepurchasingplan";
    }

}
