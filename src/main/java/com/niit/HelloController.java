package com.niit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.kafka.Sender;
import com.niit.model.Item;
import com.niit.model.ItemReview;
import com.niit.service.ItemInfoService;


@RestController
public class HelloController {
  
	@Autowired
	private ItemInfoService itemInfoService;
	
	@Autowired
	private Sender sender;
	
    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }
    
    @RequestMapping( method = RequestMethod.GET,  value= "/item/{id}")
    public String getItemInfo(Integer Id ) throws Exception{
    	return itemInfoService.getItemInfo(Id);
   }

    @RequestMapping( method = RequestMethod.GET,  value= "/items")
   public Iterable<Item> getItems() throws Exception{
    	return itemInfoService.getItems();
   }

	@RequestMapping(method=RequestMethod.POST, value="/item/create")
	public void addItem(@RequestBody Item item) throws Exception{
System.out.println("  ----------------- "+ item.getBrand());		
      itemInfoService.saveItem(item);
	}
	
    @RequestMapping(method= RequestMethod.GET,value="/kafka/{name}")
    String useKafka(@PathVariable("name") String name) {
    	sender.send(" Hello World "+name);
        return "Hello World! "+name;
    }

}
