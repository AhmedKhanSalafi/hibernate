package org.example;

import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BulkInsert {

    public void bulkInsert(List<MyEntity> entities) {

        Configuration cfg = new Configuration();
        // It read both cfg file and mapping files
        cfg.configure();

        //  buildSessionFactory() method gathers the meta-data which is in the cfg Object.
        // From cfg object it takes the JDBC information and create a JDBC Connection.
        SessionFactory factory=cfg.buildSessionFactory();


        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        int batchSize = 50;
        for (int i = 0; i < entities.size(); i++) {
            session.save(entities.get(i));
            if (i % batchSize == 0 && i > 0) {
                session.flush();
                session.clear();
            }
        }

        transaction.commit();
        session.close();
    }
}
