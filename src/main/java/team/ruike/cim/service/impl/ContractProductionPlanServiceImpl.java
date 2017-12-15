package team.ruike.cim.service.impl;
import org.springframework.stereotype.Service;
import team.ruike.cim.dao.ContractProductionPlanDao;
import team.ruike.cim.pojo.ContractProductionPlan;
import team.ruike.cim.service.ContractProductionPlanService;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 生产系统业务实现类
 * @author 张振国
 * @version 1.0
 */
@Service("contractProductionPlanService")
public class ContractProductionPlanServiceImpl implements ContractProductionPlanService {

    @Resource
    private ContractProductionPlanDao contractProductionPlanDao;

    /**
     * 获取今日生产计划
     * @return 今日生产计划集合
     */
    @Override
    public List<ContractProductionPlan> getDayContractProductionPlans() throws ParseException {
        ContractProductionPlan contractProductionPlan=new ContractProductionPlan();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        contractProductionPlan.setDate(simpleDateFormat.parse(new Date().toLocaleString()));
        return contractProductionPlanDao.select(contractProductionPlan,0,99);
    }
}
