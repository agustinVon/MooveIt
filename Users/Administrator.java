package Users;


import Assets.AssetBatch;
import Assets.AssetType;
import Assets.Zone;
import Exeptions.UserIsAlreadyLockedExeption;
import Exeptions.ZoneAlreadyExistsException;
import Exeptions.ZoneDoesNotExistException;
import Repository.ListAssetBachCodes;
import Repository.RepositoryAdmins;
import Repository.RepositoryUser;
import Repository.RepositoryZone;

public class Administrator extends Operator{

    private final Data data;

    public Administrator(Data data) {
        this.data=data;
    }

    public String getName() {
        return data.getName();
    }



    public void setUserLock(RepositoryUser userRepo, PhoneNumber aPhoneNumber, boolean lockUser){
        User userToBlock = userRepo.findUser(aPhoneNumber);
        try{
            userToBlock.userLocking(lockUser);
        } catch (UserIsAlreadyLockedExeption userIsAlreadyLockedExeption) {
            if(userToBlock.getLock()==lockUser){
                userIsAlreadyLockedExeption.printStackTrace();
                //inform via pop up that user was already in that state and do nothing
            }

        }
    }

    public void registerAdmin(RepositoryAdmins repositoryAdmins,String name){
        repositoryAdmins.addAdmin(name);
    }

    public void buyBatch(AssetType assetType, int cuantity, Zone zone, ListAssetBachCodes listBachCodes, int precioDeAlquilerDelLote){
        AssetBatch assetBatch =new AssetBatch(assetType,cuantity,listBachCodes.createNewCode(),precioDeAlquilerDelLote);
        zone.addNewBach(assetBatch);
    }

    public void createNewZone(RepositoryZone repositoryZone, int zonepoints, String name) throws ZoneAlreadyExistsException {
        repositoryZone.add(zonepoints,name);
    }

    public void deleteZone(RepositoryZone repositoryZone,String name) throws ZoneDoesNotExistException {
        repositoryZone.delete(name);
    }
}
