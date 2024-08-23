package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Answer {

    @Id
    @Column(name = "ans_id")
    private int ans_id;

    private String answer;


    @OneToOne(mappedBy = "answer")
    private Question question;

    public int getAns_id() {
        return ans_id;
    }

    public String getAnswer() {
        return answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setAns_id(int ans_id) {
        this.ans_id = ans_id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "ans_id=" + ans_id +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}
