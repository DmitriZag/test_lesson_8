package data;

import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class RandomData {

    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    static Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = getGender();
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String birthDay = getDay();
    public String birthMonth = getMonth();
    public String birthYear = getYear();
    public String subjects = getSubjects();
    public String hobbies = getHobby();
    public String address = faker.address().fullAddress();
    public String city = getCity();
    public String state = getState(city);

    public static String getDay() {
        return String.valueOf(getRandomInt(1, 28));

    }

    public static String getMonth() {

        return faker.options().option("January",
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
                "December");
    }

    public static String getYear() {
        return String.valueOf(getRandomInt(1924, 2024));

    }

    String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    String getSubjects() {
        return faker.options().option("Math", "Arts", "English", "Biology", "Hindi");
    }

    String getHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    String getCity() {
        return faker.options().option("Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat", "Jaipur", "Jaise");
    }

    public String getState(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }
}