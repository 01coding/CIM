package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.ruike.cim.pojo.Materiel;
import team.ruike.cim.service.MaterielService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *物料业务控制器
 * @author 张振国
 * @version 1.0
 */
@Controller
public class MaterielController {
    @Resource
    private MaterielService materielService;

    /**
     * 查询物料列表
     * @param materiel 物料（条件）
     * @param pager 分页辅助类对象
     * @param request request
     * @return 物料页面视图地址
     */
    @RequestMapping("/materiellist.do")
    public String getMaterielList(Materiel materiel, Pager<Materiel> pager, HttpServletRequest request){
        materielService.getMaterielList(materiel,pager);
        request.setAttribute("typea",materielService.getMaterielTypeLevelA());
        request.setAttribute("typeb",materielService.getMaterielTypeLevelB());
        request.setAttribute("utils",materielService.getMaterielUnit());
        request.setAttribute("pager",pager);
        return "materiel";
    }
    /**
     * 新增物料业务
     * @return 结果标识
     */
    @ResponseBody
    @RequestMapping("/addMateriel.do")
    public String addMateriel(Materiel materiel,HttpServletRequest request){
        return materielService.addMaterielList(materiel)+"";
    }
}
