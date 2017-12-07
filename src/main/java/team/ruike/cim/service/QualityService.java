package team.ruike.cim.service;

import team.ruike.cim.pojo.ProductionStandard;
import team.ruike.cim.pojo.ProductionStandardRecord;
import team.ruike.cim.pojo.PurchaseStandard;
import team.ruike.cim.pojo.PurchaseStandardRecord;
import team.ruike.cim.util.Pager;

/**
 * 质量管理系统业务接口
 * @author 华中昊
 * @version 1.0
 */
public interface QualityService {
    /**
     * 品控记录页面跳转  传采购品控评估记录值
     * @param purchaseStandardRecord 采购品控记录对象
     * @param pager 分页辅助类
     */
    void getRecordList(PurchaseStandardRecord purchaseStandardRecord, Pager<PurchaseStandardRecord> pager);

    /**
     * 品控记录页面跳转  传生产品控评估记录值
     * @param productionStandardRecord  生产品控对象
     * @param pager 分页辅助类
     */
    void getRecordProductionList(ProductionStandardRecord productionStandardRecord,Pager<ProductionStandardRecord> pager);

    /**
     * 品控标准页面跳转  传生产品控标准
     * @param productionStandard  生产品控标准
     * @param pager     分页辅助类
     */
    void getProductionStandard(ProductionStandard productionStandard,Pager<ProductionStandard> pager);

    /**
     * 品控标准页面跳转  传采购品控标准
     * @param purchaseStandard  采购品控标准
     * @param pager     分页辅助类
     */
    void getPurchaseStandard(PurchaseStandard purchaseStandard,Pager<PurchaseStandard> pager);


}
