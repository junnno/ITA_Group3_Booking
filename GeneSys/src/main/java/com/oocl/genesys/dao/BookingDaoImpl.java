package com.oocl.genesys.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.oocl.genesys.model.Booking;

public class BookingDaoImpl extends AbstractDAO<Integer, Booking> implements BookingDAO {

	@Override
	public void saveBkg(Booking booking) {
		// TODO Auto-generated method stub
		persist(booking);
	}

	@Override
	public void deleteBkg(String bkgNum) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from BOOKING where bkgNum = :bkgNum");
        query.setString("bkgNum", bkgNum);
        query.executeUpdate();

	}

	@Override
	public void updateBkg() {
		// TODO Auto-generated method stub

	}

	@Override
	public Booking searchBkgByBkgNum(String bkgNum) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("bkgNum", bkgNum));
        return (Booking) criteria.uniqueResult();
	}

}
