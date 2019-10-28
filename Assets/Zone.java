package com.spacetech.moovme.clases;

import com.spacetech.moovme.Repository.RepositoryDiscount;

import java.util.ArrayList;

public class Zone {
    private final String name;
    private final ArrayList<AssetBatch> assetList=new ArrayList<AssetBatch>();
    private final ArrayList<Asset> totalAssets=new ArrayList<>();
    private final Tarifario tarifario=new Tarifario();
    private RepositoryDiscount repositoryDiscount=new RepositoryDiscount();

    public Zone(String name){
        this.name=name;
    }

    public void addNewBach(AssetBatch assetBatch) {
        assetList.add(assetBatch);
        for (Asset asset: assetBatch.getAssetList()) {
            totalAssets.add(asset);
        }
    }
    public String getName(){
        return name;
    }

    public Asset getAssetwithDesignatedType(AssetType assetType) throws AssetTypeDoesNotExistInSpecifiedZone {
        for(AssetBatch batch : assetList){
            if(batch.getType() == assetType){
                for(Asset asset: batch.getAssetList()){
                    if(!asset.assetIsOcupied){
                        return asset;
                    }
                }
            }
        }
        throw new AssetTypeDoesNotExistInSpecifiedZone();
    }

    public double calculateFee(Asset assetUsed, int points) {
        return tarifario.calculatePrice(assetUsed,repositoryDiscount.find(assetUsed.getAssetType()),points);
    }

    public void addDiscount(Discount discount){
        repositoryDiscount.add(discount);
    }

    public ArrayList<Discount> showDiscounts(){
        return repositoryDiscount.showDiscounts();
    }

    public ArrayList<Asset> getTotalAssets() {
        return totalAssets;
    }
}
