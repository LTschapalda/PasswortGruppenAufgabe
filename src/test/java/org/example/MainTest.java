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
    void checkPasswordLength_whenPasswordShorterThen8() {
        //GIVEN
        String PW = "J4va";
        //WHEN
        boolean actual = Main.checkPasswordLength(PW);
        //THEN
        boolean expected = false;
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
    void checkPasswordIfContainsNoNumbers() {
        //GIVEN
        String PW = "JavaBootcamp";
        //WHEN
        boolean actual = Main.checkPasswordNumber(PW);
        //THEN
        boolean expected = false;
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
    void checkPasswordIfContainsNoLowerCase() {
        //GIVEN
        String PW = "JAVA0000";
        //WHEN
        boolean actual = Main.checkPasswordCaseLower(PW);
        //THEN
        boolean expected = false;
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
    void checkPasswordIfContainsNoUpperCase() {
        //GIVEN
        String PW = "java0000";
        //WHEN
        boolean actual = Main.checkPasswordCaseUpper(PW);
        //THEN
        boolean expected = false;
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
    void checkPasswordIfUsesObviousKeywords() {
        //GIVEN
        String PW = "passwort";
        //WHEN
        boolean actual = Main.checkPasswordForObviousKeywords(PW);
        //THEN
        boolean expected = true;
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
    @Test
    void checkPasswordIfUsesSpecialCharacters() {
        //GIVEN
        String PW = "J4va000#";
        //WHEN
        boolean actual = Main.checkPasswordForSpecialCharacters(PW);
        //THEN
        boolean expected = true;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void validateGoodPassword(){
        //GIVEN
        String PW = "J4va000#";
        //WHEN
        String actual = Main.validateGoodPW(PW);
        //THEN
        String expected = "Gutes Passwort";
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void detectbadPassword(){
        //GIVEN
        String PW = "123456";
        //WHEN
        String actual = Main.validateGoodPW(PW);
        //THEN
        String expected = "Versuchs noch einmal.";
        Assertions.assertEquals(expected,actual);
    }
}