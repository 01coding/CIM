package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 临时订单生产计划表
 *
 * @author 孙天奇
 * @version 1.0
 */
public class TemporaryProductionPlan implements Serializable {

    private static final long serialVersionUID = -8796638088313303084L;
    /**
     * 临时订单生产计划表
     */
    private Integer temporaryProductionPlanId;
    /**
     * 临时订单id外键
     */
    private Integer temporaryOrderId;
    /**
     * 生产批次
     */
    private String productionBatch;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 日期
     */
    private Date date;


    public Integer getTemporaryProductionPlanId() {
        return temporaryProductionPlanId;
    }

    public void setTemporaryProductionPlanId(Integer temporaryProductionPlanId) {
        this.temporaryProductionPlanId = temporaryProductionPlanId;
    }


    public Integer getTemporaryOrderId() {
        return temporaryOrderId;
    }

    public void setTemporaryOrderId(Integer temporaryOrderId) {
        this.temporaryOrderId = temporaryOrderId;
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
