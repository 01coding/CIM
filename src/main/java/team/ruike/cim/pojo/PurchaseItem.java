package team.ruike.cim.pojo;


public class PurchaseItem {

  private Integer purchaseItemId;
  private Integer materielId;
  private Integer materielNumber;
  private Double unitPrice;
  private Integer supplierId;
  private String remarks;
  private Integer status;
  private Integer purchaseId;


  public Integer getPurchaseItemId() {
    return purchaseItemId;
  }

  public void setPurchaseItemId(Integer purchaseItemId) {
    this.purchaseItemId = purchaseItemId;
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


  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }


  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Integer getPurchaseId() {
    return purchaseId;
  }

  public void setPurchaseId(Integer purchaseId) {
    this.purchaseId = purchaseId;
  }

}
