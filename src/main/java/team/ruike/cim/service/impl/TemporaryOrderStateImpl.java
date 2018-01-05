package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.TemporaryOrderStateDao;
import team.ruike.cim.pojo.TemporaryOrderState;
import team.ruike.cim.service.TemporaryOrderStateService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 临时订单状态
 *
 * @author 甄立
 * @version 1.0
 */
@Service("temporaryOrderStateService")
public class TemporaryOrderStateImpl implements TemporaryOrderStateService {

    @Resource
    private TemporaryOrderStateDao temporaryOrderStateDao;


    /**
     * 查询所有临时订单状态
     *
     * @return 临时订单状态集合
     */
    public List<TemporaryOrderState> selectAllTemporaryOrderState() {
        return temporaryOrderStateDao.selectAll();
    }
}
