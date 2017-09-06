package com.oocl.genesys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        criteria.add(Restrictions.eq("bkgNum", Integer.valueOf(bkgNum)));
        return (Booking) criteria.uniqueResult();
	}

}
