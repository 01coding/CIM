package team.ruike.cim.service;

import team.ruike.cim.pojo.WarehouseRegister;
import team.ruike.cim.util.Pager;

/**
 * 物料入库记录接口
 */
public interface WarehouseRegisterSevice {

     int addWarehouseRegister(WarehouseRegister warehouseRegister);

     int upd(WarehouseRegister warehouseRegister);

     void getWarehouseRegister(WarehouseRegister warehouseRegister, Pager<WarehouseRegister> warehouseRegisterPager);
}
