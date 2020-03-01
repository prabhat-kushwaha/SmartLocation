package com.prabhatkuswaha.smartlocation.Helper;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.preference.PreferenceManager;

import androidx.annotation.RequiresApi;

public class Utils {

    static SharedPreferences preferences;
    static SharedPreferences.Editor editor;


    public static void storeInterval(Context context, Integer defaultinterval, Integer fastinterval) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.clear().commit();
        editor.putInt(Constants.DEFUALT_INTERVAL_STR, fastinterval).commit();
        editor.putInt(Constants.FAST_INTERVAL_STR, defaultinterval).commit();
    }

    public static SharedPreferences getPreferences() {
        return preferences;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public static boolean isGPSEnable(Context context) {
        LocationManager manager = (LocationManager) context.getSystemService(Service.LOCATION_SERVICE);
        return manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static boolean checkPermissions(Context context) {
        if (context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            return true;
        else
            return false;
    }

}