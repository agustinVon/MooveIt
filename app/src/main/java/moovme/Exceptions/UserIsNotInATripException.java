package moovme.Exceptions;

public class UserIsNotInATripException extends Exception {
    public UserIsNotInATripException(){
        super("El usuarion no esta enm ningun viaje");
    }
}
