package Tests;

import Assets.Asset;
import Assets.AssetType;
import Assets.Zone;
import Repository.ListAssetBachCodes;
import Users.Administrator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdministratorTest2 {
    @Test
    public void whenBuyBatchShouldSucced(){
        Administrator admin1=new Administrator(new PhoneNumber("123"),"admin1");
        AssetType bicicletaTipo=new AssetType(5,"bicicleta");
        Asset bicicleta=new Asset(bicicletaTipo,5);
        Zone caba=new Zone("caba");
        ListAssetBachCodes listaDeCodigos=new ListAssetBachCodes();
        ArrayList<Asset> bicicletasEsperadas=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bicicletasEsperadas.add(bicicleta);
        }

        admin1.buyBatch(bicicletaTipo,10,caba,listaDeCodigos,5);

        Assert.assertEquals(bicicletasEsperadas,caba.getTotalAssets());//valores en el debug coinciden pero el test se rompe.
    }
}
