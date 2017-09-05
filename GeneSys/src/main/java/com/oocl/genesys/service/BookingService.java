package com.oocl.genesys.service;

import java.util.List;

import com.oocl.genesys.model.Booking;

public interface BookingService {
	void saveBkg(Booking bkgNum);
	void deleteBkg(String bkgNum);
	Booking searchBkgByBkgNum(String bkgNum);
	public List<Booking> listAllBooking();
	void updateBkg(Booking bkg);
}
