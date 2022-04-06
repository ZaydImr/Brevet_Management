package com.ismo.brevets.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.brevets.models.Inventeur;
import com.ismo.brevets.models.Invention;
import com.ismo.brevets.models.KeyValue;

public class DaoInvention implements IDAO<Invention> {

	@Override
	public List<Invention> getAll() {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Invention> invts = s.createQuery("from Invention").getResultList();
		t.commit();
		s.close();
		return invts;
	}

	@Override
	public Invention getOne(int id) {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Invention d = s.get(Invention.class, id);
		t.commit();
		s.close(); 
		return d;
	}

	@Override
	public boolean save(Invention obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Invention obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Invention obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<KeyValue> getAllByDomaine() {
		List<KeyValue> inventions = new ArrayList<KeyValue>();
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Object[]> inventionsFromQuery = (List<Object[]>) s.createQuery("select (select nom from Domaine d where d.num = i.domaine ), count(NUM_INVENTION) from Invention i GROUP BY domaine").getResultList();
		for (Object[] invention : inventionsFromQuery) {
			inventions.add(new KeyValue((String) invention[0],(Long)invention[1]));
		}
		t.commit();
		s.close(); 
		
		return inventions;
	}
	
	public List<KeyValue> getAllByEntreprise() {
		List<KeyValue> inventions = new ArrayList<KeyValue>();
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		String query = "SELECT e.nom, COUNT(i.num)  FROM Invention i "
				+ "inner join Brevet b on b.invention.num = i.num "
				+ "inner join Inventeur inv on inv.num = b.inventeur.num "
				+ "inner join Entreprise e on e.num = inv.entreprise.num "
				+ "GROUP BY e";
		List<Object[]> inventionsFromQuery = (List<Object[]>) s.createQuery(query).getResultList();
		for (Object[] invention : inventionsFromQuery) {
			inventions.add(new KeyValue((String) invention[0],(Long)invention[1]));
		}
		t.commit();
		s.close(); 
		
		return inventions;
	}
	
	

}
