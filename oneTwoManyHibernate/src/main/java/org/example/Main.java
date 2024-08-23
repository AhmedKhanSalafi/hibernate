package org.example;

import org.hibernate.Session;
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
        System.out.printf("Hello and welcome!");

        // It activates Hibernate Framework
        Configuration cfg = new Configuration();
        // It read both cfg file and mapping files
        cfg.configure();

        //  buildSessionFactory() method gathers the meta-data which is in the cfg Object.
        // From cfg object it takes the JDBC information and create a JDBC Connection.
        SessionFactory factory=cfg.buildSessionFactory();


        Question question1= new Question();
        question1.setQues_id(123);
        question1.setQues("what is java");

        Answer answer1= new Answer();
        answer1.setAns_id(321);
        answer1.setAnswer("java is simple language");
        answer1.setQuestion(question1);

        Answer answer2= new Answer();
        answer2.setAns_id(876);
        answer2.setAnswer("java is programming language");
        answer2.setQuestion(question1);

        Answer answer3= new Answer();
        answer3.setAns_id(658);
        answer3.setAnswer("java is oops language");
        answer3.setQuestion(question1);

        List answerlist= new ArrayList<>();
        answerlist.add(answer1);
        answerlist.add(answer2);
        answerlist.add(answer3);

        question1.setAnswer(answerlist);





        Session session=  factory.openSession();


        session.beginTransaction();


        session.save(question1);
        session.save(answer1);
        session.save(answer2);
        session.save(answer3);



        session.getTransaction().commit();

      //  Question newQ = session.get(Question.class,123);


        session.close();
        factory.close();


    }
}