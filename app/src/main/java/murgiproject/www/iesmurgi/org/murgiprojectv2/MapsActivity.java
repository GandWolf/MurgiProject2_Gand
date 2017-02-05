package murgiproject.www.iesmurgi.org.murgiprojectv2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtenga el SupportMapFragment y se notificará cuando el mapa esté listo para ser utilizado
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng iesmurgi = new LatLng(36.7817215, -2.815615);
        mMap.addMarker(new MarkerOptions().position(iesmurgi).title("IES Murgi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(iesmurgi, 17));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(iesmurgi));
    }
}
