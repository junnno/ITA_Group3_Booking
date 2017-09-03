package com.oocl.genesys.service;

import com.oocl.genesys.model.Booking;

public interface BookingService {
	void saveBkg(Booking bkgNum);
	void deleteBkg(String bkgNum);
	Booking searchBkgByBkgNum(String bkgNum);
	void updateBkg(Booking bkg);
}
