/**
 * Have a look at ReadMe.md before proceeding for execution
 * This a Pojo 
 */
package com.pojos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Customer 
{
	private int cid;
	private String name;
	
	public Customer() 
	{
		System.out.println("I got noticed");
		
	}
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	public int getCid() 
	{	
		return cid;
	}
	
	public void setCid(int cid) 
	{
		this.cid = cid;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
}
