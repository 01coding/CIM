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

    @Transactional
    public void addStore(Store store) {
        if (store == null) {
            new NullPointerException("not is null");
        }
        store.setStoreNo(GenerateNumber.getGenerateNumber().getUUID());
        storeDao.add(store);
    }
    @Transactional
    public void updateStoreById(Store store) {

        if (store == null) {
            new NullPointerException("store not is null");
        }
        if (store.getStoreId() == null | store.getStoreId() < 0) {
            new NullPointerException("storeId not is null");
        }
        storeDao.update(store);
    }
    @Transactional
    public void deleteStoreById(Integer storeId) {
        if (storeId!=null && storeId>0){
            storeDao.update(new Store(){
                {setStoreId(storeId);}
            });
        }
        new NullPointerException("storeId not is null");
    }



}
