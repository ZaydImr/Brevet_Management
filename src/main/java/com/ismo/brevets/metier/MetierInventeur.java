package com.ismo.brevets.metier;

import java.util.List;

import com.ismo.brevets.dao.DaoInventeur;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Inventeur;

public class MetierInventeur implements IMetier<Inventeur> {
	
	private IDAO<Inventeur> inventeur = new DaoInventeur();

	@Override
	public List<Inventeur> getAll() {
		return inventeur.getAll();
	}

	@Override
	public Inventeur getOne(int id) {
		return inventeur.getOne(id);
	}

	@Override
	public boolean save(Inventeur obj) {
		// TODO Auto-generated method stub
		return inventeur.save(obj);
	}

	@Override
	public boolean update(Inventeur obj) {
		// TODO Auto-generated method stub
		return inventeur.update(obj);
	}

	@Override
	public boolean delete(Inventeur obj) {
		// TODO Auto-generated method stub
		return inventeur.delete(obj);
	}

}
