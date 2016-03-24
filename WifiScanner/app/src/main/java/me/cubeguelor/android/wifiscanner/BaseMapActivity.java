package me.cubeguelor.android.wifiscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;


public abstract class BaseMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    protected LatLng mCenterLocation = new LatLng(39.7392, -104.9903);

    protected GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getMapLayoutId());
        initMapIfNecessary();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMapIfNecessary();
    }

    protected void initMapIfNecessary() {
        if (mGoogleMap != null) {
            return;
        }

        MapFragment  mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        initMapSettings();
        initCamera();
    }

    protected void initCamera() {
        CameraPosition position = CameraPosition.builder()
                .target(mCenterLocation)
                .zoom(getInitialMapZoomLevel())
                .build();
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), null);
    }

    @Override
    public void onMapReady(GoogleMap map) {

        mGoogleMap = map;

        setUpMap();

    }

    public void setUpMap(){

        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //mGoogleMap.setMyLocationEnabled(true);
       // mGoogleMap.setTrafficEnabled(true);
        mGoogleMap.setIndoorEnabled(true);
        mGoogleMap.setBuildingsEnabled(true);
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    protected int getMapLayoutId() {
        return R.layout.activity_base_map;
    }

    protected float getInitialMapZoomLevel() {
        return 12.0f;
    }

    protected abstract void initMapSettings();
}
