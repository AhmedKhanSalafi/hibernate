package org.example;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;


@Entity
public class Question {


    @Id
    @Column(name = "ques_id")
    private int ques_id;

    private String ques;


    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public void setQues_id(int ques_id) {
        this.ques_id = ques_id;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public int getQues_id() {
        return ques_id;
    }

    public String getQues() {
        return ques;
    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "ques_id=" + ques_id +
                ", ques='" + ques + '\'' +
                ", answer=" + answer +
                '}';
    }
}
