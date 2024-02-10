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

import com.demo.model.MyUser;
import com.demo.model.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/bookinglist")
public class BookingListController {
	@Autowired
	private BookingListService blservice;
	
	@GetMapping("/getbookinglist")
	public ModelAndView getProducts(HttpSession session) {
		MyUser u=(MyUser) session.getAttribute("user");
		if(u!=null) {
		   System.out.println(u);
		   List<Product> plist=pservice.getAllProducts();
		   return new ModelAndView("displayproduct","plist",plist);
		}
		return new ModelAndView("redirect:/login/");
	}
	
	@GetMapping("/addproduct")
	public String displayaddform(HttpSession session) {
		MyUser u=(MyUser) session.getAttribute("user");
		if(u!=null) 
		   return "addproduct";
		return "redirect:/login/"; 
	}
	
	@PostMapping("/insertBookingList")
	public ModelAndView insertBookingList(@RequestParam int UserID,@RequestParam int SID, @RequestParam String pname,@RequestParam int qty,@RequestParam double price) {
		BookingList bl=new BookingList(UserID, SID, SNameFirst, SNameLast, PhoneNumber, Wages, Ratings);
		
		private int UserID;
		private int SID;
		private String SNameFirst;
		private String SNameLast;
		private int PhoneNumber;
		private double Wages;
		private int Ratings;
		
		blservice.addnewBookingList(bl);
		return new ModelAndView("redirect:/bookinglist/getbookinglist");
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") int pid) {
		Product p=pservice.getById(pid);
		return new ModelAndView("editProduct","p",p);
		
	}
	
	@PostMapping("/updateBookingList")
	public ModelAndView updateProdut(@RequestParam int pid, @RequestParam String pname,@RequestParam int qty,@RequestParam double price) {
		pservice.updateById(new Product(pid,pname,qty,price));
		return new ModelAndView("redirect:/bookinglist/getbookinglist");
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView deleteBookingList(@PathVariable int id) {
		blservice.deleteById(id);
		return new ModelAndView("redirect:/bookinglist/getbookinglist");
	}
	
	

}
