package team.ruike.cim.service;

import team.ruike.cim.pojo.ContractOrder;
import team.ruike.cim.pojo.ContractOrderTerm;
import team.ruike.cim.pojo.OrderContract;
import team.ruike.cim.util.Pager;

/**
 * 合同订单业务接口
 *
 * @author 甄立
 * @version 1.0
 */
public interface ContractOrderService {


    /**
     * 查询合同订单
     *
     * @param contractOrder 查询添加
     * @param pager         分页辅助类
     */
    public void queryContractOrder(ContractOrder contractOrder, Pager<ContractOrder> pager);

    /**
     * 根据ID查询详细合同订单
     *
     * @param contractOrderId 合同订单ID
     * @return 合同订单对象
     */
    public ContractOrder queryContractOrderById(Integer contractOrderId);


    /**
     * 添加合同订单
     *
     * @param orderContract     订单合同
     * @param contractOrder     合同订单
     * @param contractOrderTerm 合同订单项
     */
    public void addContractOrder(OrderContract orderContract, ContractOrder contractOrder, ContractOrderTerm contractOrderTerm);


}
