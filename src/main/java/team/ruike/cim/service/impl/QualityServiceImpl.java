package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.PurchaseStandardRecordDao;
import team.ruike.cim.pojo.PurchaseStandardRecord;
import team.ruike.cim.service.QualityService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;

/**
 *质量管理系统业务实现类
 * @author 华中昊
 * @version 1.0
 */
@Service("qualityService")
public class QualityServiceImpl implements QualityService {

    @Resource
    private PurchaseStandardRecordDao purchaseStandardRecordDao;
    /**
     *
     * @param purchaseStandardRecord
     * @param pager
     */
    public void getRecordList(PurchaseStandardRecord purchaseStandardRecord, Pager<PurchaseStandardRecord> pager) {

    }
}
