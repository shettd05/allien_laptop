package com.telusko.alien_laptop;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
    	SessionFactory snFactory = conf.buildSessionFactory(sr);
        Session sn = snFactory.openSession();
        
        Alien a  = new Alien();
        Laptop l = new Laptop();
        
        Transaction tr = sn.beginTransaction();
        
        a = (Alien) sn.get(Alien.class, 1);
       System.out.println(a);
      //  System.out.println(sn);
        sn.getTransaction().commit();
        sn.close();
       // System.out.println("1st closure");
        
        
        Session sn2 = snFactory.openSession();
        tr = sn2.beginTransaction();
        
        a = (Alien) sn2.get(Alien.class, 1);
        System.out.println(a);
        sn2.getTransaction().commit();
        sn2.close();
        
    }
}
