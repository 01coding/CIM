package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.dao.ContractProductionPlanDao;
import team.ruike.cim.dao.ContractProductionPlanItemDao;
import team.ruike.cim.pojo.ContractProductionPlan;
import team.ruike.cim.pojo.ContractProductionPlanItem;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 页面业务控制器
 * @author 张振国
 * @version 1.0
 */
@Controller
public class IndexController {
    @Resource
    private ContractProductionPlanDao contractProductionPlanDao;
    /**
     * 跳转主页
     * @return 主页jsp
     */
    @RequestMapping("/index.do")
    public String index(HttpServletRequest request) throws ParseException {
        /*加载一些主页要展示的数据*/
        //加载今日生产计划start
        ContractProductionPlan contractProductionPlan=new ContractProductionPlan();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        contractProductionPlan.setDate(simpleDateFormat.parse(new Date().toLocaleString()));
        List<ContractProductionPlan> contractProductionPlans = contractProductionPlanDao.select(contractProductionPlan,0,99);
        request.setAttribute("proLs",contractProductionPlans);
        //加载今日生产计划stop
        return "index";
    }
}
