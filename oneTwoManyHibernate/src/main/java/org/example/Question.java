package org.example;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @Column(name = "ques_id")
    private int ques_id;

    private String ques;


    @OneToMany(mappedBy = "question")
    private List<Answer> answer;

    public void setQues_id(int ques_id) {
        this.ques_id = ques_id;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public int getQues_id() {
        return ques_id;
    }

    public String getQues() {
        return ques;
    }

    public List <Answer> getAnswer() {
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
