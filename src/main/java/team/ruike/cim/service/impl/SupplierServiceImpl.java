package team.ruike.cim.service.impl;

/**
 * Created by Administrator on 2017/12/19.
 */

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.SupplierDao;
import team.ruike.cim.pojo.Supplier;
import team.ruike.cim.service.SupplierService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * 供应商管理实现类
 * @author 王傲祥
 * @version 1.0
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService{
    @Resource
    private SupplierDao supplierDao;
    /**
     * 查询所有供应商信息
     * @param supplier 供应商
     * @param pager 分页辅助类
     */
    @Override
    public void getSupplier(Supplier supplier, Pager<Supplier> pager) {
        pager.setTotalRecord(supplierDao.selectCount(supplier));
        List<Supplier> supplierList=supplierDao.select(supplier,(pager.getCurrentPage()- 1) * pager.getPageSize(), pager.getPageSize());
        pager.setList(supplierList);
    }
}
