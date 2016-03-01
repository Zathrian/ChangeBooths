package com.example.david.changebooths;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocalServicesActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_services);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mContentView = findViewById(R.id.map);

        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng haiti = new LatLng(18.570861, -72.293557);
        mMap.addMarker(new MarkerOptions().position(haiti).title("Clean water"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(haiti, 11));

        LatLng haiti2 = new LatLng(18.536228, -72.284745);
        mMap.addMarker(new MarkerOptions().position(haiti2).title("Free food"));

        LatLng haiti3 = new LatLng(18.570861, -72.274745);
        mMap.addMarker(new MarkerOptions().position(haiti3).title("Community Centers"));

        LatLng haiti4 = new LatLng(18.620798, -72.340155);
        mMap.addMarker(new MarkerOptions().position(haiti4).title("Free Healthcare Centers"));
    }
}
