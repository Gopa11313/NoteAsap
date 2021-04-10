package com.example.noteasap.ui.location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteasap.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        val lalu=LatLng(27.667535,85.429603)
        val nigga=LatLng(27.690338,85.360881)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap.addMarker(MarkerOptions().position(lalu).title("Lalu dai ko pasal"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lalu))

        mMap.addMarker(MarkerOptions().position(nigga).title("chiya khana aaeja"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nigga))
    }

}