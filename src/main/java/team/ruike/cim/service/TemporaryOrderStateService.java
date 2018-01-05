package team.ruike.cim.service;

import team.ruike.cim.pojo.TemporaryOrderState;

import java.util.List;

/**
 * 临时订单状态
 *
 * @author 甄立
 * @version 1.0
 */
public interface TemporaryOrderStateService {

    /**
     * 查询所有临时订单状态
     *
     * @return 临时订单状态集合
     */
    List<TemporaryOrderState> selectAllTemporaryOrderState();
}
