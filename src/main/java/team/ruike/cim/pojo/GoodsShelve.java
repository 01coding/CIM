package team.ruike.cim.pojo;


import java.util.Date;

public class GoodsShelve {

  private Integer goodsShelveId;
  private String goodsShelveNo;
  private Integer materielId;
  private Integer materielNumber;
  private Date materielShelfLifeEndDate;
  private Integer status;
  private Integer warehouseRegionId;


  public Integer getGoodsShelveId() {
    return goodsShelveId;
  }

  public void setGoodsShelveId(Integer goodsShelveId) {
    this.goodsShelveId = goodsShelveId;
  }


  public String getGoodsShelveNo() {
    return goodsShelveNo;
  }

  public void setGoodsShelveNo(String goodsShelveNo) {
    this.goodsShelveNo = goodsShelveNo;
  }


  public Integer getMaterielId() {
    return materielId;
  }

  public void setMaterielId(Integer materielId) {
    this.materielId = materielId;
  }


  public Integer getMaterielNumber() {
    return materielNumber;
  }

  public void setMaterielNumber(Integer materielNumber) {
    this.materielNumber = materielNumber;
  }


  public Date getMaterielShelfLifeEndDate() {
    return materielShelfLifeEndDate;
  }

  public void setMaterielShelfLifeEndDate(Date materielShelfLifeEndDate) {
    this.materielShelfLifeEndDate = materielShelfLifeEndDate;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Integer getWarehouseRegionId() {
    return warehouseRegionId;
  }

  public void setWarehouseRegionId(Integer warehouseRegionId) {
    this.warehouseRegionId = warehouseRegionId;
  }

}
