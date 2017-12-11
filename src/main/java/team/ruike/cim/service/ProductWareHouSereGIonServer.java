package team.ruike.cim.service;

import team.ruike.cim.pojo.ProductWarehouseRegion;
import team.ruike.cim.util.Pager;

public interface ProductWareHouSereGIonServer {

    /**
     * 添加成品区域表
     * @param productWarehouseRegion
     * @return
     */
    public int addProductWareHouSereGIon(ProductWarehouseRegion productWarehouseRegion);

    /**
     * 修改成品区域表
     * @param productWarehouseRegion
     * @return
     */
    public int updProductWareHouSereGIon(ProductWarehouseRegion productWarehouseRegion);

    /**
     * 分页查询成品区域表
     * @param productWarehouseRegion
     * @param pager
     */
     public void getProductWareHouSereGIon(ProductWarehouseRegion productWarehouseRegion, Pager<ProductWarehouseRegion> pager);
}
