package com.oocl.genesys.service;

import java.util.List;

import com.oocl.genesys.criteria.BookingSearchCriteria;
import com.oocl.genesys.model.Booking;
import com.oocl.genesys.model.Container;

public interface BookingService {
	void saveBkg(Booking bkgNum);
	void flushBkg();
	void deleteBkg(String bkgNum);
	Booking searchBkgByBkgNum(String bkgNum);
	List<Booking> listAllBooking();
	void updateBkg(Booking bkg);
	List<Booking> searchBooking(BookingSearchCriteria criteria);
	Booking searchBkgByCntrNum(String cntrNum);
	Container getContainer(Booking bkg, String cntrNum);
}
