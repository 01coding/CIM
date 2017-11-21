package team.ruike.cim.pojo;


import java.io.Serializable;

public class TemporaryProductionPlanItem implements Serializable {

  private static final long serialVersionUID = -3478873343512159563L;
  private Integer temporaryProductionPlanItemId;
  private Integer menuId;
  private Integer menuNumber;
  private Integer temporaryProductionPlanId;
  private Integer status;


  public Integer getTemporaryProductionPlanItemId() {
    return temporaryProductionPlanItemId;
  }

  public void setTemporaryProductionPlanItemId(Integer temporaryProductionPlanItemId) {
    this.temporaryProductionPlanItemId = temporaryProductionPlanItemId;
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


  public Integer getTemporaryProductionPlanId() {
    return temporaryProductionPlanId;
  }

  public void setTemporaryProductionPlanId(Integer temporaryProductionPlanId) {
    this.temporaryProductionPlanId = temporaryProductionPlanId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
