package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.ProductionStandardDao;
import team.ruike.cim.dao.ProductionStandardRecordDao;
import team.ruike.cim.dao.PurchaseStandardDao;
import team.ruike.cim.dao.PurchaseStandardRecordDao;
import team.ruike.cim.pojo.ProductionStandard;
import team.ruike.cim.pojo.ProductionStandardRecord;
import team.ruike.cim.pojo.PurchaseStandard;
import team.ruike.cim.pojo.PurchaseStandardRecord;
import team.ruike.cim.service.QualityService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 *质量管理系统业务实现类
 * @author 华中昊
 * @version 1.0
 */
@Service("qualityService")
public class QualityServiceImpl implements QualityService {

    @Resource
    private PurchaseStandardRecordDao purchaseStandardRecordDao;

    @Resource
    private ProductionStandardRecordDao productionStandardRecordDao;

    @Resource
    private ProductionStandardDao productionStandardDao;

    @Resource
    private PurchaseStandardDao purchaseStandardDao;


    /**
     *分页查询所有数据
     * @param purchaseStandardRecord
     * @param pager
     */
    public void getRecordList(PurchaseStandardRecord purchaseStandardRecord, Pager<PurchaseStandardRecord> pager) {
        int number=purchaseStandardRecordDao.selectCount(purchaseStandardRecord);
        pager.setTotalRecord(number);
        List<PurchaseStandardRecord> purchaseStandardRecordlist=purchaseStandardRecordDao.select(purchaseStandardRecord,(pager.getCurrentPage() - 1)*pager.getPageSize(), pager.getPageSize());
        pager.setList(purchaseStandardRecordlist);
    }

    /**
     * 品控记录页面跳转  传生产品控评估记录值
     * @param productionStandardRecord
     * @param pager
     */
    public void getRecordProductionList(ProductionStandardRecord productionStandardRecord, Pager<ProductionStandardRecord> pager) {
        int number =productionStandardRecordDao.selectCount(productionStandardRecord);
        pager.setTotalRecord(number);
        List<ProductionStandardRecord> productionStandardRecords=productionStandardRecordDao.select(productionStandardRecord,(pager.getCurrentPage()-1)*pager.getPageSize(),pager.getPageSize());
        pager.setList(productionStandardRecords);
    }

    /**
     * 品控标准页面跳转  传生产品控标准
     * @param productionStandard  生产品控标准
     * @param pager     分页辅助类
     */
    public void getProductionStandard(ProductionStandard productionStandard, Pager<ProductionStandard> pager) {
        int number =productionStandardDao.selectCount(productionStandard);
        pager.setTotalRecord(number);
        List<ProductionStandard> productionStandards=productionStandardDao.select(productionStandard,(pager.getCurrentPage() - 1)*pager.getPageSize(), pager.getPageSize());
        pager.setList(productionStandards);
    }

    /**
     * 品控标准页面跳转  传采购品控标准
     * @param purchaseStandard  采购品控标准
     * @param pager     分页辅助类
     */
    public void getPurchaseStandard(PurchaseStandard purchaseStandard, Pager<PurchaseStandard> pager) {
        int number = purchaseStandardDao.selectCount(purchaseStandard);
        pager.setTotalRecord(number);
        List<PurchaseStandard> purchaseStandards=purchaseStandardDao.select(purchaseStandard,(pager.getCurrentPage() - 1)*pager.getPageSize(), pager.getPageSize());
        pager.setList(purchaseStandards);
    }
}
