package team.ruike.cim.service;

import team.ruike.cim.pojo.GoodsShelve;

import java.util.List;

public interface GoodSShelveService {
    /**
     * 查询物料货架
     * @param goodsShelve
     *
     */
     List<GoodsShelve> getGoodsshelve(GoodsShelve goodsShelve);

    /**
     * 新增物料货架
     * @param goodsShelve
     * @return
     */
     int addGoods_shelve(GoodsShelve goodsShelve);

    /**
     * 修改物料货架
     * @param goodsShelve
     * @return
     */
     int updGoods_shelve(GoodsShelve goodsShelve);

     List<GoodsShelve> selectByWarehouseRegionId(Integer warehouseRegionId);
}
