package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 *合同订单生产计划
 * @author 张振国
 * @version 1.0
 */
public class ContractProductionPlan implements Serializable {
    private static final long serialVersionUID = -8749159766478095970L;
    /**
     * 合同订单生产计划id
     */
    private Integer contractProductionPlanId;
    /**
     * 合同订单id外键
     */
    private Integer contractOrderId;
    /**
     * 生产批次
     */
    private String productionBatch;
    /**
     * 删除状态
     */
    private Integer status;
    /**
     * 日期
     */
    private Date date;


    public Integer getContractProductionPlanId() {
        return contractProductionPlanId;
    }

    public void setContractProductionPlanId(Integer contractProductionPlanId) {
        this.contractProductionPlanId = contractProductionPlanId;
    }


    public Integer getContractOrderId() {
        return contractOrderId;
    }

    public void setContractOrderId(Integer contractOrderId) {
        this.contractOrderId = contractOrderId;
    }


    public String getProductionBatch() {
        return productionBatch;
    }

    public void setProductionBatch(String productionBatch) {
        this.productionBatch = productionBatch;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
