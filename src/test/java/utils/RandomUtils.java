package utils;

import java.util.Random;
// все, в том числе идею этого класса, скопировала у однокурсника
public class RandomUtils {

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomGender() {
        String[] gender = {"Female", "Male", "Other"};
        int genderIndex = getRandomNumber(0, 2);
        return gender[genderIndex];
    }

    //взято отсюда https://www.baeldung.com/java-generating-random-numbers-in-range
    //метод формирует рандомное число из диапазона
    public static int getRandomNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomMonth() {
        String[] listOfMonth = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };
        int MonthIndex = getRandomNumber(0, 11);
        return listOfMonth[MonthIndex];
    }
    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int hobbyIndex = getRandomNumber(0, 2);
        return hobbies[hobbyIndex];
    }
    public static String getRandomDay() {
        int day = getRandomNumber(10, 28);
        return String.valueOf(day);
    }

    public static String getRandomYear() {
        int day = getRandomNumber(1980, 2010);
        return String.valueOf(day);
    }


}