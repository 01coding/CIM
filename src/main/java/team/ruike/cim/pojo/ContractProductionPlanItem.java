package team.ruike.cim.pojo;


import java.io.Serializable;

public class ContractProductionPlanItem implements Serializable {

  private static final long serialVersionUID = 2705376220563549480L;
  private Integer contractProductionPlanItemId;
  private Integer menuId;
  private Integer menuNumber;
  private Integer contractProductionPlanId;
  private Integer status;


  public Integer getContractProductionPlanItemId() {
    return contractProductionPlanItemId;
  }

  public void setContractProductionPlanItemId(Integer contractProductionPlanItemId) {
    this.contractProductionPlanItemId = contractProductionPlanItemId;
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


  public Integer getContractProductionPlanId() {
    return contractProductionPlanId;
  }

  public void setContractProductionPlanId(Integer contractProductionPlanId) {
    this.contractProductionPlanId = contractProductionPlanId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
