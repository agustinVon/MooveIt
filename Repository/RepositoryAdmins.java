package Repository;

import Users.Administrator;

import java.util.HashMap;

public class RepositoryAdmins {

    private HashMap<String, Administrator> admins;

    RepositoryAdmins(){
        admins=new HashMap<>();
    }

    public void addAdmin(String name){
        admins.put(name,new Administrator(name));
    }

    public Administrator findAdmin(String name) {
        for (Administrator administrators : admins.values()) {
            if (administrators.getName().equals(name)) {
                return administrators;
            }
        }
        return null;

    }
}
