package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("Started!");
			int studentId = 4;
			Student student = new Student();
			
			session.beginTransaction();
			
			student = session.get(Student.class, studentId);
			
			student.setLastName("gurram");
			System.out.println(student);

			session.getTransaction().commit();
			System.out.println("Done!");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='kaarthik4allgmail.com'")
			.executeUpdate();
			session.getTransaction().commit();

			
		} finally {
			factory.close();
		}
		}
}
