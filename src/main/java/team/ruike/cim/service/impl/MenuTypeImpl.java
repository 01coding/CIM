package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.MenuTypeDao;
import team.ruike.cim.pojo.MenuType;

import team.ruike.cim.service.MenuTypeService;

import javax.annotation.Resource;
import java.util.List;

@Service("menuTypeService")
public class MenuTypeImpl implements MenuTypeService {

    @Resource
    private MenuTypeDao menuTypeDao;

    @Override
    public List<MenuType> selectAllMenuType() {
        return menuTypeDao.selectAll();
    }

}
