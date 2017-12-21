package team.ruike.cim.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.dao.MaterielDao;
import team.ruike.cim.pojo.Materiel;
import team.ruike.cim.pojo.StagePurchasingPlan;
import team.ruike.cim.pojo.StagePurchasingPlanTerm;
import team.ruike.cim.pojo.Supplier;
import team.ruike.cim.service.MaterielService;
import team.ruike.cim.service.PurchaseService;
import team.ruike.cim.service.SupplierService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private MaterielService materielService;
    @Resource
    private SupplierService supplierService;
    /**
     * 跳转周期采购计划页面并查询数据
     * @param stagePurchasingPlan 周期采购计划（参数）
     * @param pager 分页辅助类
     * @param request request
     * @return 计划页面
     */
    @RequestMapping("stagePurchasingPlan.do")
    public String stagePurchasingPlan(StagePurchasingPlan stagePurchasingPlan, Pager<StagePurchasingPlan> pager, HttpServletRequest request){
        purchaseService.getStagePurchasingPlans(stagePurchasingPlan,pager);
        request.setAttribute("pager",pager);
        return "purchase/stagepurchasingplan";
    }

    /**
     * 获取周期计划详细信息
     * @param stagePurchasingPlanId 计划id
     * @param request request
     * @return 修改页面
     */
    @RequestMapping("stagePurchasingPlan.cl")
    public String stagePurchasingPlanById(Integer stagePurchasingPlanId,HttpServletRequest request){
        request.setAttribute("plan",purchaseService.getStagePurchasingPlan(stagePurchasingPlanId));
        //查询供应商
        Pager<Supplier> supplierPager=new Pager<Supplier>();
        supplierPager.setCurrentPage(1);
        supplierPager.setPageSize(1000);
        supplierService.getSupplier(new Supplier(),supplierPager);//获取供应商集合
        request.setAttribute("suppliers",supplierPager.getList());
        //查询物料
        Pager<Materiel> pager=new Pager<Materiel>();
        pager.setCurrentPage(1);
        pager.setPageSize(1000);
        materielService.getMaterielList(new Materiel(),pager);//获取物料集合
        request.setAttribute("materiels",pager.getList());
        return "purchase/updstagepurchasingplan";
    }
    @ResponseBody
    @RequestMapping("updStagePurchasingPlan.do")
    public String updStagePurchasingPlan(StagePurchasingPlan stagePurchasingPlan,String stagePurchasingPlanTerms){
            List<StagePurchasingPlanTerm> items=new ArrayList<StagePurchasingPlanTerm>();
            JSONArray array = JSONArray.fromObject(stagePurchasingPlanTerms);
            for (Object o : array) {
                items.add((StagePurchasingPlanTerm) (JSONObject.toBean(JSONObject.fromObject(o), StagePurchasingPlanTerm.class)));
            }
            purchaseService.updateStagePurchasingPlan(stagePurchasingPlan,items);
            return true+"";
    }
}
