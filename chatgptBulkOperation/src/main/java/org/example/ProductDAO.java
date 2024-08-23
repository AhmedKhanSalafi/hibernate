package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {

    private SessionFactory sessionFactory;

    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void bulkInsertProducts(List<Item> products) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            int batchSize = 50; // Adjust this size based on your configuration
            for (int i = 0; i < products.size(); i++) {
                session.save(products.get(i));
                if (i % batchSize == 0 && i > 0) {
                    session.flush();
                    session.clear();
                }
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }}

//    public void bulkDeleteProducts(Double priceLimit) {
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            // HQL for bulk delete
//            String hql = "DELETE FROM Product WHERE price > :priceLimit";
//            Query query = session.createQuery(hql);
//            query.setParameter("priceLimit", priceLimit);
//            int result = query.executeUpdate();
//            System.out.println(result + " products deleted.");
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//}

