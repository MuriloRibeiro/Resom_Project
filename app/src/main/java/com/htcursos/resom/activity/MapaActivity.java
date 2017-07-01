package com.htcursos.resom.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.htcursos.resom.R;

import butterknife.ButterKnife;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback{

    private final int READ_GPS_REQUEST_CODE = 123;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        ButterKnife.bind(this);

        MapFragment mapa = (MapFragment) getFragmentManager().findFragmentById(R.id.mapa);
        mapa.getMapAsync(this);

        if(Build.VERSION.SDK_INT == 23){
            if(getApplicationContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MapaActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        READ_GPS_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);

        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener(){
            Marker marker;

            @Override
            public void onMyLocationChange(Location location) {
                LatLng local = new LatLng(location.getLatitude(), location.getLongitude());
                if(marker != null){
                    marker.remove();
                }
                marker = googleMap.addMarker(new MarkerOptions().position(local).title("Sua posição atual").draggable(true));
            }
        });
    }
}
