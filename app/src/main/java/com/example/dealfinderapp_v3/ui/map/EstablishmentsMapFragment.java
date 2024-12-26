package com.example.dealfinderapp_v3.ui.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.dealfinderapp_v3.R;
import com.example.dealfinderapp_v3.ui.establishment.Establishment;
import com.example.dealfinderapp_v3.ui.establishment.EstablishmentActivity;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;
import java.util.List;

public class EstablishmentsMapFragment extends Fragment {

    private MapView mapView;
    private static final int DEFAULT_ZOOM_LEVEL = 18;
    private GeoPoint targetLocation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.establishments_map, container, false);



        // Установка целевого местоположения
        this.setTargetLocation(54.988465, 82.905631);

        // Initialize the map view
        mapView = view.findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        // Important! Set the OpenStreetMap tile source
        Configuration.getInstance().setUserAgentValue(getActivity().getPackageName());

        // Center the map to the target location
        if (targetLocation != null) {
            mapView.getController().setCenter(targetLocation);
            mapView.getController().setZoom(DEFAULT_ZOOM_LEVEL);
        }


        List<Establishment> establishments = new ArrayList<>();
        establishments.add(new Establishment(1, "Brewsell", 54.989933, 82.906595));
        establishments.add(new Establishment(2, "Кофейная карта", 54.989082, 82.905892));
// Добавьте больше заведений по мере необходимости

        // Добавление маркеров на карту для каждого заведения
        for (final Establishment establishment : establishments) {
            Marker marker = new Marker(mapView);
            marker.setPosition(new GeoPoint(establishment.getLatitude(), establishment.getLongitude()));
            marker.setTitle(establishment.getName());
            // Добавление обработчика кликов на маркер
            marker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker, MapView mapView) {
                    // Открываем страницу заведения при клике на маркер
                    openEstablishmentPage(establishment);
                    return true;
                }
            });
            mapView.getOverlays().add(marker);
        }


        return view;
    }

    private void openEstablishmentPage(Establishment establishment) {
        // Создаем интент для открытия страницы заведения
        Intent intent = new Intent(getActivity(), EstablishmentActivity.class);
        // Передаем данные о заведении в интент
        intent.putExtra("establishment_id", establishment.getId());
        // Запускаем активити
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume(); // Needed for OSMDroid
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause(); // Needed for OSMDroid
    }

    // Method to set the target location
    public void setTargetLocation(double latitude, double longitude) {
        targetLocation = new GeoPoint(latitude, longitude);
        if (mapView != null) {
            mapView.getController().setCenter(targetLocation);
            mapView.getController().setZoom(DEFAULT_ZOOM_LEVEL);
        }
    }
}