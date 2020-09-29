package com.smd.studio.mapbox

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.annotations.PolygonOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style


class MainActivity : AppCompatActivity() {

    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, getString(R.string.mapbox_access_token))

        setContentView(R.layout.activity_main)

        mapView = findViewById(R.id.mapView)
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS) {
                // Map is set up and the style has loaded. Now you can add data or make other map adjustments
            }

//            //Markers
//            val marker = MarkerOptions().apply {
//                position(LatLng(42.693, 23.322))
//                title("My First Marker")
//            }
//            mapboxMap.addMarker(marker)
//
//            // Drawing a rectangle
//            val polygonLatLngList: MutableList<LatLng> = ArrayList()
//            polygonLatLngList.add(LatLng(42.690, 23.320))
//            polygonLatLngList.add(LatLng(42.700, 23.320))
//            polygonLatLngList.add(LatLng(42.700, 23.330))
//            polygonLatLngList.add(LatLng(42.690, 23.330))
//            mapboxMap.addPolygon(
//                PolygonOptions()
//                    .addAll(polygonLatLngList)
//                    .fillColor(Color.GREEN)
//            )
//
//            // Custom Styles
//            mapboxMap.setStyle(Style.Builder().fromUri("")) {
//                // Custom map style has been loaded and map is now ready
//            }
        }
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.let { super.onSaveInstanceState(it) }
        mapView?.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }
}