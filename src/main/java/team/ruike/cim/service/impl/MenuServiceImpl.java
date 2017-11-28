package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.MenuDao;
import team.ruike.cim.pojo.Menu;
import team.ruike.cim.service.MenuService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜谱业务实现类
 * @author 张振国
 * @version 1.0
 * @see #getMenuList(Menu)
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService{
    @Resource
    private MenuDao menuDao;
    /**
     * 获取菜谱列表
     * @param menu 查询条件
     * @return 菜谱集合
     */
    public List<Menu> getMenuList(Menu menu) {
        List<Menu> menus = menuDao.select(menu, 0, 99);
        return menus;
    }
}
