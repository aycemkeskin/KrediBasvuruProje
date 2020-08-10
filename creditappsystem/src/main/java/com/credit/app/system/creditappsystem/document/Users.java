package com.credit.app.system.creditappsystem.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
    @Id
    private long  id;
    private String name;
    private String surname;
    private Integer salary;
    private String phonenum;
    private Integer credit_score;
    private Integer limit;

    public Users(long id, String name, String surname, Integer salary, String phonenum, Integer credit_score,Integer limit) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.phonenum = phonenum;
        this.credit_score = credit_score;
        this.limit=limit;
    }

    public Users() {
    	
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
