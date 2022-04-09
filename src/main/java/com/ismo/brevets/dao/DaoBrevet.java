package com.ismo.brevets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.models.Brevet;
import com.ismo.brevets.models.Domaine;

public class DaoBrevet implements IDAO<Brevet> {

	@Override
	public List<Brevet> getAll() {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Brevet> brvs = s.createQuery("from Brevet").getResultList();
		t.commit();
		s.close();
		return brvs;
	}

	@Override
	public Brevet getOne(int id) {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Brevet b = s.get(Brevet.class, id);
		t.commit();
		s.close();
		return b;
	}

	public boolean save(Brevet obj) {
		try {
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			s.save(obj);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Brevet obj) {
		try {
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			s.update(obj);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Brevet obj) {
		try {
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			s.delete(obj);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}
