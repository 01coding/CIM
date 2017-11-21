package team.ruike.cim.pojo;


import java.io.Serializable;

public class ProductionStandard implements Serializable {

  private static final long serialVersionUID = -5472308480089470038L;
  private Integer productionStandardId;
  private String productionBatch;
  private Integer standardAType;
  private String standardAName;
  private Integer standardBType;
  private String standardBName;
  private Integer standardCType;
  private String standardCName;
  private String remarks;
  private Integer status;


  public Integer getProductionStandardId() {
    return productionStandardId;
  }

  public void setProductionStandardId(Integer productionStandardId) {
    this.productionStandardId = productionStandardId;
  }


  public String getProductionBatch() {
    return productionBatch;
  }

  public void setProductionBatch(String productionBatch) {
    this.productionBatch = productionBatch;
  }


  public Integer getStandardAType() {
    return standardAType;
  }

  public void setStandardAType(Integer standardAType) {
    this.standardAType = standardAType;
  }


  public String getStandardAName() {
    return standardAName;
  }

  public void setStandardAName(String standardAName) {
    this.standardAName = standardAName;
  }


  public Integer getStandardBType() {
    return standardBType;
  }

  public void setStandardBType(Integer standardBType) {
    this.standardBType = standardBType;
  }


  public String getStandardBName() {
    return standardBName;
  }

  public void setStandardBName(String standardBName) {
    this.standardBName = standardBName;
  }


  public Integer getStandardCType() {
    return standardCType;
  }

  public void setStandardCType(Integer standardCType) {
    this.standardCType = standardCType;
  }


  public String getStandardCName() {
    return standardCName;
  }

  public void setStandardCName(String standardCName) {
    this.standardCName = standardCName;
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

}
