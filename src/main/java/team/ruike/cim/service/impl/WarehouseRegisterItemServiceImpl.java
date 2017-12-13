package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.WarehouseRegisterItemDao;
import team.ruike.cim.pojo.WarehouseRegisterItem;
import team.ruike.cim.service.WarehouseRegisterItemService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;

/**
 * 物料入库记录项
 */
@Service("warehouseRegisterItemService")
public class WarehouseRegisterItemServiceImpl implements WarehouseRegisterItemService {
    @Resource
    private WarehouseRegisterItemDao warehouseRegisterItemDao;

    public int addWarehouseRegisterItem(WarehouseRegisterItem warehouseRegisterItem) {
        if (warehouseRegisterItem.getGoodsShelve() != null && warehouseRegisterItem.getGoodsShelve().getGoodsShelveId() > 0 && warehouseRegisterItem.getMateriel() != null
                && warehouseRegisterItem.getMateriel().getMaterielId() > 0 && warehouseRegisterItem.getMaterielNumber() > 0 && warehouseRegisterItem.getWarehouseRegister() != null && warehouseRegisterItem.getWarehouseRegister().getWarehouseRegisterId() > 0) {
           return warehouseRegisterItemDao.add(warehouseRegisterItem);
        }
        return 0;
    }

    public int updWarehouseRegisterItem(WarehouseRegisterItem warehouseRegisterItem) {
        if (warehouseRegisterItem.getGoodsShelve() != null && warehouseRegisterItem.getGoodsShelve().getGoodsShelveId() > 0 && warehouseRegisterItem.getMateriel() != null
                && warehouseRegisterItem.getMateriel().getMaterielId() > 0 && warehouseRegisterItem.getMaterielNumber() > 0 && warehouseRegisterItem.getWarehouseRegister() != null && warehouseRegisterItem.getWarehouseRegister().getWarehouseRegisterId() > 0) {
            return warehouseRegisterItemDao.update(warehouseRegisterItem);
        }
        return 0;
    }

    public void getWarehouseRegisterItem(WarehouseRegisterItem warehouseRegisterItem, Pager<WarehouseRegisterItem> pager) {
        pager.setTotalRecord(warehouseRegisterItemDao.selectCount(warehouseRegisterItem));
        pager.setList(warehouseRegisterItemDao.select(warehouseRegisterItem,(pager.getCurrentPage() - 1) * pager.getPageSize(), pager.getPageSize()));
    }
}
