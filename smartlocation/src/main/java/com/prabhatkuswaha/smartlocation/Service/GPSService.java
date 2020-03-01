package com.prabhatkuswaha.smartlocation.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.prabhatkuswaha.smartlocation.Helper.Constants;
import com.prabhatkuswaha.smartlocation.Helper.Utils;

public class GPSService extends Service {

    FusedLocationProviderClient
            fusedLocationProviderClient;

    LocationCallback locationCallback;
    @Override
    public void onCreate() {
        super.onCreate();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                Intent intent = new Intent("com.data.GPSData");
                Bundle bundle = new Bundle();
                bundle.putDouble(Constants.LAT, locationResult.getLastLocation().getLatitude());
                bundle.putDouble(Constants.LNG, locationResult.getLastLocation().getLongitude());
                intent.putExtras(bundle);
                sendBroadcast(intent);
            }

            @Override
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                super.onLocationAvailability(locationAvailability);
            }
        };
        startLocationUpdates();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private LocationRequest getLocationRequest() {


        LocationRequest request = new LocationRequest();
        if (Utils.getPreferences() != null) {
            request.setInterval(Utils.getPreferences().getInt(Constants.DEFUALT_INTERVAL_STR, 0));
            request.setFastestInterval(Utils.getPreferences().getInt(Constants.FAST_INTERVAL_STR, 0));

        } else {
            request.setInterval(Constants.DEFUALT_INTERVAL);
            request.setFastestInterval(Constants.FAST_INTERVAL);
        }
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return request;
    }

    private void startLocationUpdates() {
        fusedLocationProviderClient.requestLocationUpdates(getLocationRequest(),
                locationCallback,
                Looper.getMainLooper());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationCallback != null)
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }
}