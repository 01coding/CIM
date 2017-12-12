package team.ruike.cim.service;

import team.ruike.cim.pojo.WarehouseOutRegister;
import team.ruike.cim.util.Pager;

/**
 * 物料出库记录
 */
public interface WareHouSereGISTerService {
    public int addWareHouseOutRegister(WarehouseOutRegister warehouseOutRegister);

    public int updWareHouseOutRegister(WarehouseOutRegister warehouseOutRegister);

    public void getWarehouseOutRegister(WarehouseOutRegister warehouseOutRegister, Pager<WarehouseOutRegister> pager);
}
