package com.ismo.brevets.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTION")
public class Invention {

	@Id
	@Column(name = "NUM_INVENTION")
	private int num;
	@Column(name = "DESCRIPTIF")
	private String descriptif; 
	@Column(name = "RESUME")
	private String resume;
	@ManyToOne
	@JoinColumn(name = "NUM_DOMAINE")
	private Domaine domaine;
	@OneToMany(mappedBy = "invention")
	private List<Brevet> brevets;
	
	public Invention() {
		
	}
	
	public Invention(int num, String descriptif, String resume) {
		super();
		this.num = num;
		this.descriptif = descriptif;
		this.resume = resume;
	}
	
	public Invention(int num, String descriptif, String resume, Domaine domaine) {
		super();
		this.num = num;
		this.descriptif = descriptif;
		this.resume = resume;
		this.domaine = domaine;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public List<Brevet> getBrevets() {
		return brevets;
	}

	public void setBrevets(List<Brevet> brevets) {
		this.brevets = brevets;
	}
}
