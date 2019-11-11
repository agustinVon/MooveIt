package moovme.Users;

import com.spacetech.moovme.Users.Data;

import java.io.Serializable;

public abstract class Operators implements Serializable {

    //madre de user y administrator medio inutil, posiblemente la eliminemos

    public String getName(Data data){
        return data.getName();
    }
}
