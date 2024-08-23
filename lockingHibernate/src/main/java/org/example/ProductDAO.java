package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductDAO {


        private SessionFactory sessionFactory;

        public ProductDAO(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        public void updateProduct(Long productId, String newName, Double newPrice) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            try {
                Product product = session.get(Product.class, productId);
                product.setName(newName);
                product.setPrice(newPrice);
                session.update(product);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }


