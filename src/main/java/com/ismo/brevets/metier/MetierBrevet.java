package com.ismo.brevets.metier;

import java.util.List;

import com.ismo.brevets.dao.DaoBrevet;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Brevet;

public class MetierBrevet implements IMetier<Brevet> {
	
	private IDAO<Brevet> brevet = new DaoBrevet();

	
	@Override
	public List<Brevet> getAll() {
		return brevet.getAll();
	}

	@Override
	public Brevet getOne(int id) {
		// TODO Auto-generated method stub
		return brevet.getOne(id);
	}

	@Override
	public boolean save(Brevet obj) {
		// TODO Auto-generated method stub
		return brevet.save(obj);
	}

	@Override
	public boolean update(Brevet obj) {
		// TODO Auto-generated method stub
		return brevet.update(obj);
	}

	@Override
	public boolean delete(Brevet obj) {
		// TODO Auto-generated method stub
		return brevet.delete(obj);
	}

}
