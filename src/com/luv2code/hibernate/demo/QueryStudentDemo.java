package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("Started!");
			
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			theStudents = session.createQuery("from Student s where s.lastName='gurram' OR s.lastName='parepally'").list();
			
			displayStudents(theStudents);

			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student: theStudents) {
			System.out.println(student);
		}
	}
}
