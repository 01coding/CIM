package team.ruike.cim.service;

import team.ruike.cim.pojo.OrderContract;
import team.ruike.cim.util.Pager;

import java.util.List;

/**
 * 订单合同业务接口
 *
 * @author 甄立
 * @version 1.0
 */
public interface OrderContractService {

    /**
     * 查询订单合同
     *
     * @param orderContract 查询条件
     * @param pager         分页辅助类
     */
    public void queryOrderContract(OrderContract orderContract, Pager<OrderContract> pager);


    /**
     * 根据ID查询订单合同
     *
     * @param orderContractId 订单合同Id
     * @return 订单合同对象
     */
    public OrderContract queryOrderContractById(Integer orderContractId);


    /**
     * 添加订单合同
     *
     * @param orderContract 订单合同对象
     */
    public void addOrderContract(OrderContract orderContract);


    /**
     * 修改订单合同
     *
     * @param orderContract 订单合同信息
     */
    public void updateOrderContractById(OrderContract orderContract);


    public List<OrderContract> selectAllOrderContract();
}
