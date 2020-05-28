package item.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import item.dto.Item;
import item.service.ItemValidator;
import item.service.impl.ItemServiceImpl;

@Controller
public class ItemController {
	
	private ItemServiceImpl itemServiceImpl;
	public void setItemServiceImpl(ItemServiceImpl itemServiceImpl) {
		this.itemServiceImpl = itemServiceImpl;
	}
	
	
	@RequestMapping("/admin/itemList")
	public String itemList() {
		return "admin/itemManager/itemList";
	}
	
	
	//상품 등록
	
	@RequestMapping(value = "/admin/itemRegister", method = RequestMethod.GET)
	public String itemRegistForm(@ModelAttribute("item") Item item) {
		//System.out.println("컨트롤러 진입 하나?");
		return "admin/itemManager/itemRegister";
		
	}
	
	@RequestMapping(value = "/admin/itemRegister", method = RequestMethod.POST)
	public String itemRegistSubmit(@ModelAttribute("item") Item item/* , Errors errors */) {
		//String goUrl = "admin/itemManager/itemList";
		
//		new ItemValidator().validate(item, errors);
//		
//		if(errors.hasErrors()) {
//			return "admin/itemManager/itemRegister";
//		}
		
		System.out.println("컨트롤러 진입 : " + item.getItemName());
		
		int result = itemServiceImpl.itemRegister(item);
		if(result > 0) {return "admin/itemManager/itemList";}
		return "admin/itemManager/itemRegister";
	}
	
	
	
}
