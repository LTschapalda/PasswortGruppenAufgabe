package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkPasswordLength_whenPasswordLongerThen8() {
        //GIVEN
        String PW = "J4va0000";
        //WHEN
        boolean actual = Main.checkPasswordLength(PW);
        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void checkPasswordIfContainsNumbers() {
        //GIVEN
        String PW = "J4va0000";
        //WHEN
        boolean actual = Main.checkPasswordNumber(PW);
        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected,actual);
    }


    @Test
    void checkPasswordIfContainsLowerCase() {
        //GIVEN
        String PW = "J4va0000";
        //WHEN
        boolean actual = Main.checkPasswordCaseLower(PW);
        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected,actual);
    }


    @Test
    void checkPasswordIfContainsUpperCase() {
        //GIVEN
        String PW = "J4va0000";
        //WHEN
        boolean actual = Main.checkPasswordCaseUpper(PW);
        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void checkPasswordIfContainsObviousKeywords() {
        //GIVEN
        String PW = "J4va0000";
        //WHEN
        boolean actual = Main.checkPasswordForObviousKeywords(PW);
        //THEN
        boolean expected = false;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void checkPasswordIfContainsSpecialCharacters() {
        //GIVEN
        String PW = "J4va0000";
        //WHEN
        boolean actual = Main.checkPasswordForSpecialCharacters(PW);
        //THEN
        boolean expected = false;
        Assertions.assertEquals(expected,actual);
    }
}