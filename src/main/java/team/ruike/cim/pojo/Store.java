package team.ruike.cim.pojo;


import java.io.Serializable;

public class Store implements Serializable {

  private static final long serialVersionUID = -7009722609581777683L;
  private Integer storeId;
  private String storeName;
  private Integer storeType;
  private String storeAddress;
  private String storePhone;
  private Integer storeOrderNumber;
  private Integer storeNo;
  private String password;
  private Integer status;


  public Integer getStoreId() {
    return storeId;
  }

  public void setStoreId(Integer storeId) {
    this.storeId = storeId;
  }


  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }


  public Integer getStoreType() {
    return storeType;
  }

  public void setStoreType(Integer storeType) {
    this.storeType = storeType;
  }


  public String getStoreAddress() {
    return storeAddress;
  }

  public void setStoreAddress(String storeAddress) {
    this.storeAddress = storeAddress;
  }


  public String getStorePhone() {
    return storePhone;
  }

  public void setStorePhone(String storePhone) {
    this.storePhone = storePhone;
  }


  public Integer getStoreOrderNumber() {
    return storeOrderNumber;
  }

  public void setStoreOrderNumber(Integer storeOrderNumber) {
    this.storeOrderNumber = storeOrderNumber;
  }


  public Integer getStoreNo() {
    return storeNo;
  }

  public void setStoreNo(Integer storeNo) {
    this.storeNo = storeNo;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
