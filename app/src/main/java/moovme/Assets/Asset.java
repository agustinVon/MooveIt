package moovme.Assets;

import com.spacetech.moovme.Assets.AssetType;

public class Asset {

    private final AssetType assetType;
    boolean assetIsOcupied;

    public Asset(AssetType assetType){
        this.assetType=assetType;
    }

    public void occupy(){
        assetIsOcupied=true;
    }

    public void returnAsset(){ assetIsOcupied=false; }

    public boolean isOcupied(){
        return assetIsOcupied;
    }

    public AssetType getAssetType() {
        return assetType;
    }
}
