package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.PurchaseStandardRecord;
import team.ruike.cim.service.QualityService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 质量管理控制器
 * @author 华中昊
 * @version 1.0
 */
@Controller
public class QualityController {
    @Resource
    private QualityService qualityService;
    /**
     * 品控记录页面跳转并查询数据
     * @return 记录页面jsp
     */
    @RequestMapping("/record.do")
    public String record(PurchaseStandardRecord purchaseStandardRecord, Pager<PurchaseStandardRecord> pager, HttpServletRequest request){
        qualityService.getRecordList(purchaseStandardRecord,pager);
        request.setAttribute("page1",pager.getList());
        return "quality/record";
    }
}
