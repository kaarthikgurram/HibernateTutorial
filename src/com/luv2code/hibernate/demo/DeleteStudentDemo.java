package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("Started!");
			int studentId = 7;
			Student student = new Student();
			
			session.beginTransaction();
			
			student = session.get(Student.class, studentId);
//			
//			session.delete(student);
			System.out.println(student);
			
			session.createQuery("delete from Student where  id = 6").executeUpdate();

			session.getTransaction().commit();
			System.out.println("Done!");
			
	

			
		} finally {
			factory.close();
		}
		}
}
