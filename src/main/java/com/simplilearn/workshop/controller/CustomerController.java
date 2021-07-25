package com.simplilearn.workshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.model.CountryStateList;
import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.model.PurchaseList;
import com.simplilearn.workshop.model.SalesItemTable;
import com.simplilearn.workshop.model.SalesTable;
import com.simplilearn.workshop.model.ShoeBrand;
import com.simplilearn.workshop.model.ShoeCategory;
import com.simplilearn.workshop.model.ShoeInventory;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.InventoryService;
import com.simplilearn.workshop.services.PurchaseListService;
import com.simplilearn.workshop.services.SaleService;
import com.simplilearn.workshop.services.SalesItemService;

@Controller
public class CustomerController {
	
	
	private static final String BASE_URL = "http://localhost:8000/customer";
	
	private RestTemplate restTemplate;
		
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SalesItemService salesItemService;
	
	@Autowired
	private PurchaseListService purchaseListService;
		
	@GetMapping(path = "/customer/customerhome")
	public ModelAndView customerHome() {
		// make a REST request
		//AdminUsers users = new AdminUsers();
		ModelAndView modelAndView = new ModelAndView("ShoeHomePage");
		//modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	
	@GetMapping(path = "/customer/ShowShoeSelection")
	public ModelAndView displaySelection() {
		List<ShoeInventory> product = inventoryService.getInventory();
		System.out.println(product);	
		ModelAndView modelAndView = new ModelAndView("DisplayShoeSelection");
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	@GetMapping(path = "/customer/applyfiler")
	public ModelAndView applyFilter(@RequestParam("category") String cat, @RequestParam("brand") String brand,
		@RequestParam("colour") String colour, @RequestParam("gender") String gender, @RequestParam("size") String size) {
		List<ShoeInventory> product = inventoryService.getInventory();
		//List<ShoeInventory> filter = inventoryService.getInventoryCat(cat);
		List<ShoeInventory> filter = inventoryService.getInventoryKeyword(cat, brand, colour, gender, size);
		ModelAndView modelAndView = new ModelAndView("DisplayShoeSelection");
		modelAndView.addObject("product", product);
		modelAndView.addObject("filter", filter);
		return modelAndView;
	}
			
	@GetMapping(path = "/customer/selectproduct")
	public ModelAndView displayProductdetails(@RequestParam("shoeid") Integer theId) {
		ShoeInventory product = inventoryService.getInventory(theId);
		System.out.println(product);	
		ModelAndView modelAndView = new ModelAndView("ProductDetails");
		modelAndView.addObject("product", product);
		return modelAndView;
	
	}
	
	
	
	@GetMapping(path = "/customer/cart")
	public ModelAndView addToCart(@RequestParam("shoeid") Integer theId, @RequestParam("quantity") Integer quantity) {
		ShoeInventory product = inventoryService.getInventory(theId);
		System.out.println(product);	
		ModelAndView modelAndView = new ModelAndView("Cart");
		modelAndView.addObject("product", product);
		modelAndView.addObject("quantity", 	quantity);
		return modelAndView;
	
	}
	
	@GetMapping(path = "/customer/showFormForAddCust")
	public ModelAndView showFormForAddCust(@ModelAttribute("product") ShoeInventory product) {
		ModelAndView modelAndView = new ModelAndView("CustomerRegistration");		
		modelAndView.addObject(product);
		Customer customer = new Customer();
		CountryStateList CSlist = new CountryStateList();
		modelAndView.addObject("customer", customer);
		modelAndView.addObject("cslist", CSlist);
		System.out.println(product.getShoename());
		return modelAndView;
	
	}
	
	@PostMapping("/customer/addcustomer")
	public ModelAndView saveCustomer(@Valid 
									/*@RequestParam("shoename") String theShoename, 
									@RequestParam("category") String theCategory, 
									@RequestParam("brand") String theBrand, 
									@RequestParam("size") String theSize, 
									@RequestParam("colour") String theColour, 
									@RequestParam("gender") String theGender, 
									@RequestParam("price") Float thePrice, */
									@ModelAttribute("customer") Customer customer, BindingResult bindingResult, @RequestParam("shoeid") Integer theId) {
		
		
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView1 = new ModelAndView("CustomerRegistration");
			return modelAndView1;
		}	else {
				
		customerService.saveCustomer(customer);
		SalesTable theSale = new SalesTable();
		ShoeInventory product = inventoryService.getInventory(theId);
		ModelAndView modelAndView = new ModelAndView("PaymentPage");
		modelAndView.addObject(customer);
		modelAndView.addObject("sale", theSale);
		modelAndView.addObject("product", product);
		/*modelAndView.addObject(theShoename);
		modelAndView.addObject(theCategory);
		modelAndView.addObject(theBrand);
		modelAndView.addObject(theSize);
		modelAndView.addObject(theColour);
		modelAndView.addObject(theGender);
		modelAndView.addObject(thePrice);*/
		return modelAndView; }
	}
	
	
	@PostMapping("/customer/orderconfirmation")
	public ModelAndView orderconfirmation(@RequestParam("shoeid") Integer theId, 
									@RequestParam("custId") Integer theCustId,
									@ModelAttribute("sale") SalesTable sale) {
		
		saleService.saveSale(sale);
		SalesItemTable theSaleItem = new SalesItemTable();
		ShoeInventory product = inventoryService.getInventory(theId);
		Customer customer = customerService.getCustomer(theCustId);
		ModelAndView modelAndView = new ModelAndView("OrderConfirmation");
		modelAndView.addObject(sale);
		modelAndView.addObject("product", product);
		modelAndView.addObject("customer", customer);
		modelAndView.addObject("saleitem", theSaleItem);
		return modelAndView;
	}
	
	@PostMapping("/customer/ordersummary")
	public ModelAndView ordersummary(@ModelAttribute("saleitem") SalesItemTable saleitem, @RequestParam("customerId") Integer theCustid, 
			@RequestParam("salesId") Integer theSaleid) {
		
		salesItemService.saveSaleItem(saleitem);
		
		PurchaseList purchaselist = new PurchaseList();
		
		SalesItemTable salesitemtable = new SalesItemTable();
		
		Customer customer = customerService.getCustomer(theCustid);
		SalesTable salestable = saleService.getSale(theSaleid);
				
		ModelAndView modelAndView = new ModelAndView("OrderSummary");
		
		modelAndView.addObject("purchaselist", purchaselist);
		modelAndView.addObject("salestable", salestable);
		modelAndView.addObject("customer", customer);
		modelAndView.addObject(saleitem);
		return modelAndView;
	}
	

	@PostMapping("/customer/thankyoupage")
	public ModelAndView thankyouPage(@ModelAttribute("purchaselist") PurchaseList purchaselist) {
		purchaseListService.savePurchaselist(purchaselist);
		ModelAndView modelAndView = new ModelAndView("ThankyouPage");
		return modelAndView;
	}
	
	/*
	@PostMapping("/customer/thankyoupage")
	public ModelAndView thankyouPage(@ModelAttribute("saleitem") SalesItemTable saleitem) {
		
		salesItemService.saveSaleItem(saleitem);
		ModelAndView modelAndView = new ModelAndView("ThankyouPage");
		return modelAndView;
	}*/

	
}
