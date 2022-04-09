package com.ismo.brevets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.models.Domaine;
import com.ismo.brevets.models.Entreprise;

public class DaoEntreprise implements IDAO<Entreprise> {

	@Override
	public List<Entreprise> getAll() {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Entreprise> ents = s.createQuery("from Entreprise").getResultList();
		t.commit();
		s.close();
		return ents;
	}

	@Override
	public Entreprise getOne(int id) {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Entreprise e = s.get(Entreprise.class, id);
		t.commit();
		s.close();
		return e;
	}

	public boolean save(Entreprise obj) {
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
	public boolean update(Entreprise obj) {
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
	public boolean delete(Entreprise obj) {
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
