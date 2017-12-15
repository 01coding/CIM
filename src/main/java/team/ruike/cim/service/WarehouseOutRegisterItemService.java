package team.ruike.cim.service;

import team.ruike.cim.pojo.WarehouseOutRegisterItem;
import team.ruike.cim.util.Pager;

/**
 * 出库记录项
 */
public interface WarehouseOutRegisterItemService {
     int addWarehouseOutRegisterItem(WarehouseOutRegisterItem warehouseOutRegisterItem);

     int upd(WarehouseOutRegisterItem warehouseOutRegisterItem);

     void getWarehouseOutRegisterItem(WarehouseOutRegisterItem warehouseOutRegisterItem, Pager<WarehouseOutRegisterItem> pager);

     /**
      * 根据仓库id查询所有出库项
      * @param warehouseOutRegisterItem
      * @param pager
      */
     void getOutRegisterItemByWarehouseId(WarehouseOutRegisterItem warehouseOutRegisterItem, Pager<WarehouseOutRegisterItem> pager);
}
