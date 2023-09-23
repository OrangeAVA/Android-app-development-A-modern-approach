package com.example.uibasics

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    companion object {
        private const val TAG = "Lifecycle"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Primary - onCreate: ")

        val nextButton: Button = findViewById(R.id.btn_next)
        nextButton.setOnClickListener {
            val explicitSecondaryActivityIntent = Intent(this, SecondaryActivity::class.java)
            startActivity(explicitSecondaryActivityIntent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Primary - onStart: ")
    }
    
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Primary - onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Primary - onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Primary - onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Primary - onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Primary - onRestart: ")
    }
}