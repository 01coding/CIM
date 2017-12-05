package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.Equipment;
import team.ruike.cim.pojo.EquipmentReport;
import team.ruike.cim.service.EquipementService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/12/5.
 */
@Controller
public class EquipementControloler {
    @Resource
    private EquipementService equipementService;

    /**
     * 查询所有设备信息
     * @param equipment 设备表
     * @param pager 分页辅助类
     * @param request 转发
     * @return 设备集合
     */
    @RequestMapping("/equipment.do")
    public String  equipment(Equipment equipment, Pager<Equipment> pager, HttpServletRequest request){
        equipementService.getEquipment(equipment, pager);
        request.setAttribute("equipments",pager.getList());
        return "equipement/equipment";
    }

    @RequestMapping("/equipmentreport.do")
    public String equipmentreport(EquipmentReport equipmentReport,Pager<EquipmentReport> pager, HttpServletRequest request){
        equipementService.getEquipmentReport(equipmentReport,pager);
        request.setAttribute("equipmentReports",pager.getList());

        return "equipement/equipmentreport";
    }

    @RequestMapping("/addequipement.do")
    public String addequipement(){
        return "equipement/addequipement";
    }

    @RequestMapping("/addequipmentreport.do")
    public String addequipmentreport(){
        return "equipement/addequipmentreport";
    }
}
