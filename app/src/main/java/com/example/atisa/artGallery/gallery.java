package com.example.atisa.artGallery;

public class gallery {

    private  String pic;
    private  String name;
    private String clg;

    public String getClg() {
        return clg;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }

    public gallery(String pic, String name, String clg) {
        this.pic = pic;
        this.name = name;
        this.clg=clg;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public gallery( ) {

    }
}
