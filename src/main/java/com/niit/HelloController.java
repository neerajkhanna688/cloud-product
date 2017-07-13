package com.niit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.service.ItemInfoService;

@RestController
public class HelloController {
  
	@Autowired
	private ItemInfoService itemInfoService;
	
    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }
    
    @RequestMapping( method = RequestMethod.GET,  value= "/item/{id}")
    public String getItemInfo(Integer Id ) throws Exception{
    	return itemInfoService.getItemInfo(Id);
   }
   
}
