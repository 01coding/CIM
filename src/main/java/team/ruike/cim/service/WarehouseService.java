package team.ruike.cim.service;

import team.ruike.cim.pojo.Warehouse;
import team.ruike.cim.util.Pager;

import java.util.List;

public interface WarehouseService {
    /**
     * 查询所有物料仓库
     * @return
     */
    public List<Warehouse> getwarehouses(Warehouse warehouse,Pager<Warehouse>pager);

    /**
     * 添加物料仓库
     * @param warehouse
     * @return
     */
    public int addwarehouse(Warehouse warehouse);

    /**
     * 修改物料仓库
     * @param warehouse
     * @return
     */
    public int updwarehouse(Warehouse warehouse);

    /**
     * 查询总数
     * @param warehouse
     * @return
     */
    public int count(Warehouse warehouse);
}
