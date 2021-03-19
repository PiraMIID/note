package com.noteapp.exception.helper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import springfox.documentation.spring.web.json.Json;
import java.util.Stack;


/**
 * This class created cause RuntimeException take string of constructor
 */
public class ApiExceptionJsonMessage {

    /**
     * @param messages this Json in String form
     */
    String massages;

    public ApiExceptionJsonMessage() {
        this.massages = "";
    }

    public ApiExceptionJsonMessage(String s1, String s2) {
        check(s1);
        check(s2);
        this.massages = "{\"" + s1 + "\": \"" + s2 + "\"}";
    }

    public void add(String s1, String s2) {
        check(s1);
        check(s2);
        if (!this.massages.isEmpty()) this.massages += ",";
        this.massages += "{\"" + s1 + "\": \"" + s2 + "\"}";

    }

    public String getMassages() {
        return this.massages;
    }

    public void setMassages(String massages) {
        check(massages);
        this.massages = massages;
    }

    public Json getJsonMassage() {
        return new Json(massages);
    }

    void check(String message) {
        StringBuilder stringBuilder = new StringBuilder(message);
        ArrayList<String> strings = new ArrayList<>();
        strings.addAll(List.of("{","}","\"",":"));
        strings.forEach(
            s -> {
                if(stringBuilder.indexOf(s)!=-1) throw new RuntimeException("Programmer put wrong format as Exception message");
            }
        );
    }
}
