/**
 * "Have a look at ReadMe.md before proceeding for execution"
 * This class creates a singleton object for session factory.
 * In this program Hibernate 5.0 is used and the configuration itself is made free from 
 * hibernate.cfg.xml 
 */
package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
	private static HibernateUtil hu = new HibernateUtil();
	private SessionFactory factory = null;
	
	private HibernateUtil()
	{
		//To load all the properties of Hibernate 5.0
		StandardServiceRegistryBuilder service = new StandardServiceRegistryBuilder();
		service.applySetting("hibernate.connection.autocommit", "false");
		service.applySetting("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		service.applySetting("hibernate.connection.password", "root");
		service.applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
		service.applySetting("hibernate.connection.username", "root");
		service.applySetting("hibernate.current_session_context_class", "thread");
		service.applySetting("hibernate.connection.pool_size", 2);
		service.applySetting("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		service.applySetting("hibernate.show_sql", true);
		service.applySetting("hibernate.format_sql", true);
		service.applySetting("hibernate.hbm2ddl.auto", "update");
		//To build the registry
		ServiceRegistry reg = service.build();
		/**
		 * MetaDataSources -- 
		 * Entry point into working with sources of metadata information (mapping XML, annotations).
		 * Tell Hibernate about sources and then call buildMetadata(), or use getMetadataBuilder() 
		 * to customize how sources are processed (naming strategies, etc).
		 */
		//Creates a metadata sources using the specified service registry
		MetadataSources metadatasources = new MetadataSources(reg);
		//Adds the Model Class that is declared as entity
		metadatasources.addAnnotatedClass(com.pojos.Customer.class);
		//MetadataBuilder is an interface
		//Get a Builder for metadata
		MetadataBuilder mdb = metadatasources.getMetadataBuilder();
		//Actually build the metamodel
		Metadata md = mdb.build();
		//Session Factory is created 
		factory = md.buildSessionFactory();
	}
	//Returns the singleton session factory 
	public static SessionFactory getFactory()
	{
		System.out.println(hu.factory);
		System.out.println("Factory got created");
		return hu.factory;
	}
	
}
