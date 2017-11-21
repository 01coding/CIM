package team.ruike.cim.pojo;


import java.io.Serializable;

public class WarehouseRegion implements Serializable {

  private static final long serialVersionUID = -413071175503456395L;
  private Integer warehouseRegionId;
  private String warehouseRegionNo;
  private Integer materielTypeLevelBId;
  private String remarks;
  private String status;
  private Integer warehouseId;


  public Integer getWarehouseRegionId() {
    return warehouseRegionId;
  }

  public void setWarehouseRegionId(Integer warehouseRegionId) {
    this.warehouseRegionId = warehouseRegionId;
  }


  public String getWarehouseRegionNo() {
    return warehouseRegionNo;
  }

  public void setWarehouseRegionNo(String warehouseRegionNo) {
    this.warehouseRegionNo = warehouseRegionNo;
  }


  public Integer getMaterielTypeLevelBId() {
    return materielTypeLevelBId;
  }

  public void setMaterielTypeLevelBId(Integer materielTypeLevelBId) {
    this.materielTypeLevelBId = materielTypeLevelBId;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public Integer getWarehouseId() {
    return warehouseId;
  }

  public void setWarehouseId(Integer warehouseId) {
    this.warehouseId = warehouseId;
  }

}
