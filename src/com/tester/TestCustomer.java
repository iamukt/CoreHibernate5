/**
 * Have a look at ReadMe.md before proceeding for execution
 * This is a tester file that runs an insert operation on the database 
 * through the use of Hibernate's save method
 * 
 */
package com.tester;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Customer;
import com.util.HibernateUtil;

public class TestCustomer 
{
	public static void main(String[] args) 
	{
		//Creating of an Customer onject
		Customer cc = new Customer();
		//Setting name property
		cc.setName("Hodor");
		
		//Getting the session from session factory
		Session sess = HibernateUtil.getFactory().getCurrentSession();
		
		Transaction tx = sess.getTransaction();
		//Transaction Started
		tx.begin();
		//Transient object is saves and mapped to the database
		sess.save(cc);
		//Transaction Started
		tx.commit();
	}
	
}
