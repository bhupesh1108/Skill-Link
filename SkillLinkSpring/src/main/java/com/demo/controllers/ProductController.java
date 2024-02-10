package com.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.demo.model.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/bookinglist")
public class BookingListController {
	@Autowired
	private BookingListService blservice;
	
	@GetMapping("/getbookinglist")
	public ModelAndView getBookingList(HttpSession session) {
		   List<BookingList> bllist=blservice.getAllBookingList();
		   return new ModelAndView("displaybookinglist","bllist",bllist);
		
	}
	
	@GetMapping("/addbookinglist")
	public String displayaddform(HttpSession session) {
		  return "addbookinglist";
		
	}
	
	@PostMapping("/insertBookingList")
	public ModelAndView insertBookingList(@RequestParam int UserID, @RequestParam int SID, @RequestParam String SNameFirst, @RequestParam String SNameLast, @RequestParam int PhoneNumber, @RequestParam double Wages, @RequestParam int Ratings) {
		BookingList bl=new BookingList(UserID, SID, SNameFirst, SNameLast, PhoneNumber, Wages, Ratings);
		blservice.addnewBookingList(bl);
		return new ModelAndView("redirect:/BookingList/getbookinglist");
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editBookingList(@PathVariable("UserID") int UserID) {
		BookingList bl=blservice.getById(UserID);
		return new ModelAndView("editBookingList","bl",bl);
		
	}
	
	@PostMapping("/updateBookingList")
	public ModelAndView updateBookingList(@RequestParam int pid, @RequestParam String pname,@RequestParam int qty,@RequestParam double price) {
		blservice.updateById(new BookingList(UserID, SID, SNameFirst, SNameLast, PhoneNumber, Wages, Ratings));
		return new ModelAndView("redirect:/bookinglist/getbookinglist");
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView deleteBookingList(@PathVariable int UserID) {
		blservice.deleteById(UserID);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("/bookinglist/price/{lpr}/{hpr}")
	public ModelAndView getProductByprice(@PathVariable int lpr,@PathVariable int hpr) {
		List<Product> plist=pservice.getByPrice(lpr,hpr);
		return new ModelAndView("displayproduct","plist",plist);
	}
	
	

}
