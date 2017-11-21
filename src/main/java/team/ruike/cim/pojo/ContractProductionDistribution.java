package team.ruike.cim.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * 合同订单生产任务分配
 *
 * @author 张振国
 * @version 1.0
 */
public class ContractProductionDistribution implements Serializable {
    private static final long serialVersionUID = 4224470599322559142L;
    /**
     * 合同订单生产任务分配id
     */
    private Integer contractProductionDistributionId;
    /**
     * 计划订单项id
     */
    private Integer contractProductionPlanItemId;
    /**
     * 工序表id
     */
    private Integer workingId;
    /**
     * 用户表id(工序负责人)
     */
    private Integer userId;
    /**
     * 预计生产开始时间
     */
    private Date startDate;
    /**
     * 预计结束时间
     */
    private Date endDate;
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
     * 删除状态
     */
    private Integer status;
    /**
     * 进入下一工序数量
     */
    private Integer nextWorkingNumber;


    public Integer getContractProductionDistributionId() {
        return contractProductionDistributionId;
    }

    public void setContractProductionDistributionId(Integer contractProductionDistributionId) {
        this.contractProductionDistributionId = contractProductionDistributionId;
    }


    public Integer getContractProductionPlanItemId() {
        return contractProductionPlanItemId;
    }

    public void setContractProductionPlanItemId(Integer contractProductionPlanItemId) {
        this.contractProductionPlanItemId = contractProductionPlanItemId;
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

}
