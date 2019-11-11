package moovme.Exceptions;

public class UserCantStartNewTrip extends Exception {

    public UserCantStartNewTrip() {
        super("userIsAlreadyOnATrip");
    }
}
