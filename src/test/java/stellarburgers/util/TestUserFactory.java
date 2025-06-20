package stellarburgers.util;

import stellarburgers.TestUser;
import java.util.UUID;

public class TestUserFactory {
    public static TestUser createUniqueUser() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String name = "Тест" + uuid.substring(0, 5);
        String email = "user" + uuid.substring(0, 8) + "@test.ru";
        String password = "test" + uuid.substring(0, 3);
        return new TestUser(email, password, name);
    }
    public static TestUser createShortPasswordUser() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String name = "Тест" + uuid.substring(0, 5);
        String email = "user" + uuid.substring(0, 8) + "@test.ru";
        String password = "123";
        return new TestUser(email, password, name);
    }
}