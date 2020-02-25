package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.Uom;
import in.nit.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;
	
	/**1.
	 * 
	 */
	@RequestMapping("/register")
	public String showUom(
			Model model
			) {
		model.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	
	/**2.
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUom(
			@ModelAttribute Uom uom,
			Model model
			) {
		Integer id = service.saveUom(uom);
		String message = "Data is saved with id:"+id;
		model.addAttribute("message", message);
		return "UomRegister";
	}
}
