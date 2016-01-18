package com.sample.service;

import com.sample.dao.CustomItemDao;
import com.sample.model.CustomItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("customItemService")
@Transactional
public class CustomItemServiceImpl implements CustomItemService {

    @Autowired
    CustomItemDao customItemDao;

    public void saveCustomItem(CustomItem customItem) {
        customItemDao.saveCustomItem(customItem);
    }

    public List<CustomItem> findAllCustomItems() {
        return customItemDao.findAllCustomItems();
    }

}
