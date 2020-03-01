package com.prabhatkuswaha.smartlocation;

import android.Manifest;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.prabhatkuswaha.smartlocation.Helper.Constants;
import com.prabhatkuswaha.smartlocation.Helper.LocationAddressHelper;
import com.prabhatkuswaha.smartlocation.Helper.Utils;
import com.prabhatkuswaha.smartlocation.Service.GPSService;

public class SmartLocation {


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static boolean isGPSEnable(Context context) {
        return Utils.isGPSEnable(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean isPermissionsGranted(Context context) {
        return Utils.checkPermissions(context);
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getCurrentLocation(Context context, final LocationResponse response) {
        if (Utils.checkPermissions(context)) {
            if (Utils.isGPSEnable(context)) {
                FusedLocationProviderClient providerClient = LocationServices.getFusedLocationProviderClient(context);
                providerClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null)
                            response.onSuccess(location.getLatitude(), location.getLongitude());
                        else
                            response.onFailure("Location not detected");
                    }
                });

            } else
                Toast.makeText(context, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();

        } else
            Toast.makeText(context, "THIS APP REQUIRED LOCATION PERMISSIONS", Toast.LENGTH_SHORT).show();

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getCurrentLocationAddress(final Context context, final AddressResponse response) {
        getCurrentLocation(context, new LocationResponse() {
            @Override
            public void onSuccess(double Latitude, double Longitude) {
                response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.ADDRESS) == null ? "" : LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.ADDRESS));
            }

            @Override
            public void onFailure(String error) {
                response.onFailure(error);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getCurrentCityName(final Context context, final AddressResponse response) {
        getCurrentLocation(context, new LocationResponse() {
            @Override
            public void onSuccess(double Latitude, double Longitude) {
                response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.CITY) == null ? "" : LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.CITY));
            }

            @Override
            public void onFailure(String error) {
                response.onFailure(error);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getCurrentCountryName(final Context context, final AddressResponse response) {
        getCurrentLocation(context, new LocationResponse() {
            @Override
            public void onSuccess(double Latitude, double Longitude) {
                response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.COUNTRY) == null ? "" : LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.COUNTRY));
            }

            @Override
            public void onFailure(String error) {
                response.onFailure(error);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getCurrentStateName(final Context context, final AddressResponse response) {
        getCurrentLocation(context, new LocationResponse() {
            @Override
            public void onSuccess(double Latitude, double Longitude) {
                response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.STATE) == null ? "" : LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.STATE));
            }

            @Override
            public void onFailure(String error) {
                response.onFailure(error);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getCurrentPostalCode(final Context context, final AddressResponse response) {
        getCurrentLocation(context, new LocationResponse() {
            @Override
            public void onSuccess(double Latitude, double Longitude) {
                response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.POSTAL_CODE) == null ? "" : LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.POSTAL_CODE));
            }

            @Override
            public void onFailure(String error) {
                response.onFailure(error);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getAddressByLatLng(Context context, double Latitude, double Longitude, AddressResponse response) {
        if (LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.ADDRESS) == null) {
            response.onFailure("ADDRESS NOT FOUND");
        } else {
            response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.ADDRESS));
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getCityNameByLatLng(Context context, double Latitude, double Longitude, AddressResponse response) {
        if (LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.CITY) == null) {
            response.onFailure("CITY NOT FOUND");
        } else {
            response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.CITY));
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getCountryNameByLatLng(Context context, double Latitude, double Longitude, AddressResponse response) {
        if (LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.COUNTRY) == null) {
            response.onFailure("COUNTRY NOT FOUND");
        } else {
            response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.COUNTRY));
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getStateNameByLatLng(Context context, double Latitude, double Longitude, AddressResponse response) {
        if (LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.STATE) == null) {
            response.onFailure("STATE NOT FOUND");
        } else {
            response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.STATE));
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void getPostalCodeByLatLng(Context context, double Latitude, double Longitude, AddressResponse response) {
        if (LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.POSTAL_CODE) == null) {
            response.onFailure("POSTAL CODE NOT FOUND");
        } else {
            response.onSuccess(LocationAddressHelper.getResponse(context, Latitude, Longitude, Constants.POSTAL_CODE));
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void createLocationUpdate(Context context) {
        if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (Utils.isGPSEnable(context)) {
                context.startService(new Intent(context, GPSService.class));
            } else
                Toast.makeText(context, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();

        } else
            Toast.makeText(context, "THIS APP REQUIRED LOCATION PERMISSIONS", Toast.LENGTH_SHORT).show();

    }

    private static final String TAG = "SmartLocation";
    public static void getUpdatedLocations(Context context, final LocationResponse locationResponse) {
        if (isLocationUpdateRunning(context)) {
            BroadcastReceiver receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        locationResponse.onSuccess(bundle.getDouble(Constants.LAT), bundle.getDouble(Constants.LNG));
                    }
                }
            };
            IntentFilter intent = new IntentFilter("com.data.GPSData");
            context.registerReceiver(receiver, intent);
        } else
            Toast.makeText(context, "PLEASE START LOCATION UPDATE", Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public static void createLocationUpdate(Context context, int DEFUALT_INTERVAL, int FAST_INTERVAL) {
        if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (Utils.isGPSEnable(context)) {
                if (!isLocationUpdateRunning(context)) {
                    Utils.storeInterval(context, DEFUALT_INTERVAL, FAST_INTERVAL);
                    context.startService(new Intent(context, GPSService.class));
                } else
                    Toast.makeText(context, "LOCATION UPDATE ALREADY RUNNING", Toast.LENGTH_SHORT).show();

            } else
                Toast.makeText(context, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();

        } else
            Toast.makeText(context, "THIS APP REQUIRED LOCATION PERMISSIONS", Toast.LENGTH_SHORT).show();

    }

    public static void stopLocationUpdate(Context context) {
        if (isLocationUpdateRunning(context))
            context.stopService(new Intent(context, GPSService.class));
        else
            Toast.makeText(context, "LOCATION UPDATE ARE NOT RUNNING", Toast.LENGTH_SHORT).show();
    }

    public static boolean isLocationUpdateRunning(Context context) {
        return isMyServiceRunning(context, GPSService.class);
    }

    private static boolean isMyServiceRunning(Context context, Class<?> serviceclass) {
        boolean isRuuning = false;
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo serviceInfo : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceclass.toString().replace("class", "").trim().equals(serviceInfo.service.getClassName()))
                isRuuning = true;
        }
        return isRuuning;
    }

    public interface LocationResponse {
        public void onSuccess(double Latitude, double Longitude);

        public void onFailure(String error);
    }

    public interface AddressResponse {
        public void onSuccess(String response);

        public void onFailure(String error);
    }
}

