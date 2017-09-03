package com.oocl.genesys.dao;

import com.oocl.genesys.model.Booking;

public interface BookingDAO {
	void saveBkg(Booking booking);
	void deleteBkg(String bkgNum);
	void updateBkg();
	Booking searchBkgByBkgNum(String bkgNum);
	
	
}
