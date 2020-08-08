package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("Started!");
			Student student1 = new Student();
			Student student2 = new Student();
			
			session.beginTransaction();
				
			student1.setEmail("sahithiamity@gmail.com");
			student1.setFirstName("sahithi");
			student1.setLastName("parepally");
			
			student2.setEmail("lucky@gmail.com");
			student2.setFirstName("satwik");
			student2.setLastName("gurram");
			
			session.save(student1);
			session.save(student2);
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		}
		

	}
