package team.ruike.cim.service;

import team.ruike.cim.pojo.ProductWarehouseRegister;
import team.ruike.cim.util.Pager;

/**
 * 成品库入库登记表接口
 */
public interface ProductWarehouseRegisterService {
    int addProductWarehouseRegister(ProductWarehouseRegister productWarehouseRegister);

    int updProductWarehouseRegister(ProductWarehouseRegister productWarehouseRegister);

    void getProductWarehouseRegister(ProductWarehouseRegister productWarehouseRegister, Pager<ProductWarehouseRegister> pager);
}
