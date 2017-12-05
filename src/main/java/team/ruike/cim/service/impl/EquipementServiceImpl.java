package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.EquipmentDao;
import team.ruike.cim.dao.EquipmentReportDao;
import team.ruike.cim.pojo.Equipment;
import team.ruike.cim.pojo.EquipmentReport;
import team.ruike.cim.service.EquipementService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */
@Service("equipementService")
public class EquipementServiceImpl implements EquipementService {
    @Resource
    private EquipmentDao equipmentDao;
    @Resource
    private EquipmentReportDao equipmentReportDao;

    /**
     * 获取所有设备信息
     * @param equipment 设备表
     * @param pager 分页辅助类
     */
    public void getEquipment(Equipment equipment, Pager<Equipment> pager) {
        pager.setTotalRecord(equipmentDao.selectCount(equipment));
        List<Equipment> equipmentList=equipmentDao.select(equipment,(pager.getCurrentPage()- 1) * pager.getPageSize(), pager.getPageSize());
        pager.setList(equipmentList);
    }

    /**
     * 获取所有异常信息
     * @param equipmentReport 异常表
     * @param pager 分页辅助类
     */
    public void getEquipmentReport(EquipmentReport equipmentReport, Pager<EquipmentReport> pager) {
        pager.setTotalRecord(equipmentReportDao.selectCount(equipmentReport));
        List<EquipmentReport> equipmentReportList=equipmentReportDao.select(equipmentReport,(pager.getCurrentPage()- 1) * pager.getPageSize(), pager.getPageSize());
        pager.setList(equipmentReportList);
    }
}
