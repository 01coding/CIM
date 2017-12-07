package team.ruike.cim.service;

import team.ruike.cim.pojo.WarehouseRegion;
import team.ruike.cim.util.Pager;

public interface WarehouseregionServer {
    /**
     * 分页查询所有区域
     * @param warehouseRegion
     */
    public void getWarehouseregionServer(WarehouseRegion warehouseRegion, Pager<WarehouseRegion> pager);

    /**
     * 新增区域
     * @param warehouseRegion
     * @return
     */
    public int addWarehouseregionServer(WarehouseRegion warehouseRegion);

    /**
     * 修改区域
     * @param warehouseRegion
     * @return
     */
    public int updWarehouseregionServer(WarehouseRegion warehouseRegion);
}
