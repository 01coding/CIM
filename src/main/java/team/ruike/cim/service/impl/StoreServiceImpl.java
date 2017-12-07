package team.ruike.cim.service.impl;

import javafx.collections.SetChangeListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.ruike.cim.dao.StoreDao;
import team.ruike.cim.pojo.Store;
import team.ruike.cim.service.StoreService;
import team.ruike.cim.util.GenerateNumber;
import team.ruike.cim.util.Pager;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 门店业务类
 *
 * @author 甄立
 * @version 1.0
 */
@Service("storeService")
public class StoreServiceImpl implements StoreService {

    @Resource
    private StoreDao storeDao;

    public void queryStore(Store store, Pager<Store> pager) {
        Integer count = storeDao.selectCount(store);
        pager.setTotalRecord(count);
        List<Store> storeList = storeDao.select(store, (pager.getCurrentPage() - 1) * pager.getPageSize(), pager.getPageSize());
        pager.setList(storeList);
    }

    public Store queryStoreById(Integer storeId) {
        Store store = null;
        if (storeId != null && storeId > 0) {
            store = storeDao.selectById(storeId);
        }
        return store;
    }


    public void addStore(Store store) {
        if (store == null | store.getStoreName() == "") {
            throw new RuntimeException("not is null");
        }
        String storeNo = GenerateNumber.getGenerateNumber().getRandomFileName();
        store.setStoreNo(storeNo);
        storeDao.add(store);
    }


    public void updateStoreById(Store store) {

        if (store == null) {
            throw new NullPointerException("store not is null");
        }
        if (store.getStoreId() == null | store.getStoreId() < 0) {
            throw new NullPointerException("storeId not is null");
        }
        storeDao.update(store);
    }


    public void deleteStoreById(final Integer storeId) {
        if (storeId != null && storeId > 0) {
            storeDao.hiddenById(storeId);
        }else{
            throw new NullPointerException("storeId not is null");
        }

    }


}
