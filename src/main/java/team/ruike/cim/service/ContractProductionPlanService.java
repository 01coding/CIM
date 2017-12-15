package team.ruike.cim.service;

import team.ruike.cim.pojo.ContractProductionPlan;

import java.text.ParseException;
import java.util.List;

/**
 * 生产系统业务接口
 */
public interface ContractProductionPlanService {
    /**
     * 获取今日生产计划
     * @return 今日生产计划集合
     */
    List<ContractProductionPlan> getDayContractProductionPlans() throws ParseException;
}
