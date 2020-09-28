package com.example.atisa.coordinator;

import java.util.List;

public class coord {

    private  String name;
    private String branch;
    private String batch;
    private String pic;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public coord(String name, String branch, String batch, String pic, String email) {
        this.name = name;
        this.branch = branch;
        this.batch = batch;
        this.pic = pic;
        this.email = email;
    }

    public coord()
    {

    }
}
