package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Controller
@RequestMapping("/om")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	/**
	 * 
	 * 
	 * 
	 */
	@RequestMapping("/register")
	public String showRegisterPage(
			Model model
			) {
		model.addAttribute("orderMethod",new OrderMethod() );
		return "OrderMethodRegister";
	}
	
	/**
	 * 
	 */
	@RequestMapping("/save")
	public String saveOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model
			) {
		Integer id = service.saveOrderMethod(orderMethod);
		String message = "Order'"+id+"'saved";
		model.addAttribute("message", message);
		return "OrderMethodRegister";
	}
	
}




