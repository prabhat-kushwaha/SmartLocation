package com.prabhatkuswaha.smartlocation.Helper;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationAddressHelper {


    public static String getResponse(Context mContext, double Latitude, double Longitude, String type) {
        String response = null;
        Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocation(Latitude, Longitude, 1);
            if (type.equals(Constants.ADDRESS))
                response = addressList.get(0).getAddressLine(0);
            if (type.equals(Constants.CITY))
                response = addressList.get(0).getLocality();
            if (type.equals(Constants.STATE))
                response = addressList.get(0).getAdminArea();
            if (type.equals(Constants.COUNTRY))
                response = addressList.get(0).getCountryName();
            if (type.equals(Constants.POSTAL_CODE))
                response = addressList.get(0).getPostalCode();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}

