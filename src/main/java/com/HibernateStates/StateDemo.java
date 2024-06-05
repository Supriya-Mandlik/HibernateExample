package com.HibernateStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
	
	public static void main(String[] args) {
		
		// Practical of Hibernate Object States
		//1] Transient State
		//2] Persistent State
		//3] Detached State
		//4] Removed State
		
		System.out.println("Example:");
		
 SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
   // Creating student Object
   NewStudent student = new NewStudent();
   student.setId(1414);
   student.setName("Peter");
   student.setCity("ABC");
   student.setCerti(new NewCertificate("Java Hibernate Course","2 Months"));
   // student:Transient State
   
   Session s = f.openSession();
   Transaction tx = s.beginTransaction();
   s.save(student);
   // student:Persistent State - object associated with session and Database
   
  student.setName("John");
   
   
 tx.commit(); // it commit the changes in database physically
 
 s.close();
 
 // student:Detached State 
  student.setName("Sachin");
  
  System.out.println(student);
 
 
   f.close();		
		
	}

}
