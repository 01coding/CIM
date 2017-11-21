package team.ruike.cim.pojo;


import java.io.Serializable;

public class MenuMateriel implements Serializable {

  private static final long serialVersionUID = -977872690889448044L;
  private Integer menuMaterielId;
  private Integer menuId;
  private Integer materielId;
  private Integer menuMaterielType;
  private Integer status;


  public Integer getMenuMaterielId() {
    return menuMaterielId;
  }

  public void setMenuMaterielId(Integer menuMaterielId) {
    this.menuMaterielId = menuMaterielId;
  }


  public Integer getMenuId() {
    return menuId;
  }

  public void setMenuId(Integer menuId) {
    this.menuId = menuId;
  }


  public Integer getMaterielId() {
    return materielId;
  }

  public void setMaterielId(Integer materielId) {
    this.materielId = materielId;
  }


  public Integer getMenuMaterielType() {
    return menuMaterielType;
  }

  public void setMenuMaterielType(Integer menuMaterielType) {
    this.menuMaterielType = menuMaterielType;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
