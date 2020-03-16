package com.hibernate.example.HibernateFirstExpWithMaven;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hibernate.example.pojo.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory = meta.getSessionFactoryBuilder().build();  

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Employee e = new Employee();

		e.setId(2);
		e.setFirstName("aqeeb");
		e.setLastName("khaja");

		session.save(e);
		t.commit();
		System.err.println("Data Stored Successfully");
		factory.close();
		session.close();
	}
}
