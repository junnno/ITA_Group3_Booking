package com.oocl.genesys.dao;

import java.util.List;

import com.oocl.genesys.criteria.BookingSearchCriteria;
import com.oocl.genesys.model.Booking;
import com.oocl.genesys.model.Container;

public interface BookingDAO {
	void saveBkg(Booking booking);
	void flushBkg();
	void deleteBkg(String bkgNum);
	void updateBkg();
	List<Booking> listAllBooking();
	Booking searchBkgByBkgNum(String bkgNum);
	Booking searchBkgByCntrNum(String cntrNum);
	List<Booking> searchBooking(BookingSearchCriteria criteria);
	Container getContainer(Booking bkg, String cntrNum);
}