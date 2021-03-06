package moovme.Assets;

import com.spacetech.moovme.Assets.Asset;
import com.spacetech.moovme.Assets.AssetType;
import com.spacetech.moovme.Assets.Fee;
import com.spacetech.moovme.Assets.Travel;
import com.spacetech.moovme.Assets.Zone;
import com.spacetech.moovme.Exceptions.AssetTypeDoesNotExistInSpecifiedZoneException;
import com.spacetech.moovme.Exceptions.CantApplyDiscountException;
import com.spacetech.moovme.Users.User;


public class AssetParking {

    private Zone zone;
    private  String name;

    public AssetParking(String name, Zone zone){
        this.zone = zone;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Asset rentAsset(AssetType assetType) throws AssetTypeDoesNotExistInSpecifiedZoneException {
        return zone.getAssetwithDesignatedType(assetType);
    }

    public Fee returnAsset(Travel travel, User user) {
        return zone.returnAsset(travel,user);
    }

    public Fee returnAssetTimeTest(Travel travel, User user, int time) {
        return zone.returnAssetTimeTest(travel,user,time);
    }

    public Zone getZone() {
        return zone;
    }

    public boolean canApplyDiscount(Travel actualTravel, User user) {
        return zone.canApplyDiscount(actualTravel,user);
    }

    public Fee applyDiscount(Travel actualTravel, User user, Fee fee) throws CantApplyDiscountException {
        return zone.applyDiscount(actualTravel,user,fee);
    }
}
