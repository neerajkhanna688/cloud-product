package com.niit.service;

import com.niit.model.Item;

public interface ItemInfoService {

    public String getItemInfo(Integer Id ) throws Exception;
    public Item saveItem(Item item) throws Exception;
    public Iterable<Item> getItems() throws Exception;
    	 
}
