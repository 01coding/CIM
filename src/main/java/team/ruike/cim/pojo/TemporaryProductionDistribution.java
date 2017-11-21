package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 临时订单生产任务分配
 *
 * @author 孙天奇
 * @version 1.0
 */
public class TemporaryProductionDistribution implements Serializable {

    private static final long serialVersionUID = -7121600245271357479L;
    /**
     * 临时订单生产任务分配id
     */
    private Integer temporaryProductionDistributionId;
    /**
     * 临时订单项id
     */
    private Integer temporaryProductionPlanItemId;
    /**
     * 工序表id
     */
    private Integer workingId;
    /**
     * 工序负责人
     */
    private Integer userId;
    /**
     * 配置人数
     */
    private Integer peopleNumber;
    /**
     * 生产线id外键
     */
    private Integer productionLineId;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 进入下一工序数量
     */
    private Integer nextWorkingNumber;
    /**
     * 预计生产开始时间
     */
    private Date startDate;
    /**
     * 预计结束时间
     */
    private Date endDate;


    public Integer getTemporaryProductionDistributionId() {
        return temporaryProductionDistributionId;
    }

    public void setTemporaryProductionDistributionId(Integer temporaryProductionDistributionId) {
        this.temporaryProductionDistributionId = temporaryProductionDistributionId;
    }


    public Integer getTemporaryProductionPlanItemId() {
        return temporaryProductionPlanItemId;
    }

    public void setTemporaryProductionPlanItemId(Integer temporaryProductionPlanItemId) {
        this.temporaryProductionPlanItemId = temporaryProductionPlanItemId;
    }


    public Integer getWorkingId() {
        return workingId;
    }

    public void setWorkingId(Integer workingId) {
        this.workingId = workingId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }


    public Integer getProductionLineId() {
        return productionLineId;
    }

    public void setProductionLineId(Integer productionLineId) {
        this.productionLineId = productionLineId;
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


    public Integer getNextWorkingNumber() {
        return nextWorkingNumber;
    }

    public void setNextWorkingNumber(Integer nextWorkingNumber) {
        this.nextWorkingNumber = nextWorkingNumber;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
