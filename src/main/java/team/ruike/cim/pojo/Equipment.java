package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class Equipment implements Serializable {

  private static final long serialVersionUID = 4233770308844199286L;
  private Integer equipmentId;
  private Integer productionLineId;
  private Integer workingId;
  private Integer userId;
  private Date startDate;
  private Integer equipmentTypeId;
  private Integer maintenanceCycle;
  private Integer inspectionCycle;
  private String equipmentName;
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
