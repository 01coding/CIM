package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.service.ContractProductionPlanService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 生产业务控制器
 * @author 张振国
 * @version 1.0
 */
@Controller
public class ProductionController {
    @Resource
    private ContractProductionPlanService contractProductionPlanService;

    /**
     * 跳转生产计划项任务分配页面
     * @param contractProductionPlanItemId 合同订单生产计划项id
     * @param temporaryProductionPlanItemId 临时生产计划项id
     * @param request request
     * @return 生产计划项任务分配页面
     */
    @RequestMapping("/product.do")
    private String product(Integer contractProductionPlanItemId, Integer temporaryProductionPlanItemId, HttpServletRequest request){
        //判断查询的是哪种任务分配
        if (contractProductionPlanItemId!=null&&contractProductionPlanItemId>0){
            request.setAttribute("cps",contractProductionPlanService.getContractProductionDistributions(contractProductionPlanItemId));
            request.setAttribute("citem",contractProductionPlanService.getContractProductionPlanItem(contractProductionPlanItemId));
        }else if (temporaryProductionPlanItemId!=null&&temporaryProductionPlanItemId>0){

        }
        return "product";
    }

}
