package com.code;

import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// to fetch data from database using hibernate
public class FetchDemo {
	
	public static void main(String[] args) {
		
		// get(),load()
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		 //creating student
        Student st = new Student();
        st.setId(107);
        st.setName("DipaK");
        st.setCity("Akole");
        System.out.println(st);
        
        // creating object of address class
        Address add = new Address();
        add.setStreet("Street6");
        add.setCity("Akole");
        add.setOpen(true);
        add.setAddedDate(new Date());
        add.setX(1234.234);
        
		
		// get() and load() methods are available in session
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(add);
		
		//get()-Student:105
		System.out.println("****Using get() method****");
	Student student = (Student)session.get(Student.class,105);  // it will return object of type student so we have to typecast 
	System.out.println(student);	
	
	//Student student1 = (Student)session.get(Student.class,105);
	//System.out.println(student1);

	System.out.println("****using Load Method****");
		Address ad = (Address)session.load(Address.class,1);
		System.out.println(ad);
	   // System.out.println(ad.getStreet()+":"+ad.getCity());
	    
	    //Address ad1 = (Address)session.load(Address.class,1);
	   // System.out.println(ad1);
	   // System.out.println(ad1.getStreet()+":"+ad1.getAddedDate());
		
	    tx.commit();
		session.close();
		factory.close();
		
	}

}
