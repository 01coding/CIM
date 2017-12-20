package team.ruike.cim.service.impl;

/**
 * Created by Administrator on 2017/12/19.
 */

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.MaterielTypeLevelBDao;
import team.ruike.cim.dao.SupplierDao;
import team.ruike.cim.pojo.MaterielTypeLevelB;
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
    @Resource
    private MaterielTypeLevelBDao materielTypeLevelBDao;
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

    /**
     * 删除供应商
     * @param supplierId 供应商id
     * @return
     */
    @Override
    public int delectSupplier(int supplierId) {
        Supplier supplier=new Supplier();
        supplier.setSupplierId(supplierId);
        List<Supplier> supplierList=supplierDao.select(supplier,0,99);
        supplier=supplierList.get(0);
        supplier.setStatus(1);
        return supplierDao.update(supplier);
    }


    /**
     * 查询所有二级类型
     * @param materielTypeLevelB 二级类型
     * @return 二级类型集合
     */
    @Override
    public List<MaterielTypeLevelB> getMaterielTypeLevelB(MaterielTypeLevelB materielTypeLevelB) {
        return materielTypeLevelBDao.select(materielTypeLevelB,0,99);
    }

    /**
     * 添加供应商
     * @param supplier 供应商
     * @return
     */
    @Override
    public int addSupplier(Supplier supplier) {
        supplier.setStatus(0);
       /* if (supplier.getCooperationStartDate()!=null && supplier.getMaterielTypeLevelB()!=null && supplier.getMaterielTypeLevelB().getMaterielTypeLevelBId()>0
                && supplier.getSupplierAddress()!=null && supplier.getSupplierAddress()!=""
                && supplier.getSupplierCharterImage()!=null && supplier.getSupplierId()!=null
                && supplier.getSupplierId()>0 && supplier.getSupplierImage()!=null && supplier.getSupplierName()!=null
                && supplier.getSupplierName()!="" && supplier.getSupplierNo()!=null && supplier.getSupplierNo()!=""
                && supplier.getSupplierPhone()!=null && supplier.getSupplierPhone()!=""){*/
            return supplierDao.add(supplier);
        /*}
        return 0;*/
    }
}
