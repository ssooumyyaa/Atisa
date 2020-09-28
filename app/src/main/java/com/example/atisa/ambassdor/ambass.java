package com.example.atisa.ambassdor;

public class ambass {

    private String batch;
    private String name;
    private String college;
    private String dept;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public ambass(String batch, String name, String college, String dept) {
        this.batch = batch;
        this.name = name;
        this.college = college;
        this.dept = dept;
    }

    public ambass( ) {

    }
}
