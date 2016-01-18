package com.sample.dao;


import com.sample.model.CustomItem;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customItemDao")
public class ItemDaoImpl extends AbstractDao<Integer, CustomItem> implements CustomItemDao {

    public void saveCustomItem(CustomItem item) {
        persist(item);
    }

    @SuppressWarnings("unchecked")
    public List<CustomItem> findAllCustomItems() {
        Criteria criteria = createEntityCriteria();
        return (List<CustomItem>) criteria.list();
    }

}
