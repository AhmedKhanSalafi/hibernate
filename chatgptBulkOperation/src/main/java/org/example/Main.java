package org.example;

import com.mysql.cj.x.protobuf.MysqlxConnection;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.



        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Initialize ProductDAO
        ProductDAO productDAO = new ProductDAO(sessionFactory);

        // Create a list of products to insert
        List<Item> products = new ArrayList<>();
        for (int i = 1; i <=1000; i++) {if (i%10==0){
            products.add(new Item("Apple " + i, 70000.0));
        }}

        // Perform bulk insert
        productDAO.bulkInsertProducts(products);

        sessionFactory.close();
    }}

//        // Create SessionFactory
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//
//        // Initialize ProductDAO
//        ProductDAO productDAO = new ProductDAO(sessionFactory);
//
//        // Perform bulk delete
//        System.out.println("Deleting products with price greater than 500.0");
//        productDAO.bulkDeleteProducts(500.0);
//
//        // Close SessionFactory
//        sessionFactory.close();
//    }
//            }




