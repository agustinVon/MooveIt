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

    public Administrator findAdmin(String name){
       for (Administrator administrators: admins.values()){
            if(administrators.getPhoneNumber().getPhoneNumber().equals(phoneNumber.getPhoneNumber())){
                return administrators;
            }
        }
        return null;

    public boolean testing(String name){
        return admins.containsKey(name);
    }
}
