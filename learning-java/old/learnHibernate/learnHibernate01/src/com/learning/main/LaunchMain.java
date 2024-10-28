package com.learning.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entity.Student;

public class LaunchMain {
	public static void main(String[] args) {
		Student std = new Student();
		
		std.setId(5);
		std.setName("Deb");
		std.setAge(27);
		std.setAddress("Bengaluru");
		
		/*
		 * activate the Hibernate
		 */
		Configuration config = new Configuration();
		
		/*
		 * load the hibernate.config.xml file into the configuration object
		 */
		config.configure("/hibernate.config.xml");
		
		/*
		 * build the session Factory object using configuration object
		 * load and register driver, establish the connect and create the prepared statement
		 */
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		/*
		 * to perform operation(Task) create on session object
		 */
		Session session=sessionFactory.openSession();
		
		/*
		 * begin the transaction w.r.t to particular session
		 */
		Transaction transaction=session.beginTransaction();
		
		/*
		 * performing insert operation
		 */
		session.save(std);
		
		/*
		 * commit the operation
		 */
		transaction.commit();
		
		/*
		 * close the session
		 */
		session.close();
	}
}
