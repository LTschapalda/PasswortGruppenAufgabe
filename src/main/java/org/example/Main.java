package org.example;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("\nPasswort Vorschlag: "+generateSecurePassword());

        String password;
        String validationMessage;
        do {
            password = enterPassword();
            validationMessage = validateGoodPW(password);
            System.out.println(validationMessage);
        } while (!validationMessage.equals("Gutes Passwort"));
    }

    public static String enterPassword(){
        Scanner enterPW = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String pw = enterPW.nextLine();

        return pw;
    }
    // Passwortlänge checken
    public static boolean checkPasswordLength(String PW) {
        if(PW.length()>=8) {
            return true;
        }
        System.out.println("Passwort muss mindestens 8 Zeichen haben.");
        return false;
    }

    // enthält das Passwort Zahlen?
    public static boolean checkPasswordNumber(String PW) {
        for (char c : PW.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        System.out.println("Dein Passwort muss eine Zahl enthalten.");
        return false;
    }

    // (Bonus) enthält das Passwort kleine/große Buchstaben

    // enthält das Passwort kleine Buchstaben
    public static boolean checkPasswordCaseLower(String PW) {
        for (char c : PW.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        System.out.println("Dein Passwort muss mindestens einen kleinen Buchstaben enthalten.");
        return false;
    }
    // enthält das Passwort große Buchstaben
    public static boolean checkPasswordCaseUpper(String PW) {
        for (char c : PW.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        System.out.println("Dein Passwort muss mindestens einen großen Buchstaben enthalten.");
        return false;
    }


    // enthält das Passwort "passwort", "123456"
    public static boolean checkPasswordForObviousKeywords(String PW) {
        String[] commonWords = {"passwort", "123456"};

        for (String commonWord : commonWords) {
            if (PW.toLowerCase().contains(commonWord)) {
                System.out.println("Dein Passwort ist zu einfach zu erraten.");
                return true;
            }
        }

        return false;
    }

    public static boolean checkPasswordForSpecialCharacters(String PW) {
        Pattern pattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]");
        Matcher matcher = pattern.matcher(PW);
        return matcher.find();
    }

    public static String validateGoodPW(String PW){
        if (checkPasswordLength(PW) &&
                checkPasswordNumber(PW) &&
                checkPasswordCaseLower(PW) &&
                checkPasswordCaseUpper(PW) &&
                !checkPasswordForObviousKeywords(PW)) {
            return "Gutes Passwort";
        }else {
            return "Versuchs noch einmal.";
        }
    }
    public static String generateSecurePassword(){
        char[] lowerCase = "qwertzuiopasdfghjklyxcvbnm".toCharArray();
        char[] upperCase = "QWERTZUIOPASDFGHJKLYCVBNM".toCharArray();
        char[] digit = "0123456789".toCharArray();
        char[] symbols = "!$#*&?".toCharArray();

        int length = 10;

        Random random = new SecureRandom();
        StringBuilder generatedPW = new StringBuilder();
        for(int i = 0; i < length; i++){
            generatedPW.append(lowerCase[random.nextInt(lowerCase.length)]);
        }

        generatedPW.insert(random.nextInt(generatedPW.length()), lowerCase[random.nextInt(lowerCase.length)]);
        generatedPW.insert(random.nextInt(generatedPW.length()), upperCase[random.nextInt(upperCase.length)]);
        generatedPW.insert(random.nextInt(generatedPW.length()), digit[random.nextInt(digit.length)]);
        generatedPW.insert(random.nextInt(generatedPW.length()), symbols[random.nextInt(symbols.length)]);

        return generatedPW.toString();
    }
}