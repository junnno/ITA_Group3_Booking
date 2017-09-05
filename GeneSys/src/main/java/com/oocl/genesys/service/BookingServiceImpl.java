package com.oocl.genesys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.genesys.dao.BookingDAO;
import com.oocl.genesys.model.Booking;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
    BookingDAO dao;
	@Override
	public void saveBkg(Booking booking) {
		// TODO Auto-generated method stub
		dao.saveBkg(booking);

	}

	@Override
	public void deleteBkg(String bkgNum) {
		// TODO Auto-generated method stub
		dao.deleteBkg(bkgNum);
	}

	@Override
	public Booking searchBkgByBkgNum(String bkgNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Booking> listAllBooking() {
		return dao.listAllBooking();
	}

	@Override
	public void updateBkg(Booking bkg) {
		// TODO Auto-generated method stub
		Booking entity = dao.searchBkgByBkgNum(bkg.getBkgNum());
        if(entity!=null){
//            entity.setBkgNum(bkg.getBkgNum());
            entity.setIsApproved(bkg.getIsApproved());
            entity.setIsGoodCustomer(bkg.getIsGoodCustomer());
            entity.setIsValidWeight(bkg.getIsValidWeight());
            entity.setStatus(bkg.getStatus());
            entity.setFromCity(bkg.getFromCity());
            entity.setToCity(bkg.getFromCity());
        }
	}

}
