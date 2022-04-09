package com.ismo.brevets.metier;

import java.util.List;

import com.ismo.brevets.dao.DaoDomaine;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Domaine;

public class MetierDomaine implements IMetier<Domaine> {
	
	private IDAO<Domaine> domaine = new DaoDomaine(); 

	@Override
	public List<Domaine> getAll() {
		return domaine.getAll();
	}

	@Override
	public Domaine getOne(int id) {
		return domaine.getOne(id);
	}

	@Override
	public boolean save(Domaine obj) {
		return domaine.save(obj);
	}

	@Override
	public boolean update(Domaine obj) {
		return domaine.update(obj);
	}

	@Override
	public boolean delete(Domaine obj) {
		return domaine.delete(obj);
	}

}
