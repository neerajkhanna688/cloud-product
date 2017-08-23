package com.niit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.niit.model.Item;
import com.niit.repository.ItemRepositoryCrudInterface;

@Service
public class ItemInfoServiceImpl implements ItemInfoService{

	@Autowired
	ItemRepositoryCrudInterface itemRepository;
	
	@Override
	@HystrixCommand(fallbackMethod="reliable")
	public String getItemInfo(Integer Id) throws Exception {
    	Thread.sleep(60000);
        	throw new Exception(" TimeOut After 1 min ");
	}

	  public String reliable(Integer Id) {
		    return "  returning value from fallback method";
		  }

	@Override
	@Transactional
	public Item saveItem(Item item) throws Exception {
		return itemRepository.save(item);
		
	}

	@Override
	public Iterable<Item> getItems() throws Exception {
		return itemRepository.findAll();
	}
	
	

}
