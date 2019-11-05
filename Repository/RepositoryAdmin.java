package com.spacetech.moovme.Repository;

import com.spacetech.moovme.clases.Administrator;
import com.spacetech.moovme.clases.PhoneNumber;
import com.spacetech.moovme.clases.User;

import java.util.HashMap;

public class RepositoryAdmin {

    private HashMap<String, Administrator>  admins ;

    public RepositoryAdmin(){
        admins = new HashMap<>();
    }

    public void addAdmin(String name){
        admins.put(name,new Administrator(name));
    }

    public HashMap<String, Administrator> getAdmins(){
        return admins;
    }


    public Administrator findAdmin(String name){
        for (Administrator adminis: admins.values()) {
            if(adminis.getName().equals(name)){
                return adminis;
            }

        }return null;

    }

    public void setAdmin(HashMap hashMap) {
        this.admins = hashMap;
    }
}
