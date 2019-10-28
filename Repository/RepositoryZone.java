package com.spacetech.moovme.Repository;


import android.content.Context;
import android.widget.Toast;

import com.spacetech.moovme.clases.Zone;
import com.spacetech.moovme.clases.ZoneAlreadyExistsException;
import com.spacetech.moovme.clases.ZoneDoesNotExistException;

import java.util.HashMap;

public class RepositoryZone {

    private HashMap<String, Zone> zones;

    public RepositoryZone(){
        zones=new HashMap<>();
    }


    public void add(int zonePoints, String name, Context ctx) throws ZoneAlreadyExistsException {
        if(zones.get(name) != null){
            throw new ZoneAlreadyExistsException();
        }else {
            zones.put(name, new Zone(name));
            Toast.makeText(ctx,name + "has been created", Toast.LENGTH_SHORT).show();
        }
    }

    public void setZones(HashMap zones){
        this.zones = zones;

    }
    public HashMap getZones(){
        return zones;
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
