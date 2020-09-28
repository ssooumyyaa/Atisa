package com.example.atisa.notif;

public class mesaage {
    private String title;
    private String message;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public mesaage(String title, String message, String link) {
        this.title = title;
        this.message = message;
        this.link = link;
    }

    public mesaage()
    {}

}
