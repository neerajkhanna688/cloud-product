package com.niit.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@Service
public class ItemInfoServiceImpl implements ItemInfoService{

	@Override
	@HystrixCommand(fallbackMethod="reliable")
	public String getItemInfo(Integer Id) throws Exception {
    	Thread.sleep(60000);
        	throw new Exception(" TimeOut After 1 min ");
	}

	  public String reliable(Integer Id) {
		    return "  returning value from fallback method";
		  }
}
