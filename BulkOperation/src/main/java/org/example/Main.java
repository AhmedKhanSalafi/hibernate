package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

     //
        BulkInsert bulkInsert= new BulkInsert();


      //  BulkUpdate bulkUpdate= new BulkUpdate();

       // BulkDelete bulkDelete=new BulkDelete();




        // Bulk Insert
        List<MyEntity> entities = new ArrayList<>();
        // Add entities to the list
        for (int i = 0; i < 1000; i++) {
            entities.add(new MyEntity("samsung"+i,30000+i));
        }


        // Add entities to the list
       bulkInsert.bulkInsert(entities);

        // Bulk Update
//        bulkUpdate.bulkUpdateStatus("oldStatus", "newStatus");
//
//        // Bulk Delete
     //  bulkDelete.bulkDeleteByStatus("statusToDelete");



    }




}