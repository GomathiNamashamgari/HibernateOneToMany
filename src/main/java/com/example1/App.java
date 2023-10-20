package com.example1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example1.models.Department;
import com.example1.models.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Configuration cfg=new Configuration();
         cfg.configure("hibernate.cfg.xml");
         SessionFactory factory=cfg.buildSessionFactory();
         Session session=factory.openSession();
         try 
         {
        	Department d1=new Department();
        	d1.setName("IT");
        	
         	Employee e1=new Employee();
         	e1.setName("Raju");
         	e1.setDepartment(d1);
         	
         	Employee e2=new Employee();
         	e2.setName("Peter");
         	e2.setDepartment(d1);
         	
         	session.beginTransaction();
         	session.save(d1);
         	session.save(e1);
         	session.save(e2);
         	session.getTransaction().commit();
    
         }
         catch(Exception e)
         {
         	e.printStackTrace();
         }
         finally 
         {
         	session.close();
         	factory.close();
         }
        
     }
  }
