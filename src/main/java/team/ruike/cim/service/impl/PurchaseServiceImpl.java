package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.PurchaseDao;
import team.ruike.cim.dao.StagePurchasingPlanDao;
import team.ruike.cim.dao.StagePurchasingPlanTermDao;
import team.ruike.cim.pojo.Purchase;
import team.ruike.cim.pojo.StagePurchasingPlan;
import team.ruike.cim.pojo.StagePurchasingPlanTerm;
import team.ruike.cim.service.PurchaseService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * 采购业务类
 * @author 张振国
 * @version 1.0
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    @Resource
    private StagePurchasingPlanDao stagePurchasingPlanDao;
    @Resource
    private StagePurchasingPlanTermDao stagePurchasingPlanTermDao;
    @Resource
    private PurchaseDao purchaseDao;
    /**
     * 获取周期采购计划列表
     * @param stagePurchasingPlan 计划对象（参数）
     * @param pager 分页辅助类
     */
    @Override
    public void getStagePurchasingPlans(StagePurchasingPlan stagePurchasingPlan, Pager<StagePurchasingPlan> pager) {
        //调用dao查询数据
        pager.setTotalRecord(stagePurchasingPlanDao.selectCount(stagePurchasingPlan));
        pager.setList(stagePurchasingPlanDao.select(stagePurchasingPlan,(pager.getCurrentPage()-1)*pager.getPageSize(),pager.getPageSize()));
    }

    @Override
    public StagePurchasingPlan getStagePurchasingPlan(Integer stagePurchasingPlanId) {
        return stagePurchasingPlanDao.selectById(stagePurchasingPlanId);
    }

    /**
     * 修改计划信息
     * @param stagePurchasingPlan 计划id
     * @param items 计划项集合
     */
    @Override
    public void updateStagePurchasingPlan(StagePurchasingPlan stagePurchasingPlan, List<StagePurchasingPlanTerm> items) {
        //1.修改计划信息
        StagePurchasingPlan stagePurchasingPlan1 = stagePurchasingPlanDao.selectById(stagePurchasingPlan.getStagePurchasingPlanId());
        stagePurchasingPlan.setUser(stagePurchasingPlan1.getUser());
        stagePurchasingPlan.setStatus(0);
        stagePurchasingPlanDao.update(stagePurchasingPlan);
        //2.删除计划项
        stagePurchasingPlanTermDao.delStagePurchasingPlanTermBysId(stagePurchasingPlan.getStagePurchasingPlanId());
        //3.重新添加计划项
        for (StagePurchasingPlanTerm item : items) {
            stagePurchasingPlanTermDao.add(item);
        }
    }

    /**
     * 获取所有采购列表
     * @param purchase 采购对象（参数）
     * @param pager 分页辅助类
     */
    @Override
    public void getPurchase(Purchase purchase, Pager<Purchase> pager) {
        pager.setTotalRecord(purchaseDao.selectCount(purchase));
        pager.setList(purchaseDao.select(purchase,(pager.getCurrentPage()-1)*pager.getPageSize(),pager.getPageSize()));
    }
}
