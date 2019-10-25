package Repository;

import Users.PhoneNumber;
import Users.User;

import java.util.HashMap;

public class RepositoryUser {

    private HashMap<PhoneNumber, User> users;

    public RepositoryUser() {
        users = new HashMap<>();
    }

    public void addUser(String name, PhoneNumber phoneNumber) {
        users.put(phoneNumber, new User(phoneNumber, name));
    }

    public User findUser(PhoneNumber phoneNumber) {
        for (User users : users.values()) {
            if (users.getPhoneNumber().equals(phoneNumber)) {
                return users;
            }
        }
        return null;


    }
}
