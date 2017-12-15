package team.ruike.cim.service;

import team.ruike.cim.pojo.WarehouseRegisterItem;
import team.ruike.cim.util.Pager;

public interface WarehouseRegisterItemService {
     int addWarehouseRegisterItem(WarehouseRegisterItem warehouseRegisterItem);
     int updWarehouseRegisterItem(WarehouseRegisterItem warehouseRegisterItem);
     void getWarehouseRegisterItem(WarehouseRegisterItem warehouseRegisterItem, Pager<WarehouseRegisterItem> pager);

     /**
      * 根据仓库id查询所有记录
      * @param warehouseRegisterItem
      * @param pager
      */
     void getWarehouseRegisterItemByWarehouseId(WarehouseRegisterItem warehouseRegisterItem, Pager<WarehouseRegisterItem> pager);
}
