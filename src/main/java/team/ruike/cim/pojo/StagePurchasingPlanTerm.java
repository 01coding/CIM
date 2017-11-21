package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 阶段采购计划项
 *
 * @author 孙天奇
 * @version 1.0
 */
public class StagePurchasingPlanTerm implements Serializable {

    private static final long serialVersionUID = 2929154474959515565L;
    /**
     * 阶段采购计划项id
     */
    private Integer stagePurchasingPlanTermId;
    /**
     * 物料id外键
     */
    private Integer materielId;
    /**
     * 数量
     */
    private Integer materielNumber;
    /**
     * 预计采购单价
     */
    private Double unitPrice;
    /**
     * 供应商id外键
     */
    private Integer supplierId;
    /**
     * 价格允许浮动范围
     */
    private Double priceFloat;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 所属计划,计划表id
     */
    private Integer stagePurchasingPlanId;
    /**
     * 状态
     */
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
