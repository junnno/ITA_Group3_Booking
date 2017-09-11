package com.oocl.genesys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oocl.genesys.criteria.BookingSearchCriteria;
import com.oocl.genesys.model.Booking;
import com.oocl.genesys.model.Container;

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
	public Booking searchBkgByCntrNum(String cntrNum) {
		// TODO Auto-generated method stub
        
        Criteria criteria = getSession().createCriteria(Booking.class);
        Criteria cntrCriteria = criteria.createCriteria("containerList");
        cntrCriteria.add(Restrictions.eq("containerNum",cntrNum));
        return (Booking) cntrCriteria.uniqueResult();
//        List<Booking> bkgList = cntrCriteria.list();
//        for(Booking bkg:bkgList) {
//        	System.out.println("Booking number: "+bkg.getBkgNum());
//        }
//        return bkgList;
	}
	

	@Override
	public List<Booking> searchBooking(BookingSearchCriteria bookingCriteria) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();

		criteria.add(Restrictions.eq("isDeleted", 0));
		
		if(!bookingCriteria.getBkgNum().equals("")) {
			criteria.add(Restrictions.eq("bkgNum", bookingCriteria.getBkgNum()));
		}
		
		if(!bookingCriteria.getFromCity().equals("")) {
			criteria.add(Restrictions.eq("fromCity", bookingCriteria.getFromCity()));
		}
		
		if(!bookingCriteria.getToCity().equals("")) {
			criteria.add(Restrictions.eq("toCity", bookingCriteria.getToCity()));
		}
		System.out.println(bookingCriteria.getStatus());
		if(!bookingCriteria.getStatus().equals("")) {
			criteria.add(Restrictions.eq("status",Integer.parseInt(bookingCriteria.getStatus())));
		}
		
		if(!bookingCriteria.getCntrNum().equals("")) {
	        criteria.createCriteria("containerList")
	        .add(Restrictions.eq("containerNum",bookingCriteria.getCntrNum()));
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return (List<Booking>) criteria.list();
	}

	@Override
	public Container getContainer(Booking bkg, String cntrNum) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Container.class);
		criteria.add(Restrictions.eq("booking", bkg));
		criteria.add(Restrictions.eq("containerNum", cntrNum));
		return (Container) criteria.uniqueResult();
	}
}