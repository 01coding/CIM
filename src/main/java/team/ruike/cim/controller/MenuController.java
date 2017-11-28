package team.ruike.cim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import team.ruike.cim.pojo.Menu;
import team.ruike.cim.service.MenuService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 菜谱业务控制器
 * @author 张振国
 * @version 1.0
 */
@Controller
public class MenuController {
    @Resource
    private MenuService menuService;
    /**
     * 跳转菜谱页面并查询数据
     * @return 菜谱jsp
     */
    @RequestMapping("menulist.do")
    public String menuList(Menu menu, HttpServletRequest request){
        request.setAttribute("menuList",menuService.getMenuList(menu));
        return "menulist";
    }
}
