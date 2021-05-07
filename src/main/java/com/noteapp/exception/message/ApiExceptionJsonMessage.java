package com.noteapp.exception.message;


/*
* This class created cause RuntimeException take string of constructor
* */

import springfox.documentation.spring.web.json.Json;

public class ApiExceptionJsonMessage {

    String massages;

    public ApiExceptionJsonMessage() {
        this.massages = "";
    }

    public void add(String s1, String s2) {
        if (!this.massages.isEmpty()) this.massages += ",";
        this.massages += ",{\"" + s1 + "\": \"" + s2 + "\"}";

    }

    public String getMassages() {
        return this.massages;
    }

    public void setMassages(String massages) {
        this.massages = massages;
    }
    Json getJsonMassage() {
        return new Json(massages);
    }
}