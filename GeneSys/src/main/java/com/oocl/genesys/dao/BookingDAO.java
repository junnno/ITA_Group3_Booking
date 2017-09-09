package com.oocl.genesys.dao;

import java.util.List;

import com.oocl.genesys.model.Booking;

public interface BookingDAO {
	void saveBkg(Booking booking);
	void flushBkg();
	void deleteBkg(String bkgNum);
	void updateBkg();
	public List<Booking> listAllBooking();
	Booking searchBkgByBkgNum(String bkgNum);
	
}
