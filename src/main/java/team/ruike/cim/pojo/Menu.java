package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable {

  private static final long serialVersionUID = -4447100772306943624L;
  private Integer menuId;
  private String menuName;
  private Integer menuNo;
  private Integer menuTypeId;
  private Double menuWeight;
  private Double menuCost;
  private String menuImage;
  private Integer menuStoreMax;
  private Integer menuStoreMin;
  private Integer menuShelfLife;
  private Date menuCreateDate;
  private Integer menuStateId;
  private Date menuReleaseDate;
  private Integer status;
  private String menuRemarks;


  public Integer getMenuId() {
    return menuId;
  }

  public void setMenuId(Integer menuId) {
    this.menuId = menuId;
  }


  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }


  public Integer getMenuNo() {
    return menuNo;
  }

  public void setMenuNo(Integer menuNo) {
    this.menuNo = menuNo;
  }


  public Integer getMenuTypeId() {
    return menuTypeId;
  }

  public void setMenuTypeId(Integer menuTypeId) {
    this.menuTypeId = menuTypeId;
  }


  public Double getMenuWeight() {
    return menuWeight;
  }

  public void setMenuWeight(Double menuWeight) {
    this.menuWeight = menuWeight;
  }


  public Double getMenuCost() {
    return menuCost;
  }

  public void setMenuCost(Double menuCost) {
    this.menuCost = menuCost;
  }


  public String getMenuImage() {
    return menuImage;
  }

  public void setMenuImage(String menuImage) {
    this.menuImage = menuImage;
  }


  public Integer getMenuStoreMax() {
    return menuStoreMax;
  }

  public void setMenuStoreMax(Integer menuStoreMax) {
    this.menuStoreMax = menuStoreMax;
  }


  public Integer getMenuStoreMin() {
    return menuStoreMin;
  }

  public void setMenuStoreMin(Integer menuStoreMin) {
    this.menuStoreMin = menuStoreMin;
  }


  public Integer getMenuShelfLife() {
    return menuShelfLife;
  }

  public void setMenuShelfLife(Integer menuShelfLife) {
    this.menuShelfLife = menuShelfLife;
  }


  public Date getMenuCreateDate() {
    return menuCreateDate;
  }

  public void setMenuCreateDate(Date menuCreateDate) {
    this.menuCreateDate = menuCreateDate;
  }


  public Integer getMenuStateId() {
    return menuStateId;
  }

  public void setMenuStateId(Integer menuStateId) {
    this.menuStateId = menuStateId;
  }


  public Date getMenuReleaseDate() {
    return menuReleaseDate;
  }

  public void setMenuReleaseDate(Date menuReleaseDate) {
    this.menuReleaseDate = menuReleaseDate;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public String getMenuRemarks() {
    return menuRemarks;
  }

  public void setMenuRemarks(String menuRemarks) {
    this.menuRemarks = menuRemarks;
  }

}
