import Repository.RepositoryAdmins;
import Repository.RepositoryUser;
import Users.PhoneNumber;

public class Mooveme {

    private static RepositoryUser repositoryUser;
    private static RepositoryAdmins repositoryAdmins;
    private static Operator activeuser;

    public Mooveme(RepositoryUser repositoryUser, RepositoryAdmins repositoryAdmins){
        Mooveme.repositoryUser = repositoryUser;
        Mooveme.repositoryAdmins=repositoryAdmins;
    }

    public static void register(String name, PhoneNumber phoneNumber){
        repositoryUser.addUser(name,phoneNumber);
    }

/*
    public static void login(PhoneNumber phoneNumber) {

        if(repositoryUser.testing(phoneNumber)){
            activeuser=repositoryUser.findUser(phoneNumber);
        }
        //usuario no registrado
    }

    public static void loginAdmin(String name){
        if(repositoryAdmins.testing(name)){
            activeuser=repositoryAdmins.findAdmin(name);
        }
        //admin no registrado
    }

 */
}
