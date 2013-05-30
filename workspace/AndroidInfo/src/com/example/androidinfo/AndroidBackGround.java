package com.example.androidinfo;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class AndroidBackGround extends Service implements LocationListener{
	private LocationManager myLocationManager;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		myLocationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
	}
	
	@Override
	public void onStart(Intent intent, int startID){
		myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);	
	}
	
	public void onStop(){
		if(myLocationManager != null){
			myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
		}
	}
	
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Log.i("Location Info", Double.toString(location.getLongitude()));
    	Log.i("Location Info", Double.toString(location.getLatitude()));
    	Log.i("Location Info", Double.toString(location.getAltitude())+ "\n");
    	
    	
    	Toast.makeText(getApplicationContext(), "Obtaining up-to-date current Location", Toast.LENGTH_SHORT).show();
		Toast.makeText(getApplicationContext(), "経度 = " + Double.toString(location.getLongitude()) + "\n緯度 = " + Double.toString(location.getLatitude())
				+ "\n標高 = " + Double.toString(location.getAltitude()), Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}
