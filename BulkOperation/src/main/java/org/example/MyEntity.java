package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MyEntity {


    @Id
    private int eid;
    private String ename;

    private int rate;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", rate=" + rate +
                '}';
    }

    public MyEntity(String ename, int rate) {
        this.ename = ename;
        this.rate = rate;
    }
}