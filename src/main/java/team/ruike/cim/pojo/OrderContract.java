package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class OrderContract implements Serializable {

  private static final long serialVersionUID = -3303836210599961526L;
  private Integer orderContractId;
  private String orderContractName;
  private String orderContractImage;
  private String orderContractNo;
  private Date orderContractDate;
  private Integer storeId;
  private Integer status;


  public Integer getOrderContractId() {
    return orderContractId;
  }

  public void setOrderContractId(Integer orderContractId) {
    this.orderContractId = orderContractId;
  }


  public String getOrderContractName() {
    return orderContractName;
  }

  public void setOrderContractName(String orderContractName) {
    this.orderContractName = orderContractName;
  }


  public String getOrderContractImage() {
    return orderContractImage;
  }

  public void setOrderContractImage(String orderContractImage) {
    this.orderContractImage = orderContractImage;
  }


  public String getOrderContractNo() {
    return orderContractNo;
  }

  public void setOrderContractNo(String orderContractNo) {
    this.orderContractNo = orderContractNo;
  }


  public Date getOrderContractDate() {
    return orderContractDate;
  }

  public void setOrderContractDate(Date orderContractDate) {
    this.orderContractDate = orderContractDate;
  }


  public Integer getStoreId() {
    return storeId;
  }

  public void setStoreId(Integer storeId) {
    this.storeId = storeId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
