package com.OneToMany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingTest {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		// question
		Question1 q1 = new Question1();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java ?");
		 
		// answers
		Answer1 a1 = new Answer1();
		a1.setAnswerId(343);
		a1.setAnswer("Java is Programming Language.");
		a1.setQuestion(q1);
		
		Answer1 a2 = new Answer1();
		a2.setAnswerId(33);
		a2.setAnswer("With the help of java we can create softwares.");
		a2.setQuestion(q1);
		
		Answer1 a3 = new Answer1();
		a3.setAnswerId(363);
		a3.setAnswer("Java has Different Types of Frameworks.");
		a3.setQuestion(q1);
		
		List<Answer1> list = new ArrayList<Answer1>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		// session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//save
		//session.save(q1);
		//session.save(a1);
		//session.save(a2);
		//session.save(a3);
		
		Question1 que = (Question1)session.get(Question1.class, 1212);
		System.out.println(que.getQuestion());
		
		for (Answer1 ans : que.getAnswers()) {
			System.out.println(ans.getAnswer());
		}
		
		//HQL Queries
		// how to execute join query
		// to execute join query we need OneToMany relationship
		Query q = session.createQuery("select q.question,q.questionId,a.answer from Question1 as q INNER JOIN q.answers as a");
		List<Object []> li = q.getResultList();
		
		for (Object[] objects : li) {
			System.out.println(Arrays.toString(objects));
		}
		
		tx.commit();
		
		session.close();
		factory.close();
		
	}

}
