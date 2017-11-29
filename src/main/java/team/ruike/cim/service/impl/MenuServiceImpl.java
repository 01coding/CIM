package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.MenuDao;
import team.ruike.cim.dao.MenuStateDao;
import team.ruike.cim.dao.MenuTypeDao;
import team.ruike.cim.pojo.Menu;
import team.ruike.cim.pojo.MenuState;
import team.ruike.cim.pojo.MenuType;
import team.ruike.cim.service.MenuService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜谱业务实现类
 * @author 张振国
 * @version 1.0
 * @see #getMenuList(Menu, Pager)
 * @see #getMenuStateList()
 * @see #getMenuTypeList()
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService{
    @Resource
    private MenuDao menuDao;
    @Resource
    private MenuStateDao menuStateDao;
    @Resource
    private MenuTypeDao menuTypeDao;
    /**
     * 获取菜谱列表
     * @param menu 查询条件
     * @param pager 分页辅助类
     */
    public void getMenuList(Menu menu,Pager<Menu> pager) {
        pager.setTotalRecord(menuDao.selectCount(menu));
        List<Menu> menus = menuDao.select(menu, (pager.getCurrentPage() - 1)*pager.getPageSize(), pager.getPageSize());
        pager.setList(menus);
    }

    /**
     * 获取所有状态集合
     * @return 状态集合
     */
    public List<MenuState> getMenuStateList() {
        return menuStateDao.select(new MenuState(),0,99);
    }

    /**
     * 获取菜品类型集合
     * @return 类型集合
     */
    public List<MenuType> getMenuTypeList() {
        return menuTypeDao.select(new MenuType(),0,99);
    }

}
