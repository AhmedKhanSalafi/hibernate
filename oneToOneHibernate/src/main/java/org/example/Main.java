package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // It activates Hibernate Framework
        Configuration cfg = new Configuration();
        // It read both cfg file and mapping files
        cfg.configure();

        //  buildSessionFactory() method gathers the meta-data which is in the cfg Object.
        // From cfg object it takes the JDBC information and create a JDBC Connection.
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println(factory);

        Question question1= new Question();
        question1.setQues_id(123);
        question1.setQues("what is java");

        Answer answer1= new Answer();
        answer1.setAns_id(321);
        answer1.setAnswer("java is programming language");

        question1.setAnswer(answer1);
        answer1.setQuestion(question1);



        Session session=  factory.openSession();

        session.beginTransaction();
        session.save(question1);
        session.save(answer1);



        session.getTransaction().commit();

        Question newQ = session.get(Question.class,123);


        session.close();
        factory.close();


    }
}