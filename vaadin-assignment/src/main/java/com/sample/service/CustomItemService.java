package com.sample.service;

import com.sample.model.CustomItem;

import java.util.List;

public interface CustomItemService {

    void saveCustomItem(CustomItem customItem);

    List<CustomItem> findAllCustomItems();

}
