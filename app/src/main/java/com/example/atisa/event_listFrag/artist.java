package com.example.atisa.event_listFrag;

public class artist {
    private String name;
    private String pic;
    private String rules;

    public artist(String name, String pic, String rules) {
        this.name = name;
        this.pic = pic;
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public artist( ) {

    }
}
