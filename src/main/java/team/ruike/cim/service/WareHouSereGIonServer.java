package team.ruike.cim.service;

import team.ruike.cim.pojo.WarehouseRegion;
import team.ruike.cim.util.Pager;

public interface WareHouSereGIonServer {
    /**
     * 分页查询所有区域
     * @param warehouseRegion
     */
    public void getWareHouSereGIonServer(WarehouseRegion warehouseRegion, Pager<WarehouseRegion> pager);

    /**
     * 新增区域
     * @param warehouseRegion
     * @return
     */
    public int addWareHouSereGIonServer(WarehouseRegion warehouseRegion);

    /**
     * 修改区域
     * @param warehouseRegion
     * @return
     */
    public int updWareHouSereGIonServer(WarehouseRegion warehouseRegion);
}
