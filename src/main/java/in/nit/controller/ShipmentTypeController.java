package in.nit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.view.ShipmentTypeExcelView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	
	/**1.
	 * This method is used to display
	 * ShipmentTypeRegister page
	 *on url:/register ,GET 
	 */
	@RequestMapping("/register")
	public String showRegPage(
			Model model
			) {
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	/**2.
	 * 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveShipment(
			@ModelAttribute ShipmentType shipmentType,
			Model model
			) {
		Integer id = service.saveShipmentType(shipmentType);
		String message = "Shipment Type'"+id+"'saved"; 
		model.addAttribute("message", message);
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	} 
	
	/**3.
	 * 
	 */
	@RequestMapping("/all")
	public String getAllShimentTypes(
			Model model
			) {
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
	/**4.
	 * 	
	 */
	@RequestMapping("/delete")
	public String deleteShipmentType(
			@RequestParam("id")Integer id,
			Model model) {
		service.deleteShipmentType(id);
		String message = "Shipment '"+id+"' Deleted";
		model.addAttribute("message",message);
		//fetch new data
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	
	/**5.
	 * 
	 */
	@RequestMapping("/edit")
	public String showEditPage(
			@RequestParam("id")Integer id,
			Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("shipmentType",st);
		return "ShipmentTypeEdit";
	}
	
	/**6.
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateShipmentType(
			@ModelAttribute ShipmentType shipmentType,
			Model model
			) {
		service.updateShipmentType(shipmentType);
		String message = "ShipmentType'"+shipmentType.getShipId()+"' updated";
		model.addAttribute("message", message);
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
	/**7.
	 * 
	 */
	@RequestMapping("/view")
	public String showOneShipment(
			@RequestParam("id")Integer id,
			Model model
			) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("ob",st);
		return "ShipmentTypeView";
	}
	
	/**8.
	 * 
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		return m;
	}
}











