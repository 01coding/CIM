package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 设备
 * @author 张振国
 * @version 1.0
 */
public class Equipment implements Serializable {

    private static final long serialVersionUID = 4233770308844199286L;
    /**
     * 设备id
     */
    private Integer equipmentId;
    /**
     * 所属生产线id外键
     */
    private Integer productionLineId;
    /**
     * 所属工序id外键
     */
    private Integer workingId;
    /**
     * 设备负责人id
     */
    private Integer userId;
    /**
     * 启用时间
     */
    private Date startDate;
    /**
     * 设备状态id外键
     */
    private Integer equipmentTypeId;
    /**
     *保养周期(天)
     */
    private Integer maintenanceCycle;
    /**
     * 检查周期(天)
     */
    private Integer inspectionCycle;
    /**
     * 设备名称
     */
    private String equipmentName;
    /**
     * 删除状态
     */
    private Integer status;


    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }


    public Integer getProductionLineId() {
        return productionLineId;
    }

    public void setProductionLineId(Integer productionLineId) {
        this.productionLineId = productionLineId;
    }


    public Integer getWorkingId() {
        return workingId;
    }

    public void setWorkingId(Integer workingId) {
        this.workingId = workingId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Integer getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Integer equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }


    public Integer getMaintenanceCycle() {
        return maintenanceCycle;
    }

    public void setMaintenanceCycle(Integer maintenanceCycle) {
        this.maintenanceCycle = maintenanceCycle;
    }


    public Integer getInspectionCycle() {
        return inspectionCycle;
    }

    public void setInspectionCycle(Integer inspectionCycle) {
        this.inspectionCycle = inspectionCycle;
    }


    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
