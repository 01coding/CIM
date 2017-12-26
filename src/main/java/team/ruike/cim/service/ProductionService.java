package team.ruike.cim.service;

import team.ruike.cim.pojo.ContractProductionPlan;

import java.text.ParseException;
import java.util.List;

/**
 * 生产业务接口
 */
public interface ProductionService {
    /**
     * 生成今日合同生产计划
     * @return 今日合同生产计划
     */
    ContractProductionPlan generateContractProductionPlan() throws ParseException;
}
