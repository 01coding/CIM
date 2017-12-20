package team.ruike.cim.service;

/**
 * Created by Administrator on 2017/12/19.
 */

import team.ruike.cim.pojo.Supplier;
import team.ruike.cim.util.Pager;

/**
 * 供应商管理业务接口
 * @author 王傲祥
 * @version 1.0
 */
public interface SupplierService {
    /**
     * 查询所有供应商信息
     * @param supplier 供应商
     * @param pager 分页辅助类
     */
    void getSupplier(Supplier supplier, Pager<Supplier>pager);
}
