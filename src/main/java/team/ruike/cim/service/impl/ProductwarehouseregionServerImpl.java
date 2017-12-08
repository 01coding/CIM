package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.ProductWarehouseRegionDao;
import team.ruike.cim.pojo.ProductWarehouseRegion;
import team.ruike.cim.service.ProductwarehouseregionServer;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;

@Service("productwarehouseregionServer")
public class ProductwarehouseregionServerImpl implements ProductwarehouseregionServer {
    @Resource
    private ProductWarehouseRegionDao productWarehouseRegionDao;
    /**
     * 添加成品区域表
     *
     * @param productWarehouseRegion
     * @return
     */
    public int addProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion) {
        return 0;
    }

    /**
     * 修改成品区域表
     *
     * @param productWarehouseRegion
     * @return
     */
    public int updProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion) {
        return 0;
    }

    /**
     * 分页查询成品区域表
     *
     * @param productWarehouseRegion
     * @param pager
     */
    public void getProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion, Pager<ProductWarehouseRegion> pager) {
        pager.setTotalRecord(productWarehouseRegionDao.selectCount(productWarehouseRegion));
        pager.setList(productWarehouseRegionDao.select(productWarehouseRegion,(pager.getCurrentPage() - 1)*pager.getPageSize(), pager.getPageSize()));
    }
}
