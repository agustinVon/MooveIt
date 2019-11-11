package moovme.Exceptions;

public class UserIsNotRegisteredException extends Exception {

    public UserIsNotRegisteredException(){
        super("User is not registered");
    }
}
