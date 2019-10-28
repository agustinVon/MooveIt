package com.spacetech.moovme.Repository;

import com.spacetech.moovme.clases.AssetType;

import java.util.ArrayList;

public class RepositoryAsset {
    ArrayList<AssetType> assetTypes;

    public RepositoryAsset(){
        this.assetTypes = new ArrayList<>();
    }

    public void addAssetType(AssetType assetType){
        assetTypes.add(assetType);
    }

    public ArrayList getAssetTypeArrayList(){
        return assetTypes;
    }
}
