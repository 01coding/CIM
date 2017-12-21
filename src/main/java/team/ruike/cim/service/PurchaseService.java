package team.ruike.cim.service;

import team.ruike.cim.pojo.StagePurchasingPlan;
import team.ruike.cim.util.Pager;

/**
 * 采购业务接口
 * @author 张振国
 * @version 1.0
 */
public interface PurchaseService {
    /**
     * 获取周期采购计划集合
     * @param stagePurchasingPlan 计划对象（参数）
     * @param pager 分页辅助类
     */
    void getStagePurchasingPlan(StagePurchasingPlan stagePurchasingPlan, Pager<StagePurchasingPlan> pager);
}
