package team.ruike.cim.service;

import team.ruike.cim.pojo.Equipment;
import team.ruike.cim.pojo.EquipmentReport;
import team.ruike.cim.util.Pager;

/**
 * Created by Administrator on 2017/12/5.
 */

/**
 * 设备管理业务接口
 * @author 王傲祥
 * @version 1.0
 */
public interface EquipementService {
    /**
     * 获取所有设备信息
     * @param equipment 设备
     * @param pager 分页辅助类
     */
    void getEquipment(Equipment equipment, Pager<Equipment> pager);

    /**
     * 获取所有异常报告
     * @param equipmentReport 异常表
     * @param pager 分页辅助类
     */
    void getEquipmentReport(EquipmentReport equipmentReport,Pager<EquipmentReport> pager);
}
