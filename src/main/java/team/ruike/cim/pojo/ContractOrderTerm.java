package team.ruike.cim.pojo;


import java.io.Serializable;

public class ContractOrderTerm implements Serializable {
  private static final long serialVersionUID = 5130589157821751599L;
  private Integer contractOrderTermId;
  private Integer menuId;
  private Integer menuNumber;
  private Integer completeNumber;
  private Integer contractOrderTermState;
  private String productBatch;
  private Integer contractOrderId;
  private Integer status;


  public Integer getContractOrderTermId() {
    return contractOrderTermId;
  }

  public void setContractOrderTermId(Integer contractOrderTermId) {
    this.contractOrderTermId = contractOrderTermId;
  }


  public Integer getMenuId() {
    return menuId;
  }

  public void setMenuId(Integer menuId) {
    this.menuId = menuId;
  }


  public Integer getMenuNumber() {
    return menuNumber;
  }

  public void setMenuNumber(Integer menuNumber) {
    this.menuNumber = menuNumber;
  }


  public Integer getCompleteNumber() {
    return completeNumber;
  }

  public void setCompleteNumber(Integer completeNumber) {
    this.completeNumber = completeNumber;
  }


  public Integer getContractOrderTermState() {
    return contractOrderTermState;
  }

  public void setContractOrderTermState(Integer contractOrderTermState) {
    this.contractOrderTermState = contractOrderTermState;
  }


  public String getProductBatch() {
    return productBatch;
  }

  public void setProductBatch(String productBatch) {
    this.productBatch = productBatch;
  }


  public Integer getContractOrderId() {
    return contractOrderId;
  }

  public void setContractOrderId(Integer contractOrderId) {
    this.contractOrderId = contractOrderId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
