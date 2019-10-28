package com.spacetech.moovme.clases;

public class AssetType {

    private final int point;
    private final String name;

    public AssetType(int pointsPerMinute, String name){
        this.point=pointsPerMinute;
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public int getPoint() {
        return point;
    }
}
