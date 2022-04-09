package com.ismo.brevets.metier;

import java.util.List;

import com.ismo.brevets.dao.DaoInvention;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Invention;

public class MetierInvention implements IMetier<Invention> {

	private IDAO<Invention> invention = new DaoInvention();

	@Override
	public List<Invention> getAll() {
		return invention.getAll();
	}

	@Override
	public Invention getOne(int id) {
		return invention.getOne(id);
	}

	@Override
	public boolean save(Invention obj) {
		// TODO Auto-generated method stub
		return invention.save(obj);
	}

	@Override
	public boolean update(Invention obj) {
		// TODO Auto-generated method stub
		return invention.update(obj);
	}

	@Override
	public boolean delete(Invention obj) {
		// TODO Auto-generated method stub
		return invention.delete(obj);
	}

}
