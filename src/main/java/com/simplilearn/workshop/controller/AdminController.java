package com.simplilearn.workshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.model.AdminUsers;
import com.simplilearn.workshop.model.CountryStateList;
import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.model.PurchaseList;
import com.simplilearn.workshop.model.SalesItemTable;
import com.simplilearn.workshop.model.SalesTable;
import com.simplilearn.workshop.model.ShoeBrand;
import com.simplilearn.workshop.model.ShoeCategory;
import com.simplilearn.workshop.model.ShoeColour;
import com.simplilearn.workshop.model.ShoeInventory;
import com.simplilearn.workshop.model.ShoeSize;
import com.simplilearn.workshop.repository.BrandRepository;
import com.simplilearn.workshop.repository.SalesItemRepository;
import com.simplilearn.workshop.services.AdminUsersService;
import com.simplilearn.workshop.services.BrandService;
import com.simplilearn.workshop.services.CategoryService;
import com.simplilearn.workshop.services.ColourService;
import com.simplilearn.workshop.services.CountryStateService;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.InventoryService;
import com.simplilearn.workshop.services.PurchaseListService;
import com.simplilearn.workshop.services.SaleService;
import com.simplilearn.workshop.services.SalesItemService;
import com.simplilearn.workshop.services.SizeService;



@Controller
public class AdminController {
	
	private static final String BASE_URL = "http://localhost:8000/login";
	
	private RestTemplate restTemplate;
	
	@Autowired
	private BrandService brandService;
		
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private AdminUsersService adminUsersService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SalesItemService saleItemService;
	
	@Autowired
	private PurchaseListService purchaseListService;
	
	@Autowired
	private ColourService colourService;
	
	@Autowired
	private SizeService sizeService;
	
	@Autowired
	private CountryStateService countryStateService;
	
	@Autowired
	public AdminController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	/****************Login controllers******************/
	
	@GetMapping(path = "/login/users")
	public ModelAndView loginpage() {
		// make a REST request
		AdminUsers users = new AdminUsers();
		ModelAndView modelAndView = new ModelAndView("Login");
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	
	@PostMapping(path = "/login/adminhome")
	public ModelAndView validateLogin(@Valid @ModelAttribute("users") AdminUsers adminusers, BindingResult result) {
		
		String username = adminusers.getUsername();
		String password = adminusers.getPassword();
		
		System.out.println(username);
		System.out.println(password);
		
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("Login");
			return modelAndView;
			
		}else {
				Optional<AdminUsers> user = Optional.of(adminUsersService.getAUsersname(username));
				System.out.println(user);
				if (user.isPresent()) {
					AdminUsers currentUser = adminUsersService.getAUsersname(username);
						
				if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword()) ) {
		
		
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		return modelAndView;
		}else {
			
			String message = "Username or password did not match";
				
			ModelAndView modelAndView = new ModelAndView("Login");
			
			modelAndView.addObject("message", message);
			return modelAndView;
		}
	}else {
		String message = "Username or password did not match";
		
		ModelAndView modelAndView = new ModelAndView("Login");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}

}

	/****************Update Password******************/
	
	@GetMapping(path = "/login/ShowUpdatePassword")
	public ModelAndView showUpdatePassword() {
		ModelAndView modelAndView = new ModelAndView("UpdatePassword");
		AdminUsers users = new AdminUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@PostMapping(path = "/login/updatepassword")
	public ModelAndView updatePassword(@Valid @ModelAttribute("users") AdminUsers adminusers, BindingResult result,  @RequestParam("newpassword") String newpassword) {
		String username = adminusers.getUsername();
		String password = adminusers.getPassword();

		
		if (result.hasErrors()) {
			
			ModelAndView modelAndView = new ModelAndView("UpdatePassword");
			return modelAndView;
			
		}else {
			
				AdminUsers currentUser = adminUsersService.getAUsersname(username);
				if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword()) ) {
					currentUser.setPassword(newpassword);
					this.adminUsersService.saveAUsers(currentUser);
					ModelAndView modelAndView = new ModelAndView("Login");
					return modelAndView;
		}else {
			
			String message = "Username or password did not match";
			
			ModelAndView modelAndView = new ModelAndView("UpdatePassword");
			modelAndView.addObject("message", message);
			return modelAndView;
			
		}
	}
}
	
	/*
	@PostMapping(path = "/login/updatepassword")
	public String updatePassword(@RequestParam("username") String username, @RequestParam("oldpassword") String oldpassword, 
			  @RequestParam("newpassword") String newpassword,  AdminUsers adminusers) {
		
		AdminUsers currentUser = adminUsersService.getAUsersname(username);
		
		if (username.equals(currentUser.getUsername()) && oldpassword.equals(currentUser.getPassword()) ) {
			
			currentUser.setPassword(newpassword);
			this.adminUsersService.saveAUsers(currentUser);
			return "redirect:/login/users";
	}
		
		return "redirect:/login/updatepassword";
		
	}
	*/
	
	/****************Add Admin Users******************/
	
	@GetMapping(path = "/login/ShowAdminUsers")
	public ModelAndView showAdminUsers() {
	
		List<AdminUsers> adminusers = adminUsersService.getAUsers();
		ModelAndView modelAndView = new ModelAndView("list-adminusers");
		modelAndView.addObject("adminusers", adminusers);
		return modelAndView;
	}
	
	@GetMapping(path = "/login/showFormForAddUsers")
	public ModelAndView showFormForAddUsers() {
		ModelAndView modelAndView = new ModelAndView("AddAdminUsers");
		AdminUsers theAdminUser = new AdminUsers();
		modelAndView.addObject("adminusers", theAdminUser);
		return modelAndView;
	}
	
	@PostMapping("/login/addadminusers")
	public ModelAndView saveAdminUsers(@Valid @ModelAttribute("adminusers") AdminUsers adminuser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AddAdminUsers");
			return modelAndView;
			
		}else {
		adminUsersService.saveAUsers(adminuser);
		ModelAndView modelAndView = new ModelAndView("AddAdminUsers");
		return modelAndView;
		}
	}
	
	@GetMapping(path="/login/deleteadminusers")
	public ModelAndView deleteUserById(@RequestParam("id") Integer theId) {
		
		adminUsersService.deleteAUser(theId);
		AdminUsers theAdminUser = new AdminUsers();
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		modelAndView.addObject("adminusers", theAdminUser);
		return modelAndView;
				
	}
	
	
	
	
	/****************Brand controllers******************/
	

	
	@GetMapping(path = "/login/brands")
	public ModelAndView listBrands() {
		// make a REST request
		//ResponseEntity<List<ShoeBrand>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
				//new ParameterizedTypeReference<List<ShoeBrand>>() {
				//});

		//List<ShoeBrand> brands = responseEntity.getBody();
		
		List<ShoeBrand> brands = brandService.getBrands();
		ModelAndView modelAndView = new ModelAndView("list-shoebrands");
		modelAndView.addObject("brands", brands);
		return modelAndView;
	}
	
	
	@GetMapping(path = "/login/showFormForAdd")
	public ModelAndView showFormForAddBrands() {
		ModelAndView modelAndView = new ModelAndView("AddShoeBrand");
		ShoeBrand theBrand = new ShoeBrand();
		modelAndView.addObject("brands", theBrand);
		return modelAndView;
	}
	
	
	@PostMapping("/login/addbrands")
	public ModelAndView saveBrand(@Valid @ModelAttribute("brands") ShoeBrand brand, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AddShoeBrand");
			return modelAndView;
		}else {
		
		brandService.saveBrand(brand);
		ModelAndView modelAndView = new ModelAndView("AddShoeBrand");
		return modelAndView;
	}
}
	

	
	@GetMapping(path="/login/deletebrands")
	public ModelAndView deleteBrandbyId(@RequestParam("brandId") Integer theId) {
		
		brandService.deleteBrand(theId);
		ShoeBrand theBrand = new ShoeBrand();
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		//ModelAndView modelAndView = new ModelAndView("list-shoebrands");
		modelAndView.addObject("brands", theBrand);
		return modelAndView;
				
	}
	
	/****************Category controllers******************/
	
	@GetMapping(path = "/login/categories")
	public ModelAndView listcategories() {
		List<ShoeCategory> categories = categoryService.getCategories();
		ModelAndView modelAndView = new ModelAndView("list-shoecategories");
		modelAndView.addObject("categories", categories);
		return modelAndView;
	}
	
	@GetMapping(path = "/login/showFormForAddCats")
	public ModelAndView showFormForAddCats() {
		ModelAndView modelAndView = new ModelAndView("AddShoeCategory");
		ShoeCategory theCategory = new ShoeCategory();
		modelAndView.addObject("categories", theCategory);
		return modelAndView;
	}
	
	
	@PostMapping("/login/addcategories")
	public ModelAndView saveCategory(@Valid @ModelAttribute("categories") ShoeCategory category, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AddShoeCategory");
			return modelAndView;
		}else {
			
		categoryService.saveCategory(category);
		ModelAndView modelAndView = new ModelAndView("AddShoeCategory");
		return modelAndView;
	}
}

	
	@GetMapping(path="/login/deletecategories")
	public ModelAndView deleteCategoryById(@RequestParam("categoryId") Integer theId) {
		
		categoryService.deleteCategory(theId);
		ShoeCategory theCategory = new ShoeCategory();
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		modelAndView.addObject("categories", theCategory);
		return modelAndView;
				
	}
	
	/****************Inventory controllers******************/
	
	@GetMapping(path = "/login/inventory")
	public ModelAndView listinventory() {
		List<ShoeInventory> inventory = inventoryService.getInventory();
		ModelAndView modelAndView = new ModelAndView("list-shoeinventory");
		modelAndView.addObject("inventory", inventory);
		return modelAndView;
	}
	
	@GetMapping(path = "/login/showFormForAddInv")
	public ModelAndView showFormForAddInv() {
		ModelAndView modelAndView = new ModelAndView("AddShoeInventory");
		ShoeInventory theInventory = new ShoeInventory();
		modelAndView.addObject("inventory", theInventory);
		return modelAndView;
	}
	
	
	@PostMapping("/login/addinventory")
	public ModelAndView saveInventory(@Valid @ModelAttribute("inventory") ShoeInventory inventory, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AddShoeInventory");
			return modelAndView;			
		}else {
		
		inventoryService.saveInventory(inventory);
		ModelAndView modelAndView = new ModelAndView("AddShoeInventory");
		return modelAndView;
	}
}
	
	
	@GetMapping(path="/login/deleteinventory")
	public ModelAndView deleteInventoryById(@RequestParam("shoeid") Integer theId) {
		
		inventoryService.deleteInventory(theId);
		ShoeInventory theInventory = new ShoeInventory();
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		modelAndView.addObject("inventory", theInventory);
		return modelAndView;
				
	}
	
	
	/****************Colour controller******************/
	
	@GetMapping(path = "/login/colours")
	public ModelAndView listcolours() {
		List<ShoeColour> colours = colourService.getColours();
		ModelAndView modelAndView = new ModelAndView("list-shoecolours");
		modelAndView.addObject("colours", colours);
		return modelAndView;
	}
	
	@GetMapping(path = "/login/showFormForAddClrs")
	public ModelAndView showFormForAddColours() {
		ModelAndView modelAndView = new ModelAndView("AddShoeColour");
		ShoeColour thecolour = new ShoeColour();
		modelAndView.addObject("colours", thecolour);
		return modelAndView;
	}
	
	
	@PostMapping("/login/addcolours")
	public ModelAndView savecolour(@Valid @ModelAttribute("colours") ShoeColour colour, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AddShoeColour");
			return modelAndView;
		}else {
			
		colourService.saveColour(colour);
		ModelAndView modelAndView = new ModelAndView("AddShoeColour");
		return modelAndView;
	}
}

	
	@GetMapping(path="/login/deletecolours")
	public ModelAndView deletecolourById(@RequestParam("colourid") Integer theId) {
		
		colourService.deleteColour(theId);
		ShoeColour thecolour = new ShoeColour();
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		modelAndView.addObject("colours", thecolour);
		return modelAndView;
				
	}
	
	/****************Size controllers******************/
	
	@GetMapping(path = "/login/sizes")
	public ModelAndView listsizes() {
		List<ShoeSize> sizes = sizeService.getSizes();
		ModelAndView modelAndView = new ModelAndView("list-shoesizes");
		modelAndView.addObject("sizes", sizes);
		return modelAndView;
	}
	
	@GetMapping(path = "/login/showFormForAddSizes")
	public ModelAndView showFormForAddSizes() {
		ModelAndView modelAndView = new ModelAndView("AddShoeSize");
		ShoeSize theSize = new ShoeSize();
		modelAndView.addObject("sizes", theSize);
		return modelAndView;
	}
	
	
	@PostMapping("/login/addsizes")
	public ModelAndView saveSize(@Valid @ModelAttribute("sizes") ShoeSize Size, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AddShoeSize");
			return modelAndView;
		}else {
			
		sizeService.saveSize(Size);
		ModelAndView modelAndView = new ModelAndView("AddShoeSize");
		return modelAndView;
	}
}

	
	@GetMapping(path="/login/deleteSizes")
	public ModelAndView deleteSizeById(@RequestParam("sizeid") Integer theId) {
		
		sizeService.deleteSize(theId);
		ShoeSize theSize = new ShoeSize();
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		modelAndView.addObject("Sizes", theSize);
		return modelAndView;
				
	}
	
	
	/****************Country/State controllers******************/
	
	@GetMapping(path = "/login/CountryStates")
	public ModelAndView listCountryStates() {
		List<CountryStateList> countrystates = countryStateService.getCountryStates();
		ModelAndView modelAndView = new ModelAndView("list-countrystates");
		modelAndView.addObject("countrystates", countrystates);
		return modelAndView;
	}
	
	@GetMapping(path = "/login/showFormForAddCtry")
	public ModelAndView showFormForAddCountryStates() {
		ModelAndView modelAndView = new ModelAndView("AddCountryStates");
		CountryStateList theCountrystate = new CountryStateList();
		modelAndView.addObject("countrystates", theCountrystate);
		return modelAndView;
	}
	
	
	@PostMapping("/login/addCountrystates")
	public ModelAndView saveCountryState(@Valid @ModelAttribute("countrystates") CountryStateList CountryState, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("AddCountryStates");
			return modelAndView;
		}else {
			
		countryStateService.saveCountryState(CountryState);
		ModelAndView modelAndView = new ModelAndView("AddCountryStates");
		return modelAndView;
	}
}

	
	@GetMapping(path="/login/deleteCountryStates")
	public ModelAndView deleteCountryStateById(@RequestParam("id") Integer theId) {
		
		countryStateService.deleteCountryState(theId);
		CountryStateList theCountrystate = new CountryStateList();
		ModelAndView modelAndView = new ModelAndView("AdminHome");
		modelAndView.addObject("CountryStates", theCountrystate);
		return modelAndView;
				
	}
	
	
	
	/****************Reports******************/
	
	@GetMapping(path="/login/reports")
	public ModelAndView reports() {
		ModelAndView modelAndView = new ModelAndView("Reports");		
		return modelAndView;
	}
	
	@GetMapping(path="/login/customerreport")
	public ModelAndView CustomerReport() {
		List<Customer> customer = customerService.getCustomers();
		ModelAndView modelAndView = new ModelAndView("CustomerReport");
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}
	
	@GetMapping(path="/login/applycustomerfiler")
	public ModelAndView applyCustomerFilter(@RequestParam("lastname") String lastname, @RequestParam("phonenumber") String phonenumber, @RequestParam("email") String email,
			@RequestParam("city") String city, @RequestParam("state") String state,
			@RequestParam("country") String country) {
			List<Customer> customer = customerService.getCustomers();
			//List<ShoeInventory> filter = inventoryService.getInventoryCat(cat);
			List<Customer> filter = customerService.getCustomerKeyword(lastname, phonenumber, email, city, state, country);
			ModelAndView modelAndView = new ModelAndView("CustomerReport");
			modelAndView.addObject("customer", customer);
			modelAndView.addObject("filter", filter);
			return modelAndView;
		}
	
	
	@GetMapping(path="/login/purchasereport")
	public ModelAndView purchaseReport() {
		List<PurchaseList> purchaselist = purchaseListService.getPurchaselist();
		ModelAndView modelAndView = new ModelAndView("PurchaseReport");
		modelAndView.addObject("purchaselist", purchaselist);
		return modelAndView;
	}
	
	
	@GetMapping(path="/login/applypurchasefiler")
	public ModelAndView applyPurchaseFilter(@RequestParam("category") String category, @RequestParam("brand") String brand, @RequestParam("paymenttype") String paymentmethod) {
			List<PurchaseList> purchaselist = purchaseListService.getPurchaselist();
			//List<ShoeInventory> filter = inventoryService.getInventoryCat(cat);
			List<PurchaseList> filter = purchaseListService.findAllbyKeyword(category, brand, paymentmethod);
			ModelAndView modelAndView = new ModelAndView("PurchaseReport");
			modelAndView.addObject("purchaselist", purchaselist);
			modelAndView.addObject("filter", filter);
			return modelAndView;
		}
	
	
	
	
}
	

