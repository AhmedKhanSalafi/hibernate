package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how



                // Create SessionFactory
                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

                // Initialize DAOs
                ProductDAO productDAO = new ProductDAO(sessionFactory);
                CustomerDAO customerDAO = new CustomerDAO(sessionFactory);

                // Create and update a product (Optimistic Locking)
                Product product = new Product();
                product.setName("Sample Product");
                product.setPrice(100.0);

                try (Session session = sessionFactory.openSession()) {
                    Transaction tx = session.beginTransaction();
                    session.save(product);
                    tx.commit();
                }

                System.out.println("Updating Product with Optimistic Locking");
                productDAO.updateProduct(product.getId(), "Updated Product", 120.0);

                // Create and update a customer (Pessimistic Locking)
                Customer customer = new Customer();
                customer.setName("Sample Customer");
                customer.setEmail("customer@example.com");

                try (Session session = sessionFactory.openSession()) {
                    Transaction tx = session.beginTransaction();
                    session.save(customer);
                    tx.commit();
                }

                System.out.println("Updating Customer with Pessimistic Locking");
                customerDAO.updateCustomer(customer.getId(), "Updated Customer", "updated@example.com");

                // Close SessionFactory
                sessionFactory.close();
            }
        }



//Student s1= new Student();
//s1.setEid(1);
//s1.setEname("ahmed");
//s1.setSalary(1000);
//
//        Student s2= new Student();
//        s2.setEid(2);
//        s2.setEname("sudha");
//        s2.setSalary(2000);
//
//        Student s3= new Student();
//        s3.setEid(3);
//        s3.setEname("kumar");
//        s3.setSalary(3000);
//
//        List<Student> user=new ArrayList<>();
//        user.add(s1);
//        user.add(s2);
//        user.add(s3);




//
//        Session session=  factory.openSession();
//
//     session.beginTransaction();
//
//        String query="from Student where city=hyderabad";
//        Query query1=   session.createQuery(query);
//
//        List<Student> studentList=query1.list();
//for (Student s : studentList ){
//
//    System.out.println(s.getEname());
//}
//
//
//
////        Query query = session.createQuery("FROM Student");
////        query.setCacheable(true);
////        List users = query.list();
//
//
//
////       Query <Student> query = session.createQuery("From Student e where e.eid=:1",Student.class);
////
////List<Student> list= query.list();
//
//
//
//
//      //  session.getTransaction().commit();
//
//        //  Question newQ = session.get(Question.class,123);
//
//
//        session.close();
//        factory.close();







