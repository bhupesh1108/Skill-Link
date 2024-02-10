package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class BookingListImpl implements BookingListService{
	@Autowired
	 private BookingListDao bldao;

	public List<BookingList> getAllBookingList() {
		return bldao.findAll();
	}

	@Override
	public void addnewBookingList(BookingList bl) {
		bldao.save(bl);
		
	}

	@Override
	public BookingList getById(int UserID) {
		 Optional<BookingList> op=bldao.findById(UserID);
		 if(op.isPresent()) {
			 return op.get();
		 }
		 return null;
	}

	@Override
	public void updateById(BookingList bookinglist) {
		Optional<BookingList> op=bldao.findById(bookinglist.getUserID());
		if(op.isPresent()) {
			BookingList bl=op.get();
			bl.setSNameFirst(bookinglist.getSNameFirst());
			bl.setSNameLast(bookinglist.getSNameLast());
			bl.setPhoneNumber(bookinglist.getPhoneNumber());
			bl.setWages(bookinglist.getWages());
			bl.setRatings(bookinglist.getRatings());
			
			
			bldao.save(bl);
			
		}
		
	}

	@Override
	public void deleteById(int UserID) {
		bldao.deleteById(UserID);
		
	}

//	@Override
//	public List<BookingList> getByPrice(int lpr, int hpr) {
//		List<BookingList> bllist=bldao.findbyPrice(lpr,hpr);
//		System.out.println(bllist);
//		return bllist;
//	}

}
