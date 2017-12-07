package team.ruike.cim.service.impl;


import org.springframework.stereotype.Service;
import team.ruike.cim.dao.WarehouseRegionDao;
import team.ruike.cim.pojo.WarehouseRegion;
import team.ruike.cim.service.WarehouseregionServer;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;

@Service("warehouseregionServer")
public class WarehouseregionServerImpl implements WarehouseregionServer {
    @Resource
    private WarehouseRegionDao warehouseRegionDao;

    /**
     * 查询所有区域
     *
     * @param warehouseRegion
     * @param pager
     */
    public void getWarehouseregionServer(WarehouseRegion warehouseRegion, Pager<WarehouseRegion> pager) {
        pager.setTotalRecord(warehouseRegionDao.selectCount(warehouseRegion));
        pager.setList(warehouseRegionDao.select(warehouseRegion, (pager.getCurrentPage() - 1) * pager.getPageSize(), pager.getPageSize()));
    }

    /**
     * 新增区域
     *
     * @param warehouseRegion
     * @return
     */
    public int addWarehouseregionServer(WarehouseRegion warehouseRegion) {
        if (warehouseRegion != null && warehouseRegion.getMaterielTypeLevelB().getMaterielTypeLevelBId() > 0) {
            return warehouseRegionDao.add(warehouseRegion);
        }
        return 0;
    }

    /**
     * 修改区域
     *
     * @param warehouseRegion
     * @return
     */
    public int updWarehouseregionServer(WarehouseRegion warehouseRegion) {
        if (warehouseRegion != null && warehouseRegion.getMaterielTypeLevelB().getMaterielTypeLevelBId() > 0) {
            return warehouseRegionDao.update(warehouseRegion);
        }
        return 0;
    }
}
