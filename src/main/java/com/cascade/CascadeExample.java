package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.OneToMany.Answer1;
import com.OneToMany.Question1;


public class CascadeExample {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		Question1 q = new Question1();
		q.setQuestionId(567);
		q.setQuestion("What is Cascading ? ");
		
		Answer1 a1 = new Answer1(23423,"In Hibernate it is important concept.");
		Answer1 a2 = new Answer1(255,"Second Answer.");
		Answer1 a3 = new Answer1(35,"Third Answer.");
		
		List<Answer1> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q.setAnswers(list);
		
		Transaction tx = s.beginTransaction();
		
		s.save(q);
		
		tx.commit();
		
		s.close();
		factory.close();
		
	}

}
