package com.sample.dao;

import com.sample.model.CustomItem;
import com.sample.model.CustomItem;

import java.util.List;

public interface CustomItemDao {

    void saveCustomItem(CustomItem item);

    List<CustomItem> findAllCustomItems();

}