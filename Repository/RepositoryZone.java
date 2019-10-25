package Repository;

import Assets.Tarifario;
import Assets.Zone;
import Exeptions.ZoneAlreadyExistsException;
import Exeptions.ZoneDoesNotExistException;

import java.util.HashMap;

public class RepositoryZone {

    private HashMap<String, Zone> zones;

    RepositoryZone(){
        zones=new HashMap<>();
    }


    public void add(int zonePoints, String name) throws ZoneAlreadyExistsException {
        if(zones.get(name) != null){
            throw new ZoneAlreadyExistsException();
        }
        zones.put(name,new Zone(name));
    }

    public void delete(String name) throws ZoneDoesNotExistException {
        if(zones.get(name) != null){
            zones.remove(name);
            return;
        } else {
            throw new ZoneDoesNotExistException();
        }
    }
}
