package com.example.uibasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondaryActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "Lifecycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        Log.d(TAG, "Secondary - onCreate: ")

        val btnClose: Button = findViewById(R.id.btn_close)
        btnClose.setOnClickListener {
            finish()
        }

        val btnProceed: Button = findViewById(R.id.btn_proceed)
        btnProceed.setOnClickListener {
            val myIntent = Intent(this, SecondaryActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Secondary - onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Secondary - onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Secondary - onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Secondary - onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Secondary - onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Secondary - onRestart: ")
    }
}