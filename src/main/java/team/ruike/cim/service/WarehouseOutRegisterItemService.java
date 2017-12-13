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
}
