package testdata;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();


    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.number().digits(10);
    public String birthDay = String.valueOf(faker.number().numberBetween(1, 28));
    public String birthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String birthYear = String.valueOf(faker.number().numberBetween(1900, 2024));
    public String subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry",
            "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies",
            "History", "Civics");

    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String picture = faker.options().option("1.jpg", "2.jpg", "3.jpg");
    public String address = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getCity(state);


    public String getCity(String state) {
        if (state.equals("NCR"))
            return faker.options().option("Delhi", "Gurgaon", "Haryana", "Noida");
        if (state.equals("Uttar Pradesh"))
            return faker.options().option("Agra", "Lucknow", "Merrut", "Rajasthan");
        if (state.equals("Haryana"))
            return faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan"))
            return faker.options().option("Jaipur", "Jaiselmer");
        return null;
    }

}
