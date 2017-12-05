package team.ruike.cim.service.impl;

import org.springframework.transaction.annotation.Transactional;
import team.ruike.cim.dao.OrderContractDao;
import team.ruike.cim.pojo.OrderContract;
import team.ruike.cim.service.OrderContractService;
import team.ruike.cim.util.GenerateNumber;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.GregorianCalendar;
import java.util.List;

public class OrderContractServiceImpl implements OrderContractService {
    @Resource
    public OrderContractDao orderContractDao;


    @Override
    public void queryOrderContract(OrderContract orderContract, Pager<OrderContract> pager) {
        Integer count = orderContractDao.selectCount(orderContract);
        pager.setTotalRecord(count);
        List<OrderContract> orderContractList = orderContractDao.select(orderContract, (pager.getCurrentPage() - 1) * pager.getPageSize(), pager.getPageSize());
        pager.setList(orderContractList);
    }

    @Override
    public OrderContract queryOrderContractById(Integer orderContractId) {
        OrderContract orderContract = null;
        if (orderContractId != null && orderContractId > 0) {
            orderContract = orderContractDao.selectById(orderContractId);
        }
        return orderContract;
    }

    @Transactional
    public void addOrderContract(OrderContract orderContract) {
        if (orderContract != null && orderContract.getStore() != null && orderContract.getStore().getStoreId() != null && orderContract.getStore().getStoreId() > 0) {
            orderContract.setOrderContractNo(GenerateNumber.getGenerateNumber().getUUID().toString());
            orderContractDao.add(orderContract);
        }
        new NullPointerException("orderContract is null");
    }

    @Transactional
    public void updateOrderContractById(OrderContract orderContract) {
        if (orderContract != null && orderContract.getOrderContractId() != null && orderContract.getOrderContractId() > 0) {
            orderContractDao.update(orderContract);
        }
        new NullPointerException("orderContract is null");
    }
}
