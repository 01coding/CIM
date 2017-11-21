package team.ruike.cim.pojo;


public class ProductionStandardRecord {

    private Integer productionStandardRecordId;
    private Integer productionStandardId;
    private Integer standardAScore;
    private Integer standardBScore;
    private Integer standardCScore;
    private String conclusion;
    private Integer status;

    public Integer getProductionStandardRecordId() {
        return productionStandardRecordId;
    }

    public void setProductionStandardRecordId(Integer productionStandardRecordId) {
        this.productionStandardRecordId = productionStandardRecordId;
    }

    public Integer getProductionStandardId() {
        return productionStandardId;
    }

    public void setProductionStandardId(Integer productionStandardId) {
        this.productionStandardId = productionStandardId;
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
