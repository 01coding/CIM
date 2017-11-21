package team.ruike.cim.pojo;


import java.util.Date;

public class TemporaryOrder {

  private Integer temporaryOrderId;
  private String temporaryOrderNo;
  private Date temporaryOrderEndDate;
  private Integer temporaryOrderStateId;
  private Date temporaryOrderStartDate;
  private String temporaryOrderRemarks;
  private Integer storeId;
  private Integer userId;
  private Integer status;


  public Integer getTemporaryOrderId() {
    return temporaryOrderId;
  }

  public void setTemporaryOrderId(Integer temporaryOrderId) {
    this.temporaryOrderId = temporaryOrderId;
  }


  public String getTemporaryOrderNo() {
    return temporaryOrderNo;
  }

  public void setTemporaryOrderNo(String temporaryOrderNo) {
    this.temporaryOrderNo = temporaryOrderNo;
  }


  public Date getTemporaryOrderEndDate() {
    return temporaryOrderEndDate;
  }

  public void setTemporaryOrderEndDate(Date temporaryOrderEndDate) {
    this.temporaryOrderEndDate = temporaryOrderEndDate;
  }


  public Integer getTemporaryOrderStateId() {
    return temporaryOrderStateId;
  }

  public void setTemporaryOrderStateId(Integer temporaryOrderStateId) {
    this.temporaryOrderStateId = temporaryOrderStateId;
  }


  public Date getTemporaryOrderStartDate() {
    return temporaryOrderStartDate;
  }

  public void setTemporaryOrderStartDate(Date temporaryOrderStartDate) {
    this.temporaryOrderStartDate = temporaryOrderStartDate;
  }


  public String getTemporaryOrderRemarks() {
    return temporaryOrderRemarks;
  }

  public void setTemporaryOrderRemarks(String temporaryOrderRemarks) {
    this.temporaryOrderRemarks = temporaryOrderRemarks;
  }


  public Integer getStoreId() {
    return storeId;
  }

  public void setStoreId(Integer storeId) {
    this.storeId = storeId;
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

}
