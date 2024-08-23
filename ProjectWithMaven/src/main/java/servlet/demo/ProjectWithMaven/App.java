package servlet.demo.ProjectWithMaven;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.Configurable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project created!" );
        
       // It activate Hibernate Framework
        Configuration cfg = new  Configuration();
       // It read both cfg file and mapping files
        cfg.configure();
        
      //  buildSessionFactory() method gathers the meta-data which is in the cfg Object. 
       // From cfg object it takes the JDBC information and create a JDBC Connection.
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println(factory);
    }
}
