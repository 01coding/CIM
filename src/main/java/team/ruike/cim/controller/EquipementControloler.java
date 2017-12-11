package team.ruike.cim.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.pojo.*;
import team.ruike.cim.service.EquipementService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
     * @param pager
     * @param request
     * @param equipmentType
     * @param working
     * @param productionLine
     * @param user
     * @return
     */
    @RequestMapping("/equipment.do")
    public String  equipment(@RequestParam(value = "ms",required = false)Integer ms, Equipment equipment, Pager<Equipment> pager, HttpServletRequest request, EquipmentType equipmentType, Working working, ProductionLine productionLine, User user){
        if (ms!=null&&ms==1){
            System.out.print(ms);
        }
        equipementService.getEquipment(equipment, pager);
        request.setAttribute("equipments",pager.getList());
        request.setAttribute("equipmentTypes",equipementService.getEquipmentType(equipmentType));
        request.setAttribute("workings",equipementService.getWorking(working));
        request.setAttribute("productionLines",equipementService.getProductionLine(productionLine));
        request.setAttribute("users",equipementService.getUser(user));
        return "equipement/equipment";
    }


    /**
     * 根据ID查询设备信息并绑定修改弹框
     * @param equipmentId  设备ID
     * @param response 转发
     */
    @RequestMapping("/equipmentReportByID.do")
    @ResponseBody
    public void equipmentReportByID(Integer equipmentId,HttpServletResponse response){
            Equipment equipment= equipementService.getEquipmentReportByID(equipmentId);
            String er= JSON.toJSON(equipment).toString();
        try {
            //设置页面不缓存
            response.setContentType("application/json");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out= null;
            out = response.getWriter();
            out.print(er);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改设备信息
     * @param equipment 谁被对象
     * @return 是否成功
     */
    @RequestMapping("/updateMateriel.do")
    public String updateMateriels(Equipment equipment){
        int num = equipementService.updateEquipment(equipment);
        if (num==0){
            return"redirect:/equipment.do?ms=1";
        }else {
            return "redirect:/equipment.do";
        }
    }
    /**
     * 删除设备
     * @param equipment
     * @return
     */
    @RequestMapping("/delMateriel.do")
    public String delMateriel(Equipment equipment ){
        return equipementService.deleteEquipment(equipment)+"";
    }
    /**
     * 查询所有异常信息
     * @param equipmentReport 异常对象
     * @param pager 分页辅助类
     * @param request 转发
     * @return 异常集合
     */
    @RequestMapping("/equipmentreport.do")
    public String equipmentreport(EquipmentReport equipmentReport,Pager<EquipmentReport> pager, HttpServletRequest request){
        equipementService.getEquipmentReport(equipmentReport,pager);
        request.setAttribute("equipmentReports",pager.getList());
        return "equipement/equipmentreport";
    }

    /**
     * 查询所有状态
     * @param equipmentType 状态
     * @param pager 分页辅助类
     * @param request 转发
     * @return 状态集合
     */
    @RequestMapping("/equipmentType.do")
    public String equipmentType(EquipmentType equipmentType,Pager<EquipmentType> pager,HttpServletRequest request){

        return "equipement/equipment";
    }

    /**
     * 跳转新增设备页面
     * @return
     */
    @RequestMapping("/addequipement.do")
    public String addequipement(){
        return "equipement/addequipement";
    }

    /**
     * 跳转新增设备异常页面
     * @return
     */
    @RequestMapping("/addequipmentreport.do")
    public String addequipmentreport(){
        return "equipement/addequipmentreport";
    }
}
