package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 合同订单类
 * @author 张振国
 * @version 1.0
 */
public class ContractOrder implements Serializable{
  private static final long serialVersionUID = 7490050891725847244L;
  private Integer contractOrderId;
  private String contractOrderNo;
  private Date contractOrderEndDate;
  private Integer contractOrderState;
  private Date contractOrderStartDate;
  private Integer orderContractId;
  private Integer userId;
  private String contractOrderRemarks;
  private Integer status;


  public Integer getContractOrderId() {
    return contractOrderId;
  }

  public void setContractOrderId(Integer contractOrderId) {
    this.contractOrderId = contractOrderId;
  }


  public String getContractOrderNo() {
    return contractOrderNo;
  }

  public void setContractOrderNo(String contractOrderNo) {
    this.contractOrderNo = contractOrderNo;
  }


  public Date getContractOrderEndDate() {
    return contractOrderEndDate;
  }

  public void setContractOrderEndDate(Date contractOrderEndDate) {
    this.contractOrderEndDate = contractOrderEndDate;
  }


  public Integer getContractOrderState() {
    return contractOrderState;
  }

  public void setContractOrderState(Integer contractOrderState) {
    this.contractOrderState = contractOrderState;
  }


  public Date getContractOrderStartDate() {
    return contractOrderStartDate;
  }

  public void setContractOrderStartDate(Date contractOrderStartDate) {
    this.contractOrderStartDate = contractOrderStartDate;
  }


  public Integer getOrderContractId() {
    return orderContractId;
  }

  public void setOrderContractId(Integer orderContractId) {
    this.orderContractId = orderContractId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getContractOrderRemarks() {
    return contractOrderRemarks;
  }

  public void setContractOrderRemarks(String contractOrderRemarks) {
    this.contractOrderRemarks = contractOrderRemarks;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
