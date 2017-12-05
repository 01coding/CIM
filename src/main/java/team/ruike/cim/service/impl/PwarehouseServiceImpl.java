package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.ProductWarehouseDao;
import team.ruike.cim.pojo.ProductWarehouse;
import team.ruike.cim.service.PwarehouseService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;

@Service("pwarehouseService")
public class PwarehouseServiceImpl implements PwarehouseService {
    @Resource
    private ProductWarehouseDao productWarehouseDao;

    /**
     * 新增产品出库
     *
     * @param productWarehouse
     * @return
     */
    public int addpwarehouse(ProductWarehouse productWarehouse) {
        if (productWarehouse != null && productWarehouse.getProductWarehouseName() != "" && productWarehouse.getUser() != null && productWarehouse.getUser().getUserId() > 0) {
            return productWarehouseDao.add(productWarehouse);
        }
        return 0;
    }

    /**
     * 修改成品仓库
     *
     * @param productWarehouse
     * @return
     */
    public int updwarehouse(ProductWarehouse productWarehouse) {
        if (productWarehouse != null && productWarehouse.getProductWarehouseName() != "" && productWarehouse.getUser() != null && productWarehouse.getUser().getUserId() > 0) {
            return productWarehouseDao.update(productWarehouse);
        }
        return 0;
    }

    /**
     * 根据条件查询成品仓库
     *
     * @param productWarehouse
     * @param pager
     * @return
     */
    public void getwarehouse(ProductWarehouse productWarehouse, Pager<ProductWarehouse> pager) {
        pager.setTotalRecord(productWarehouseDao.selectCount(productWarehouse));
        List<ProductWarehouse> aa= productWarehouseDao.select(productWarehouse, (pager.getCurrentPage() - 1) * pager.getPageSize(), pager.getPageSize());
        pager.setList(aa);
    }
}
