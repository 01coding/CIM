package team.ruike.cim.pojo;


import java.io.Serializable;

public class EquipmentType implements Serializable {

  private static final long serialVersionUID = -8738298441032302623L;
  private Integer equipmentTypeId;
  private String equipmentTypeName;
  private Integer status;


  public Integer getEquipmentTypeId() {
    return equipmentTypeId;
  }

  public void setEquipmentTypeId(Integer equipmentTypeId) {
    this.equipmentTypeId = equipmentTypeId;
  }


  public String getEquipmentTypeName() {
    return equipmentTypeName;
  }

  public void setEquipmentTypeName(String equipmentTypeName) {
    this.equipmentTypeName = equipmentTypeName;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
