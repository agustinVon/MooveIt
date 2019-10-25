package Repository;

import Users.Data;
import Users.Operators;
import Users.PhoneNumber;
import Users.User;

import java.util.HashMap;

public class RepositoryUser implements OperatorsRepositry{

    private HashMap<PhoneNumber, User> users;

    public RepositoryUser() {
        users = new HashMap<>();
    }

    public void add(Data data) {
        users.put(data.getPhoneNumber(), new User(data));
    }

    @Override
    public Operators find(Data data) {
        for (User users : users.values()) {
            if (users.getPhoneNumber().equals(data.getPhoneNumber())) {
                return users;
            }
        }
        return null;
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
