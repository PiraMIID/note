package com.noteapp.exception.helper;


import org.assertj.core.api.BDDAssertions;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.boot.json.JsonParser;
import springfox.documentation.spring.web.json.Json;

import java.util.Arrays;
import java.util.LinkedList;


import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApiExceptionJsonMessageTest {

    ApiExceptionJsonMessage underTest;

    @BeforeEach
    void setUp() {
        underTest = new ApiExceptionJsonMessage();
    }

    @Test
    public void testConstructor() {
        assertEquals("", (new ApiExceptionJsonMessage()).massages);
    }


    @Test
    void itShouldDoNotThrowWhenStringIsOk() {
        // Given
        String s = "dawid{}{}{\"\"}asdfg";
        // When
        // Then
        assertThatCode(
                () -> {
                    underTest.check(s);
                }).doesNotThrowAnyException();

    }

    @Test
    void itShouldOneLevelJson() {
        // Given
        // When
        // Then


    }

    @Test
    void itShouldThrowWhenStringIsNotOk() {
        // Given
        String s = "{\"message\": \"We are send message on \" + signupRequest.getEmail() + \" with link. Please confirm to get access to you account. Thanks for join\"}\"";
        // When
        // Then
        String s1 = "Programmer fail. String is not ready to change to Json";
        assertThatThrownBy(() -> underTest.check(s)).hasMessage(s1).hasMessage(s1);
    }

    //    przekombinwoane to jset chyba
//    todo: fix or remove
    @Test
    <T extends Throwable>
    void itShouldThrowsSameAsJsonThrows() {
        // Given
        LinkedList<String> buildJsonChars = new LinkedList<>(Arrays.asList("{", "}", "\"", "\""));
//        LinkedList<String> allPossibleForLengthFour =new LinkedList<>(Arrays.asList(Arrays.stream(new String[4*4*4*4]).map(s -> "").toArray(String[]::new)));

//        while (allPossible.size() < 4*4*4*4) {
//            for (int i = 0; i < (allPossible.size()+1)*4; i++) {
//                System.out.println(buildJsonChars.get(i/4));
//                allPossible.set(i,allPossible.get(i) + buildJsonChars.get(i/4));
//
//            }
//        }
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(""));
        LinkedList<String> allPossibleForLengthFour = recurrenceCreateList(strings);
        // When
        int jsonException = 0;
        int checkMethodException = 0;
        System.out.println(allPossibleForLengthFour.size());

        for (int i = 0; i < allPossibleForLengthFour.size(); i++) {
            try {
//                System.out.println(allPossibleForLengthFour.get(i));
                underTest.check(allPossibleForLengthFour.get(i));
            } catch (IllegalArgumentException e) {
                checkMethodException += 1;
            }
            try {
                JSONParser.parseJSON(allPossibleForLengthFour.get(i));
            } catch (JSONException e) {
                jsonException += 1;
            }
        }
        System.out.println(jsonException);
        System.out.println(checkMethodException);
        Json json = new Json("{{{{\"}}");
        System.out.println(json);
//        BDDAssertions.then(jsonException).isEqualTo(checkMethodException);
    }

        // Then










    LinkedList<String> buildJsonChars = new LinkedList<>(Arrays.asList("{", "}", "\"", "\""));

    LinkedList<String> recurrenceCreateList(LinkedList<String> strings) {
        if (strings.size() > 4*4*4*4) return strings;
        LinkedList<String> stringsWithOneMoreChar = new LinkedList<String>();
        for (int i = 0; i < strings.size(); i++) {
            int finalI = i;
            buildJsonChars.spliterator().forEachRemaining(
                    s1 -> {
                        stringsWithOneMoreChar.add(strings.get(finalI)+s1);
                    }
            );
        }
        return recurrenceCreateList(stringsWithOneMoreChar);

    }
}

