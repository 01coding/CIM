package team.ruike.cim.service;

import team.ruike.cim.pojo.ProductWarehouseRegion;
import team.ruike.cim.util.Pager;

public interface ProductwarehouseregionServer {

    /**
     * 添加成品区域表
     * @param productWarehouseRegion
     * @return
     */
    public int addProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion);

    /**
     * 修改成品区域表
     * @param productWarehouseRegion
     * @return
     */
    public int updProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion);

    /**
     * 分页查询成品区域表
     * @param productWarehouseRegion
     * @param pager
     */
     public void getProductwarehouseregion(ProductWarehouseRegion productWarehouseRegion, Pager<ProductWarehouseRegion> pager);
}
