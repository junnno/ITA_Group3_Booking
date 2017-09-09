package com.oocl.genesys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.genesys.criteria.BookingSearchCriteria;
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
	public void flushBkg() {
		// TODO Auto-generated method stub
		dao.flushBkg();
	}

	@Override
	public void deleteBkg(String bkgNum) {
		// TODO Auto-generated method stub
		Booking booking = searchBkgByBkgNum(bkgNum);
		if(booking!=null) {
			booking.setIsDeleted(1);
		}
		updateBkg(booking);
//		dao.deleteBkg(bkgNum);
	}

	@Override
	public Booking searchBkgByBkgNum(String bkgNum) {
		// TODO Auto-generated method stub
		return dao.searchBkgByBkgNum(bkgNum);
	}
	
	@Override
	public List<Booking> listAllBooking() {
		return dao.listAllBooking();
	}

	@Override
	public void updateBkg(Booking booking) {
		// TODO Auto-generated method stub
		Booking entity = dao.searchBkgByBkgNum(String.valueOf(booking.getBkgNum()));
        if(entity!=null){
//            entity.setBkgNum(bkg.getBkgNum());
            entity.setConsignee(booking.getConsignee());
            entity.setFromCity(booking.getFromCity());
            entity.setIsApprovedDoc(booking.getIsApprovedDoc());
            entity.setIsGoodCustomer(booking.getIsGoodCustomer());
            entity.setIsValidWeight(booking.getIsValidWeight());
            entity.setShipper(booking.getShipper());
            entity.setStatus(booking.getStatus());
            entity.setToCity(booking.getToCity());
        }
	}

	@Override
	public List<Booking> searchBooking(BookingSearchCriteria criteria) {
		// TODO Auto-generated method stub
		List<Booking> bkgList = dao.searchBooking(criteria);
		return bkgList;
	}
	
	@Override
	public Booking searchBkgByCntrNum(String cntrNum){
		Booking bkgList = dao.searchBkgByCntrNum(cntrNum);
		return bkgList; 
	}

}
