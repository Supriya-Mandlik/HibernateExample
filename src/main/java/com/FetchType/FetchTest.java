package com.FetchType;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchTest {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		// question
		Question2 q1 = new Question2();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java ?");
		 
		// answers
		Answer2 a1 = new Answer2();
		a1.setAnswerId(343);
		a1.setAnswer("Java is Programming Language.");
		a1.setQuestion(q1);
		
		Answer2 a2 = new Answer2();
		a2.setAnswerId(33);
		a2.setAnswer("With the help of java we can create softwares.");
		a2.setQuestion(q1);
		
		Answer2 a3 = new Answer2();
		a3.setAnswerId(363);
		a3.setAnswer("Java has Different Types of Frameworks.");
		a3.setQuestion(q1);
		
		List<Answer2> list = new ArrayList<Answer2>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		// session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//save
//		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
		
		Question2 que = (Question2)session.get(Question2.class, 1212);
		System.out.println(que.getQuestionId());
		System.out.println(que.getQuestion());
		
		// Lazy Loading
		System.out.println(que.getAnswers().size());
		
		
		tx.commit();
		
		session.close();
		factory.close();
		
	}

}
