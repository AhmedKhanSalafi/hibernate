package org.example;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDAO {



        private SessionFactory sessionFactory;

        public CustomerDAO(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }



    public void updateCustomer(Long customerId, String newName, String newEmail) {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            try {
                Customer customer = session.get(Customer.class, customerId, LockMode.PESSIMISTIC_WRITE);
                customer.setName(newName);
                customer.setEmail(newEmail);
                session.update(customer);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }


