package team.ruike.cim.pojo;


public class StagePurchasingPlanTerm {

  private Integer stagePurchasingPlanTermId;
  private Integer materielId;
  private Integer materielNumber;
  private Double unitPrice;
  private Integer supplierId;
  private Double priceFloat;
  private String remarks;
  private Integer stagePurchasingPlanId;
  private Integer status;


  public Integer getStagePurchasingPlanTermId() {
    return stagePurchasingPlanTermId;
  }

  public void setStagePurchasingPlanTermId(Integer stagePurchasingPlanTermId) {
    this.stagePurchasingPlanTermId = stagePurchasingPlanTermId;
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


  public Double getPriceFloat() {
    return priceFloat;
  }

  public void setPriceFloat(Double priceFloat) {
    this.priceFloat = priceFloat;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public Integer getStagePurchasingPlanId() {
    return stagePurchasingPlanId;
  }

  public void setStagePurchasingPlanId(Integer stagePurchasingPlanId) {
    this.stagePurchasingPlanId = stagePurchasingPlanId;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
