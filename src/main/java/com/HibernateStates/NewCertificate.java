package com.HibernateStates;

import javax.persistence.Embeddable;

@Embeddable
public class NewCertificate {
	
	private String course;
	private String duration;
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public NewCertificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}
	
	public NewCertificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NewCertificate [course=" + course + ", duration=" + duration + "]";
	}
	
	
}
