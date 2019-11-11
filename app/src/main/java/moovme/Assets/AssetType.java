package moovme.Assets;

public class AssetType {

    private final Integer point;
    private final String name;

    public AssetType(Integer pointsPerMinute, String name){
        this.point=pointsPerMinute;
        this.name=name;
    }

    public Integer getPoint() {
        return point;
    }
    public String getName(){return name;}

    public boolean equals(Object o){
        if( o instanceof com.spacetech.moovme.Assets.AssetType){
            return this.getName().equals(((com.spacetech.moovme.Assets.AssetType) o).getName());
        }else {
            return false;
        }
    }
}
