package com.ismo.brevets.metier;


import java.util.List;

import com.ismo.brevets.dao.DaoEntreprise;
import com.ismo.brevets.dao.IDAO;
import com.ismo.brevets.models.Entreprise;

public class MetierEntreprise implements IMetier<Entreprise> {
	
	private IDAO<Entreprise> daoEntreprise = new DaoEntreprise();

	@Override
	public List<Entreprise> getAll() {
		return daoEntreprise.getAll();
	}

	@Override
	public Entreprise getOne(int id) {
		return daoEntreprise.getOne(id);
	}

	@Override
	public boolean save(Entreprise obj) {
		return daoEntreprise.save(obj);
	}

	@Override
	public boolean update(Entreprise obj) {
		return daoEntreprise.update(obj);
	}

	@Override
	public boolean delete(Entreprise obj) {
		return daoEntreprise.delete(obj);
	}

}
