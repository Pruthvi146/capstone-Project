package com.info.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.info.exception.EventsNotFoundException;
import com.info.model.Coupon;
import com.info.model.Events;
import com.info.service.CouponService;
import com.info.service.EventService;


@Controller
public class CouponController {

	@Autowired
	private CouponService couponService;
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/showCoupons")
	public String viewCouponPage(Model model) {
		List<Events> listEvent = eventService.listAll();
		model.addAttribute("listEvent", listEvent);
		
		return findPaginated1(1, "couponName", "asc", model);
		
	}
	
	

	@GetMapping("/showNewCouponForm")
	public String showNewCouponForm(Model model) {
		// create model attribute to bind form data
		
		Coupon coupon = new Coupon();
		model.addAttribute("coupon", coupon);
		
		List<Events> listEvent = eventService.listAll();
		model.addAttribute("listEvent", listEvent);
		
		List<String> listCategory = Arrays.asList("Sofa", "Table", "Decor","Wardrobe");
        model.addAttribute("listCategory", listCategory);
		
		return "new_coupon";
	}
	@PostMapping("/saveCoupon")
	public String saveCoupon(@ModelAttribute("coupon") Coupon coupon) {
		/*StringBuilder fileNames=new StringBuilder();
		String filename=file.getOriginalFilename();
		Path fileNameAndPath=(Path) Paths.get(uploadDirectory,filename);*/
		
		couponService.saveCoupon(coupon);
		return "redirect:/showCoupons";
	}
	
	@GetMapping("/showFormForUpdateCoupon/{id}")
	public String showFormForUpdateCoupon(@PathVariable ( value = "id") long id, Model model) {
		
		
		Coupon coupon = couponService.getCouponById(id);
		model.addAttribute("coupon", coupon);
		
		List<Events> listEvent = eventService.listAll();
		model.addAttribute("listEvent", listEvent);
		
		return "update_coupon";
	}
	
	
	@GetMapping("/deleteCoupon/{id}")
	public String deleteCoupon(@PathVariable (value = "id") long id) {
		
		
		this.couponService.deleteCouponById(id);
		return "redirect:/showCoupons";
	}
	@GetMapping("/page/{pageNo1}")
	public String findPaginated1(@PathVariable (value = "pageNo1") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Coupon> page = couponService.findPaginated1(pageNo, pageSize, sortField, sortDir);
		List<Coupon> listCoupons = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listCoupons", listCoupons);
		return "showCoupons";
	}
//	<--Events-->
	@Autowired
	private EventService service1;
	
	@GetMapping("/events")
	public String showCouponsList1(Model model) {
		List<Events> listEvents = service1.listAll();
		model.addAttribute("listEvents", listEvents);
		
		return "events";
	}
	
	@GetMapping("/events/new")
	public String showNewForm1(Model model) {
		model.addAttribute("events",new Events());
		model.addAttribute("pageTitle", "Add New Event");
		return "Events_Form";
		
	}
	
	@PostMapping("/events/save")
	public String saveCoupon(Events events, RedirectAttributes ra) {
		try {
		service1.save(events);
		ra.addAttribute("message", "The event has been added successfully.");
		
		}
		catch(Exception e)
		{
			ra.addFlashAttribute("message", "The event is already present.");
		}
		return "redirect:/events";
	}
	
	@GetMapping("/events/edit/{Eid}")
	public String showEditForm1(@PathVariable("Eid") Long Eid, Model model, RedirectAttributes ra) {
		try {
			Events events = service1.get(Eid);
			model.addAttribute("events", events);
			model.addAttribute("pageTitle", "Edit Event (Id: "+ Eid +")");
			return "Events_Form";
		}
		catch(EventsNotFoundException e) {
			ra.addFlashAttribute("message", "The event has been saved successfully");
			return "redirect:/events";
		}
	}
	
	@GetMapping("/events/delete/{Eid}")
	public String deleteCoupons(@PathVariable("Eid") Long Eid, Model model, RedirectAttributes ra) {
		try {
			service1.delete(Eid);
		}
		catch(EventsNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/events";
	}
	
}
