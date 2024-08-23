package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BulkUpdate {

    public void bulkUpdateStatus(String oldStatus, String newStatus) {

        Configuration cfg = new Configuration();
        // It read both cfg file and mapping files
        cfg.configure();

        //  buildSessionFactory() method gathers the meta-data which is in the cfg Object.
        // From cfg object it takes the JDBC information and create a JDBC Connection.
        SessionFactory factory=cfg.buildSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE MyEntity SET status = :newStatus WHERE status = :oldStatus";
        Query query = session.createQuery(hql);
        query.setParameter("newStatus", newStatus);
        query.setParameter("oldStatus", oldStatus);

        int rowsAffected = query.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

        transaction.commit();
        session.close();
    }
}
