package com.spacetech.moovme.clases;

public class ListAssetBachCodes {
    Integer lastCodeValue=0;
    public Integer createNewCode(){
        lastCodeValue++;
        return lastCodeValue;
    }
}
