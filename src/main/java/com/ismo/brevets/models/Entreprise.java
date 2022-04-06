package com.ismo.brevets.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ENTREPRISE")
public class Entreprise {

	@Id
	@Column(name = "NUM_ENTREPRISE")
	private int num;
	@Column(name = "NOM_ENTREPRISE")
	private String nom;
	@Column(name = "ACTIVITE")
	private String activite;
	@Column(name = "CA")
	private double ca;
	@Column(name = "VILLE")
	private String ville;
	@OneToMany(mappedBy = "entreprise")
	private List<Inventeur> inventeurs;
	
	public Entreprise() {
		
	}
	
	public Entreprise(String nom, String activite, double ca, String ville) {
		super();
		this.nom = nom;
		this.activite = activite;
		this.ca = ca;
		this.ville = ville;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	public double getCa() {
		return ca;
	}
	public void setCa(double ca) {
		this.ca = ca;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Inventeur> getInventeurs() {
		return inventeurs;
	}

	public void setInventeurs(List<Inventeur> inventeurs) {
		this.inventeurs = inventeurs;
	} 
}
