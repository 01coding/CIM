package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.StagePurchasingPlanDao;
import team.ruike.cim.pojo.StagePurchasingPlan;
import team.ruike.cim.service.PurchaseService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;

/**
 * 采购业务类
 * @author 张振国
 * @version 1.0
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    @Resource
    private StagePurchasingPlanDao stagePurchasingPlanDao;
    /**
     * 获取周期采购计划列表
     * @param stagePurchasingPlan 计划对象（参数）
     * @param pager 分页辅助类
     */
    @Override
    public void getStagePurchasingPlan(StagePurchasingPlan stagePurchasingPlan, Pager<StagePurchasingPlan> pager) {
        //调用dao查询数据
        pager.setList(stagePurchasingPlanDao.select(stagePurchasingPlan,(pager.getCurrentPage()-1)*pager.getPageSize(),pager.getPageSize()));
    }
}
