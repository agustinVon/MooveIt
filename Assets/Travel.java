package Assets;

import Users.Timer;

public class Travel {

    private final Asset asset;

    public Travel(Asset asset, Timer timer){
        this.asset=asset;
    }

    public Asset getAsset() {
        return asset;
    }
}
