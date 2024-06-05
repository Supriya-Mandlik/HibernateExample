package com.code;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddingDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student stu1 = new Student();
		stu1.setId(1);
		stu1.setName("Ankit Tiwari");
		stu1.setCity("Delhi");
		
		Certificate cer1 = new Certificate();
		cer1.setCourse("Android");
		cer1.setDuration("2 months");
		
		stu1.setCerti(cer1);
		
		Student stu2 = new Student();
		stu2.setId(2);
		stu2.setName("Anvika Gite");
		stu2.setCity("Pune");
		
		Certificate cer2 = new Certificate();
		cer2.setCourse("Java Developer");
		cer2.setDuration("4 months");
		
		stu2.setCerti(cer2);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		// objects save
		session.save(stu1);
		session.save(stu2);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
