package com.HibernateStates;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewStudent {
	
	@Id
	private int id;
	private String name;
	private String city;
	private NewCertificate certi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public NewCertificate getCerti() {
		return certi;
	}
	public void setCerti(NewCertificate certi) {
		this.certi = certi;
	}
	
	public NewStudent(int id, String name, String city, NewCertificate certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certi = certi;
	}
	
	public NewStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NewStudent [id=" + id + ", name=" + name + ", city=" + city + ", certi=" + certi + "]";
	}
	

}
