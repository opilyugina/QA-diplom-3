package stellarburgers.util;

import com.github.javafaker.Faker;
import stellarburgers.TestUser;

public class TestUserFactory {
    private static final Faker faker = new Faker();

    public static TestUser createUniqueUser() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(6, 10);
        return new TestUser(email, password, name);
    }

    public static TestUser createShortPasswordUser() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = "123";
        return new TestUser(email, password, name);
    }
}
