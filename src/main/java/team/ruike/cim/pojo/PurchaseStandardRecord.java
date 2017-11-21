package team.ruike.cim.pojo;


public class PurchaseStandardRecord {

  private Integer purchaseStandardRecordId;
  private Integer purchaseStandardId;
  private Integer standardAScore;
  private Integer standardBScore;
  private Integer standardCScore;
  private String conclusion;
  private Integer status;


  public Integer getPurchaseStandardRecordId() {
    return purchaseStandardRecordId;
  }

  public void setPurchaseStandardRecordId(Integer purchaseStandardRecordId) {
    this.purchaseStandardRecordId = purchaseStandardRecordId;
  }


  public Integer getPurchaseStandardId() {
    return purchaseStandardId;
  }

  public void setPurchaseStandardId(Integer purchaseStandardId) {
    this.purchaseStandardId = purchaseStandardId;
  }


  public Integer getStandardAScore() {
    return standardAScore;
  }

  public void setStandardAScore(Integer standardAScore) {
    this.standardAScore = standardAScore;
  }


  public Integer getStandardBScore() {
    return standardBScore;
  }

  public void setStandardBScore(Integer standardBScore) {
    this.standardBScore = standardBScore;
  }


  public Integer getStandardCScore() {
    return standardCScore;
  }

  public void setStandardCScore(Integer standardCScore) {
    this.standardCScore = standardCScore;
  }


  public String getConclusion() {
    return conclusion;
  }

  public void setConclusion(String conclusion) {
    this.conclusion = conclusion;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

}
