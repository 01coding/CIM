package team.ruike.cim.service.impl;

import org.springframework.stereotype.Service;
import team.ruike.cim.dao.ProductWarehouseRegisterDao;
import team.ruike.cim.pojo.ProductWarehouseRegister;
import team.ruike.cim.service.ProductWarehouseRegisterService;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;

/**
 * 成品库入库登记业务实现类
 */
@Service("productWarehouseRegisterService")
public class ProductWarehouseRegisterServiceImpl implements ProductWarehouseRegisterService {
    @Resource
    private ProductWarehouseRegisterDao productWarehouseRegisterDao;

    public int addProductWarehouseRegister(ProductWarehouseRegister productWarehouseRegister) {
        if (productWarehouseRegister != null && productWarehouseRegister.getProductWarehouseRegisterDate() != null
                && productWarehouseRegister.getProductionBatch() != "" && productWarehouseRegister.getUser() != null
                && productWarehouseRegister.getUser().getUserId() > 0) {
           return productWarehouseRegisterDao.add(productWarehouseRegister);
        }
        return 0;
    }

    public int updProductWarehouseRegister(ProductWarehouseRegister productWarehouseRegister) {
        if (productWarehouseRegister != null && productWarehouseRegister.getProductWarehouseRegisterDate() != null
                && productWarehouseRegister.getProductionBatch() != "" && productWarehouseRegister.getUser() != null
                && productWarehouseRegister.getUser().getUserId() > 0) {
            return productWarehouseRegisterDao.update(productWarehouseRegister);
        }
        return 0;
    }
    public void getProductWarehouseRegister(ProductWarehouseRegister productWarehouseRegister, Pager<ProductWarehouseRegister> pager) {
            pager.setTotalRecord(productWarehouseRegisterDao.selectCount(productWarehouseRegister));
            pager.setList(productWarehouseRegisterDao.select(productWarehouseRegister,(pager.getCurrentPage() - 1) * pager.getPageSize(), pager.getPageSize()));
    }
}
