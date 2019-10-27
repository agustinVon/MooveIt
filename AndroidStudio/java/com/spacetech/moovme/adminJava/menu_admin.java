package com.spacetech.moovme.adminJava;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.spacetech.moovme.AssettypeAdapter;
import com.spacetech.moovme.Mooveme;
import com.spacetech.moovme.R;
import com.spacetech.moovme.Repository.RepositoryAdmin;
import com.spacetech.moovme.Repository.RepositoryUser;
import com.spacetech.moovme.ZoneAdapter;
import com.spacetech.moovme.clases.Administrator;
import com.spacetech.moovme.clases.Asset;
import com.spacetech.moovme.clases.AssetType;
import com.spacetech.moovme.clases.ListAssetBachCodes;
import com.spacetech.moovme.clases.PhoneNumber;
import com.spacetech.moovme.clases.User;
import com.spacetech.moovme.clases.Zone;
import com.spacetech.moovme.clases.ZoneAlreadyExistsException;
import com.spacetech.moovme.clases.ZoneDoesNotExistException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class menu_admin extends AppCompatActivity {

    String ActiveAdmin;
    EditText et_name,et_phoneuser,et_zonename,et_zonepoint, et_assettypename, et_assettypepoint,et_aBatchprice,et_aBatchcant,et_aBatchcode;
    String name,UserPhone,assetTypename;
    Button btn_addadmin,btn_blockuser,btn_addzone,btn_deletezone, btn_addassettype,btn_assetbatch;
    Spinner sp_assettype,sp_zone;
    AssetType assetTypeActive;
    Zone zoneactive;
    RepositoryAdmin repositoryAdmin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_menu);

        Intent i = new Intent();
        i = getIntent();
        ActiveAdmin = i.getStringExtra("name");
        sp_assettype = (Spinner) findViewById(R.id.spn_assettype);
        sp_zone = (Spinner) findViewById(R.id.spn_zone);

        et_phoneuser = (EditText)findViewById(R.id.et_phoneuser_id);
        et_name = (EditText) findViewById(R.id.et_name_id);
        et_zonename = (EditText) findViewById(R.id.et_zonename_id);
        et_zonepoint = (EditText)findViewById(R.id.et_zonepoints_id);
        et_assettypename = (EditText)findViewById(R.id.et_assettype_id);
        et_assettypepoint = (EditText)findViewById(R.id.et_assettypepoint_id);
        et_aBatchcant = (EditText)findViewById(R.id.et_assetbatch_cant);
        et_aBatchprice = (EditText)findViewById(R.id.et_assetbatch_price);
        et_aBatchcode = (EditText)findViewById(R.id.et_assetbatch_code);

        btn_addadmin = (Button) findViewById(R.id.btn_addadmin_id);
        btn_blockuser = (Button) findViewById(R.id.btn_blocuser_id);
        btn_addzone = (Button) findViewById(R.id.btn_addzone_id);
        btn_deletezone = (Button) findViewById(R.id.btn_deletezone_id);
        btn_addassettype = (Button) findViewById(R.id.btn_addassettype_id);
        btn_assetbatch = (Button)findViewById(R.id.btn_addassetbatch_id);

        repositoryAdmin = Mooveme.getRepositoryAdmin();
        //Toast.makeText(getApplicationContext(), phoneActiveAdmin,Toast.LENGTH_LONG).show();
        final Administrator activeAdmin = repositoryAdmin.findAdmin(ActiveAdmin);

        btn_addadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!et_name.getText().toString().isEmpty()){
                    try {
                        addnewAdmin(et_name,activeAdmin);
                        saveinformationAdmin();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(),"Complete the field text",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Complete the field text",Toast.LENGTH_SHORT).show();

                }

            }
        });

        btn_blockuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    adminblockuser(et_phoneuser,activeAdmin);
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(),"Complete the field text",Toast.LENGTH_SHORT).show();

                }
            }
        });

        btn_addzone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    adminaddZone(et_zonename,et_zonepoint,activeAdmin);
                    saveinformationZone();
                } catch (ZoneAlreadyExistsException e) {
                    Toast.makeText(getApplicationContext(),"This zone already exist",Toast.LENGTH_LONG).show();
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Error input points",Toast.LENGTH_LONG).show();
                }
                SpinnerZoneType();
            }
        });

        btn_deletezone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    admindeletezone(et_zonename,activeAdmin);
                } catch (ZoneDoesNotExistException e) {
                    Toast.makeText(getApplicationContext(),"This zone doesnt exist", Toast.LENGTH_LONG).show();
                }
                saveinformationZone();
                SpinnerZoneType();
            }
        });

        btn_addassettype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminCreateAssetType(et_assettypename,et_assettypepoint,activeAdmin);
            }
        });
        SpinnerAssetType();
        SpinnerZoneType();

        btn_assetbatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAssetBatch(assetTypename,et_aBatchcant,et_aBatchprice,et_aBatchcode,activeAdmin);
            }
        });


    }

    private void SpinnerZoneType() {
        HashMap zoneHashMap = Mooveme.getRepositoryZone().getZones();
        Collection values = zoneHashMap.values();
        ArrayList<Zone> zoneArrayList = new ArrayList<Zone>(values);
        ZoneAdapter adapter = new ZoneAdapter(getApplicationContext(),zoneArrayList);
        sp_zone.setAdapter(adapter);
        zoneactive = (Zone) sp_zone.getSelectedItem();
    }

    private void addAssetBatch(String assetTypename, EditText et_aBatchcant, EditText et_aBatchprice, EditText et_aBatchcode, Administrator activeAdmin) {
        int cantidad = Integer.parseInt(et_aBatchcant.getText().toString());
        int price = Integer.parseInt(et_aBatchprice.getText().toString());
        Integer codeint = Integer.parseInt(et_aBatchcode.getText().toString());

        activeAdmin.buyBatch(assetTypeActive,cantidad,zoneactive,new ListAssetBachCodes(),price);
        Toast.makeText(getApplicationContext(),"u've buyed " + cantidad + " " + assetTypeActive.getName(), Toast.LENGTH_SHORT).show();

    }

    public void SpinnerAssetType(){
        ArrayList assetTypes= Mooveme.getRepositoryAsset().getAssetTypeArrayList();
        AssettypeAdapter adapter = new AssettypeAdapter(getApplicationContext(),assetTypes);
        sp_assettype.setAdapter(adapter);
        assetTypename = sp_assettype.getSelectedItem().toString();
        assetTypeActive = (AssetType) sp_assettype.getSelectedItem();

    }
    public void adminblockuser(EditText et_phonenumber, Administrator administrator) throws NullPointerException {
        UserPhone = et_phoneuser.getText().toString();
        administrator.setUserLock(Mooveme.getRepositoryUser(),new PhoneNumber(UserPhone),true);
    }

    public void addnewAdmin(EditText et_name, Administrator administrator) throws Exception{
        name = et_name.getText().toString();
        administrator.registerAdmin(repositoryAdmin,name);
        Toast.makeText(getApplicationContext(), name + " had been added",Toast.LENGTH_SHORT).show();


    }

    public void adminCreateAssetType(EditText et_assetname, EditText et_assetpoint,Administrator administrator){
        String assetName = et_assetname.getText().toString();
        int points = Integer.parseInt(et_assetpoint.getText().toString());
        administrator.createAssetType(assetName,points,Mooveme.getRepositoryAsset());
        Toast.makeText(getApplicationContext(),"Se creo el asset con nombre " + assetName , Toast.LENGTH_SHORT).show();
    }

    public void adminaddZone(EditText et_zone,EditText et_point_zone,Administrator administrator) throws ZoneAlreadyExistsException,NumberFormatException {
        String zonename = et_zone.getText().toString();
        int point = Integer.parseInt(et_point_zone.getText().toString());
        administrator.createNewZone(Mooveme.getRepositoryZone(),point,zonename,getApplicationContext());
    }

    public void admindeletezone(EditText et_zonename, Administrator administrator) throws ZoneDoesNotExistException {
        String zonename = et_zonename.getText().toString();
        administrator.deleteZone(Mooveme.getRepositoryZone(),zonename);
    }
    public void saveinformationAdmin(){
        SharedPreferences sharedPreferences = getSharedPreferences("Mooveme", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Mooveme.getRepositoryAdmin().getAdmins());
        editor.putString("Admins",json);
        editor.apply();
    }
    public void saveinformationZone(){
        SharedPreferences sharedPreferences = getSharedPreferences("Mooveme", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Mooveme.getRepositoryZone().getZones());
        editor.putString("Zone",json);
        editor.apply();
        Toast.makeText(getApplicationContext(),"repository saved",Toast.LENGTH_SHORT).show();
    }

}
