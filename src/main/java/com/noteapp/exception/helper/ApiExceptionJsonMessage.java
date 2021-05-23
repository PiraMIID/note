package com.noteapp.exception.helper;
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

    //todo: after you will end projeck thing that maybe better to remove it
//    I think this method is not necessary but is useful so that why i leave it
    /**
     * method check string parts of json like " and {
     * if { is open is must to have close as }
     * with " is the same
     *
     * method also check order e.g. "{"} throw error
     *
     * this algorithm is not fully valid!! but check the most popular fail implementations
     *
     * @param s this string will cast to json
     * @throw if string s can not be change to Json type
     */
    void check(String s) {  //see tests
        Stack<String> stack = new Stack<>();

        s.chars().forEach(
                value -> {
                    if (Character.toString(value).equals("{")) stack.push(Character.toString(value));
                    else if (Character.toString(value).equals("}") && stack.lastElement().equals("{")) stack.pop();

                    if (Character.toString(value).equals("\"") && !stack.isEmpty() && stack.lastElement().equals("\"")) {
                        stack.pop();
                    }
                    else if (Character.toString(value).equals("\"")) stack.push(Character.toString(value));
                }
        );

        if(!stack.isEmpty()) {
            throw new IllegalArgumentException("Programmer fail. String is not ready to change to Json");
        }
    }
    /*
    * 1. simple {"asd":"asdasd"}
    * 2. complate {"asd":{"asd":"sdhrrtg"}}
    * 3. in action {"asd"":true}
    * */


    /*
    * all true
    * 1. "asfas"
    * 2. "asd":{.sdg.sdg.}
    * */
}
