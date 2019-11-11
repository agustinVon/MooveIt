package moovme.Exceptions;

public class UserDoesntHavaScoreException extends Throwable {
    public UserDoesntHavaScoreException(){
        super("El usuario no gano ningun punto previamente");
    }
}
