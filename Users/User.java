package Users;

import Assets.*;
import Exeptions.UserIsAlreadyLockedExeption;
import Exeptions.UserIsNotInATripException;

import java.util.ArrayList;


public class User extends Operator{


    private final PhoneNumber phoneNumber;
    private final String name;
    private boolean isLocked=false;
    int points;

    Timer tripTimer;
    private Integer ExpectedTime;
    Asset assetUsed=null;

    public User(PhoneNumber aPhoneNumber, String name) {
        this.phoneNumber=aPhoneNumber;
        this.name=name;
    }

    public void userLocking(boolean lockUser) throws UserIsAlreadyLockedExeption {
            isLocked=lockUser;
    }

    public PhoneNumber getPhoneNumber(){
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public boolean getLock(){ //for testing
        return isLocked;
    }

    public void rentAsset(AssetParking assetParking, AssetType assetType,Integer ExpectedTime){
        assetUsed=assetParking.rentAsset(assetType);
        tripTimer=new Timer();
        this.ExpectedTime=ExpectedTime;
    }

    public double returnAsset(AssetParking assetParking)throws UserIsNotInATripException {
        if(assetUsed!=null){
            //boolean returnredAtRightTime=tripTimer.compareTime(ExpectedTime);
            double totalFee = assetParking.returnAsset(assetUsed,points);
            //TODO add points when asset is returned
            assetUsed=null;
            return  totalFee;
        }
        else{
            throw new UserIsNotInATripException();
        }
    }

}

