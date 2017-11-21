package team.ruike.cim.pojo;


import java.util.Date;

public class EquipmentReport {

  private Integer equipmentReportId;
  private Integer equipmentReportReason;
  private String maintenancePlan;
  private Date endDate;
  private Integer userId;
  private Integer status;
  private Integer equipmentId;


  public Integer getEquipmentReportId() {
    return equipmentReportId;
  }

  public void setEquipmentReportId(Integer equipmentReportId) {
    this.equipmentReportId = equipmentReportId;
  }


  public Integer getEquipmentReportReason() {
    return equipmentReportReason;
  }

  public void setEquipmentReportReason(Integer equipmentReportReason) {
    this.equipmentReportReason = equipmentReportReason;
  }


  public String getMaintenancePlan() {
    return maintenancePlan;
  }

  public void setMaintenancePlan(String maintenancePlan) {
    this.maintenancePlan = maintenancePlan;
  }


  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Integer getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(Integer equipmentId) {
    this.equipmentId = equipmentId;
  }

}
