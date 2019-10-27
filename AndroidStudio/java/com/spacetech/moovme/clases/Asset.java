package com.spacetech.moovme.clases;

public class Asset {

    private final AssetType assetType;
    private final double price;
    boolean assetIsOcupied;

    public Asset(AssetType assetType, int precioDeAlquilerDelLote){
        this.assetType=assetType;
        this.price=precioDeAlquilerDelLote;
        assetIsOcupied=false;
    }

    public void occupy(){
        assetIsOcupied=true;
    }

    public double getPrice() {
        return price;
    }

    public AssetType getAssetType() {
        return assetType;
    }
}