package com.aprilianta.playgroundmapsroute

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        btnMapsInApp.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        btnGoogleMaps.setOnClickListener {
            mapdirection(-7.782712119877584, 110.36964777794265, -7.79263091196191, 110.36588012905554)
        }
    }

    private fun mapdirection(latori: Double, longori: Double, latdes: Double, longdes: Double) {
        //val gmmIntentUri = Uri.parse("google.navigation:q=$lat,$longi&mode=w")
        val gmmIntentUri = Uri.parse(
            "https://www.google.com/maps/dir/?api=1&origin=" +
                    "$latori,$longori&destination=$latdes,$longdes&travelmode=driving")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}