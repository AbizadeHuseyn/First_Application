package com.example.firstapplication;

public class Notes {

    private String header;
    private String context;
    private String date;

    public Notes(String header, String context, String date) {
        this.header = header;
        this.context = context;
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public String getContext() {
        return context;
    }

    public String getDate() {
        return date;
    }
}
