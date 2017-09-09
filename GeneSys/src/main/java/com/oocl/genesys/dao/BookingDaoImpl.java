package com.oocl.genesys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.genesys.criteria.BookingSearchCriteria;
import com.oocl.genesys.model.Booking;

@Repository("bookingDao")
@Transactional
public class BookingDaoImpl extends AbstractDAO<Integer, Booking> implements BookingDAO {

	@Override
	public void saveBkg(Booking booking) {
		// TODO Auto-generated method stub
		persist(booking);
	}
	
	@Override
	public void flushBkg() {
		// TODO Auto-generated method stub
		flush();
	}

	@Override
	public void deleteBkg(String bkgNum) {
		// TODO Auto-generated method stub
		Booking bkg = searchBkgByBkgNum(bkgNum);
		delete(bkg);
	}

	@Override
	public void updateBkg() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Booking> listAllBooking(){
		Criteria criteria = createEntityCriteria();
        List<Booking> bkgList = (List<Booking>) criteria.list();
		return bkgList;
        
	}

	@Override
	public Booking searchBkgByBkgNum(String bkgNum) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("bkgNum", bkgNum));
        return (Booking) criteria.uniqueResult();
	}

	@Override
	public List<Booking> searchBooking(BookingSearchCriteria bookingCriteria) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		System.out.println(bookingCriteria.getBkgNum());
		
		if(bookingCriteria.getBkgNum()!=null) {
			criteria.add(Restrictions.eq("bkgNum", bookingCriteria.getBkgNum()));
		}
		
		if(bookingCriteria.getFromCity()!=null) {
			criteria.add(Restrictions.eq("fromCity", bookingCriteria.getFromCity()));
		}
		
		if(bookingCriteria.getToCity()!=null) {
			criteria.add(Restrictions.eq("toCity", bookingCriteria.getToCity()));
		}
		
		List<Booking> bkgList = criteria.list();
		return bkgList;
	}
}