package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.MenuDao;
import team.ruike.cim.dao.MenuStateDao;
import team.ruike.cim.dao.MenuTypeDao;
import team.ruike.cim.pojo.*;
import team.ruike.cim.service.MenuService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜谱业务实现类
 * @author 张振国
 * @version 1.0
 * @see #getMenuList(Menu, Pager)
 * @see #getMenuStateList()
 * @see #getMenuTypeList()
 * @see #flowMaxHour(int)
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

    /**
     * 获取菜品工序详情
     * @param menuId 菜品id
     * @return 工序详情
     */
    public List<List<MenuFlow>> getMenuFlows(int menuId){
        Menu menu = menuDao.selectById(menuId);
        List<MenuMateriel> menuMaterielList = menu.getMenuMaterielList();
        List<List<MenuFlow>> menuFlows=new ArrayList<List<MenuFlow>>();
        List<MenuFlow> menuFlows1=new ArrayList<MenuFlow>();
        List<MenuFlow> menuFlows2=new ArrayList<MenuFlow>();
        List<MenuFlow> menuFlows3=new ArrayList<MenuFlow>();
        List<MenuFlow> menuFlows4=new ArrayList<MenuFlow>();
        List<MenuFlow> menuFlows5=new ArrayList<MenuFlow>();
        //根据工序筛选每个工序的子工序
        for (MenuMateriel menuMateriel : menuMaterielList) {
            List<MenuFlow> menuFlow = menuMateriel.getMenuFlow();
            for (MenuFlow flow : menuFlow) {
                if (flow.getWorking().getWorkingId()==1){
                    menuFlows1.add(flow);
                }
                if (flow.getWorking().getWorkingId()==2){
                    menuFlows2.add(flow);
                }
                if (flow.getWorking().getWorkingId()==3){
                    menuFlows3.add(flow);
                }
                if (flow.getWorking().getWorkingId()==4){
                    menuFlows4.add(flow);
                }
                if (flow.getWorking().getWorkingId()==5){
                    menuFlows5.add(flow);
                }
            }
        }
        //放入筛选后的集合
        menuFlows.add(menuFlows1);
        menuFlows.add(menuFlows2);
        menuFlows.add(menuFlows3);
        menuFlows.add(menuFlows4);
        menuFlows.add(menuFlows5);
        return menuFlows;
    }




    /**
     * 获取菜品所有工序的最长时间
     * @param menuId 菜品id
     * @return 最长时间集合
     */
    public Map<String, MenuFlow> flowMaxHour(int menuId) {
        Map<String,MenuFlow> maps=new HashMap<String, MenuFlow>();
        List<List<MenuFlow>> menuFlows = this.getMenuFlows(menuId);
        //取各工序最长子时间
        for (int i = 0; i < menuFlows.size(); i++) {
            Double h=0.0;
            MenuFlow pFlow=new MenuFlow();
            for (MenuFlow menuFlow : menuFlows.get(i)) {
                if (menuFlow.getMenuFlowHour()>h){
                    h=menuFlow.getMenuFlowHour();
                    pFlow=menuFlow;
                }
            }
            maps.put(i+"",pFlow);
        }
        return maps;
    }


    @Override
    public List<Menu> selectByMenuTypeId(Integer menuTypeId) {
        return  menuDao.selectByMenuTypeId(menuTypeId);
    }

}
