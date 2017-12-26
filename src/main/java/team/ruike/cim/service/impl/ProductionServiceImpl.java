package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.ContractOrderDao;
import team.ruike.cim.dao.ContractProductionPlanDao;
import team.ruike.cim.pojo.ContractOrder;
import team.ruike.cim.pojo.ContractOrderTerm;
import team.ruike.cim.pojo.ContractProductionPlan;
import team.ruike.cim.pojo.ContractProductionPlanItem;
import team.ruike.cim.service.ProductionService;
import team.ruike.cim.util.GenerateNumber;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生产业务实现类
 * @author 张振国
 * @version 1.0
 */
@Service("productionService")
public class ProductionServiceImpl implements ProductionService {
    @Resource
    private ContractOrderDao contractOrderDao;
    @Resource
    private ContractProductionPlanDao contractProductionPlanDao;
    /**
     * 今日合同生产计划生成
     * @return 今日合同生产计划
     */
    @Override
    public ContractProductionPlan generateContractProductionPlan() {
        //实例化生产计划对象
        ContractProductionPlan contractProductionPlan=new ContractProductionPlan();
        //1.查询未完成的合同订单
        ContractOrder contractOrder=new ContractOrder();
        contractOrder.setContractOrderState(0);
        List<ContractOrder> contractOrders = contractOrderDao.select(contractOrder, 0, 9999);
        for (ContractOrder order : contractOrders) {
            //如果交付日期在当前日期之后就进行平均分配否则直接生成
            if (order.getContractOrderEndDate().after(new Date())){

            }else {
                //1.为生产计划对象赋值
                contractProductionPlan.setContractOrder(order);
                contractProductionPlan.setProductionBatch(GenerateNumber.getGenerateNumber().getRandomFileName());
                contractProductionPlan.setStatus(0);
                contractProductionPlan.setDate(new Date());
                //2.调用数据层方法进行新增计划操作
                contractProductionPlanDao.add(contractProductionPlan);
                contractProductionPlan.setContractProductionPlanItems(new ArrayList<ContractProductionPlanItem>());
                //3.循环读取订单项数据进行新增计划项操作
                for (ContractOrderTerm contractOrderTerm : order.getContractOrderTerms()) {

                }
            }
        }
        return contractProductionPlan;
    }
}
