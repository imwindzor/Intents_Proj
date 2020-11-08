package com.example.intents_proj

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast

class HomeButtons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_buttons)

        findViewById<Button>(R.id.viewMapbtn).setOnClickListener { openUC() }
        findViewById<Button>(R.id.openWifi).setOnClickListener { wifiSettings() }
        findViewById<Button>(R.id.openYoutube).setOnClickListener { openYoutube() }
        findViewById<Button>(R.id.openSite1).setOnClickListener { errorOne() }
        findViewById<Button>(R.id.openthisApp).setOnClickListener { openApp() }
    }

    private fun openUC() {
        val intent1: Intent = Uri.parse("https://www.uc-bcf.edu.ph").let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        startActivity(intent1)
    }

    private fun wifiSettings() {
        val intent2 = Intent(Settings.ACTION_WIFI_SETTINGS)
//        if (intent2.resolveActivity(packageManager) != null) {
            startActivity(intent2)
//        }
    }

    private fun openYoutube() {
        val intent3 = packageManager.getLaunchIntentForPackage("com.google.android.youtube")
        startActivity(intent3)
    }

    private fun errorOne() {
        val intent4: Intent = Uri.parse("thisisnotasite.com").let { webpage ->
            Intent(Intent.ACTION_VIEW, webpage)
        }
        if (intent4.resolveActivity(packageManager) != null) {
            startActivity(intent4)
        } else {
            Toast.makeText(this, "The intent failed due to a site not found", Toast.LENGTH_LONG).show()
        }
    }

    private fun openApp() {
        val intent5 = packageManager.getLaunchIntentForPackage("com.wemesh.android")
        if (intent5?.resolveActivity(packageManager) != null) {
            startActivity(intent5)
        } else {
            Toast.makeText(this, "The intent failed due to app not found", Toast.LENGTH_LONG).show()
        }
    }
}