package com.example.searchview;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.searchview.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    //private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        // SearchView searchView = findViewById(R.id.searchView);




       // searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
         //   @Override
          //  public boolean onQueryTextSubmit(String query) {
            //    String location = searchView.getQuery().toString();
              //  List<Address> addressList = null;
               // if (location != null || !location.equals("")) {
                 //   Geocoder geocoder = new Geocoder(MapsActivity.this);
                   // try {
                     //   addressList = geocoder.getFromLocationName(location, 1);
                   // } catch (IOException e) {
                     //   e.printStackTrace();
                    //}
                   // Address address = addressList.get(0);
                   // LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                   // mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                   // mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));

                   // mMap.addPolyline(new PolylineOptions().add(latLng).color(Color.BLACK).width(2));

                //}
                //return false;
            //}

            //@Override
           // public boolean onQueryTextChange(String newText) {
             //   return false;
            //}
        //});


        // search view
        //<androidx.appcompat.widget.SearchView
        //android:layout_width="match_parent"
        //android:layout_height="wrap_content"
        //android:id="@+id/searchView"
        //android:layout_margin="10dp"
        //android:elevation="5dp"
        //android:backgroundTint="@color/white"
        //android:background="@color/white"
        //app:queryHint="search here"/>


                mapFragment.getMapAsync(this);
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

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick( LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(latLng.latitude + ":" +latLng.longitude);
                mMap.clear();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                mMap.addMarker(markerOptions);
            }
        });
         }
}
