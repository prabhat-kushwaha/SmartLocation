package com.prabhatkuswaha.smartlocationprovider;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.prabhatkuswaha.smartlocation.SmartLocation;

public class MainActivity extends AppCompatActivity {
    TextView tvResponseText;
    private static final String TAG = "MainActivity";

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResponseText = findViewById(R.id.tvResponseText);
        ((Button) findViewById(R.id.btGetCurrentLocation)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SmartLocation.isPermissionsGranted(MainActivity.this)) {
                    if (SmartLocation.isGPSEnable(MainActivity.this)) {
                        SmartLocation.getCurrentLocation(MainActivity.this, new SmartLocation.LocationResponse() {
                            @Override
                            public void onSuccess(double Latitude, double Longitude) {
                                Log.d(TAG, "onSuccess: " + Latitude + "\n" + Longitude);
                                tvResponseText.setText("Latitude:" + Latitude + "\n" + "Longitude:" + Longitude);
                            }

                            @Override
                            public void onFailure(String error) {
                                tvResponseText.setText(error);
                            }
                        });
                    } else
                        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();
                } else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        });


        ((Button) findViewById(R.id.btGetAddress)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SmartLocation.isPermissionsGranted(MainActivity.this)) {
                    if (SmartLocation.isGPSEnable(MainActivity.this)) {
                        SmartLocation.getCurrentLocationAddress(MainActivity.this, new SmartLocation.AddressResponse() {
                            @Override
                            public void onSuccess(String response) {
                                tvResponseText.setText(response);
                            }

                            @Override
                            public void onFailure(String error) {
                                tvResponseText.setText(error);
                            }
                        });
                    } else
                        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();
                } else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        });


        ((Button) findViewById(R.id.btGetStateName)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SmartLocation.isPermissionsGranted(MainActivity.this)) {
                    if (SmartLocation.isGPSEnable(MainActivity.this)) {
                        SmartLocation.getCurrentStateName(MainActivity.this, new SmartLocation.AddressResponse() {
                            @Override
                            public void onSuccess(String response) {
                                tvResponseText.setText(response);
                            }

                            @Override
                            public void onFailure(String error) {
                                tvResponseText.setText(error);
                            }
                        });
                    } else
                        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();
                } else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        });

        ((Button) findViewById(R.id.btGetCityName)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SmartLocation.isPermissionsGranted(MainActivity.this)) {
                    if (SmartLocation.isGPSEnable(MainActivity.this)) {
                        SmartLocation.getCurrentCityName(MainActivity.this, new SmartLocation.AddressResponse() {
                            @Override
                            public void onSuccess(String response) {
                                tvResponseText.setText(response);
                            }

                            @Override
                            public void onFailure(String error) {
                                tvResponseText.setText(error);
                            }
                        });
                    } else
                        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();
                } else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        });

        ((Button) findViewById(R.id.btGetCountryName)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SmartLocation.isPermissionsGranted(MainActivity.this)) {
                    if (SmartLocation.isGPSEnable(MainActivity.this)) {
                        SmartLocation.getCurrentCountryName(MainActivity.this, new SmartLocation.AddressResponse() {
                            @Override
                            public void onSuccess(String response) {
                                tvResponseText.setText(response);
                            }

                            @Override
                            public void onFailure(String error) {
                                tvResponseText.setText(error);
                            }
                        });
                    } else
                        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();
                } else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        });


        ((Button) findViewById(R.id.btGetPostalCode)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SmartLocation.isPermissionsGranted(MainActivity.this)) {
                    if (SmartLocation.isGPSEnable(MainActivity.this)) {
                        SmartLocation.getCurrentPostalCode(MainActivity.this, new SmartLocation.AddressResponse() {
                            @Override
                            public void onSuccess(String response) {
                                tvResponseText.setText(response);
                            }

                            @Override
                            public void onFailure(String error) {
                                tvResponseText.setText(error);
                            }
                        });
                    } else
                        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();
                } else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        });


        ((Button) findViewById(R.id.btStartLocationService)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SmartLocation.isPermissionsGranted(MainActivity.this)) {
                    if (SmartLocation.isGPSEnable(MainActivity.this)) {
                        if (!SmartLocation.isLocationUpdateRunning(MainActivity.this))
                            //   SmartLocation.createLocationUpdate(MainActivity.this, 5000, 500);
                            SmartLocation.createLocationUpdate(MainActivity.this);
                    } else
                        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();
                } else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        });

        ((Button) findViewById(R.id.btGetLocationResponse)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SmartLocation.isPermissionsGranted(MainActivity.this)) {
                    if (SmartLocation.isGPSEnable(MainActivity.this)) {
                        if (SmartLocation.isLocationUpdateRunning(MainActivity.this)) {
                            SmartLocation.getUpdatedLocations(MainActivity.this, new SmartLocation.LocationResponse() {
                                @Override
                                public void onSuccess(final double Latitude, final double Longitude) {
                                    tvResponseText.setText("Latitude:" + Latitude + "\n" + "Longitude:" + Longitude);
                                }

                                @Override
                                public void onFailure(String error) {
                                    tvResponseText.setText(error);
                                }
                            });
                        }
                        else
                            Toast.makeText(getApplicationContext(), "PLEASE START LOCATION UPDATE", Toast.LENGTH_SHORT).show();

                    } else
                        Toast.makeText(MainActivity.this, "PLEASE ENABLE GPS", Toast.LENGTH_SHORT).show();
                } else
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
        });
        ((Button) findViewById(R.id.btStopLocationUpdate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmartLocation.stopLocationUpdate(MainActivity.this);
            }
        });
    }

}
