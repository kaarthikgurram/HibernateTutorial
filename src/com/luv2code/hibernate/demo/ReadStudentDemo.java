package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("Started!");
			Student student = new Student();
			
			session.beginTransaction();
				
			student.setEmail("ramu2aviator@gmail.com");
			student.setFirstName("ramu");
			student.setLastName("gurram");
			
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Done!");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student readStudent = session.get(Student.class, student.getId());
			System.out.println(readStudent);
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		}
}
