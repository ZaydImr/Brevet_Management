package com.ismo.brevets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.models.Domaine;
import com.ismo.brevets.models.Inventeur;

public class DaoInventeur implements IDAO<Inventeur> {

	@Override
	public List<Inventeur> getAll() {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Inventeur> invts = s.createQuery("from Inventeur").getResultList();
		t.commit();
		s.close();
		return invts;
	}

	@Override
	public Inventeur getOne(int id) {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Inventeur d = s.get(Inventeur.class, id);
		t.commit();
		s.close();
		return d;
	}

	public boolean save(Inventeur obj) {
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
	public boolean update(Inventeur obj) {
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
	public boolean delete(Inventeur obj) {
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
