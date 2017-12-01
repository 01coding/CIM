package team.ruike.cim.service;

import team.ruike.cim.pojo.PurchaseStandardRecord;
import team.ruike.cim.util.Pager;

/**
 * 质量管理系统业务接口
 * @author 华中昊
 * @version 1.0
 */
public interface QualityService {
    void getRecordList(PurchaseStandardRecord purchaseStandardRecord, Pager<PurchaseStandardRecord> pager);
}
