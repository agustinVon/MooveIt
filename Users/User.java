package Users;

import Assets.*;
import Exeptions.UserIsAlreadyLockedExeption;
import Exeptions.UserIsNotInATripException;

import java.util.ArrayList;


public class User extends Operators{


    private final Data data;
    private boolean isLocked=false;
    int points;

    Travel actualTravel=null;
    Asset assetUsed=null; //crear clase de viaje o sesion

    public User(Data data) {
        this.data =data;
    }

    public void userLocking(boolean lockUser) throws UserIsAlreadyLockedExeption {
            isLocked=lockUser;
    }

    public PhoneNumber getPhoneNumber(){
        return data.getPhoneNumber();
    }

    public String getName() {
        return data.getName();
    }

    public boolean getLock(){ //for testing
        return isLocked;
    }

    public void rentAsset(AssetParking assetParking, AssetType assetType,long ExpectedTime){
        Travel travel=new Travel(assetParking.rentAsset(assetType),new Timer(ExpectedTime));
    }

    public double returnAsset(AssetParking assetParking)throws UserIsNotInATripException {
        if(actualTravel!=null){
            //boolean returnredAtRightTime=tripTimer.compareTime(ExpectedTime);
            double totalFee = assetParking.returnAsset(actualTravel,points);
            //assetParking.ganarPuntos(actualTravel,)
            //TODO add points when asset is returned
            actualTravel=null;
            return  totalFee;
        }
        else{
            throw new UserIsNotInATripException();
        }
    }

}

