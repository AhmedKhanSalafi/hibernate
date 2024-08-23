package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        {
            System.out.println( "Project created!" );

            // It activates Hibernate Framework
            Configuration cfg = new Configuration();
            // It read both cfg file and mapping files
            cfg.configure();

            //  buildSessionFactory() method gathers the meta-data which is in the cfg Object.
            // From cfg object it takes the JDBC information and create a JDBC Connection.
            SessionFactory factory=cfg.buildSessionFactory();

//creating object
            Student student1= new Student();
            student1.setId(101);
            student1.setName("AHMED");
            student1.setCity("Hyderabad");

            System.out.println(student1);

            Student student2= new Student();
            student1.setId(102);
           student1.setName("Virat");
            student1.setCity("Banglore");
            System.out.println(student2);


           //Session session = factory.getCurrentSession();

            Session session=  factory.openSession();

           session.beginTransaction();
           session.save(student1);


           session.getTransaction().commit();

           session.close();

        }
    }
}