package com.example.explorer

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deviceInfo = """
            Manufacturer => ${Build.MANUFACTURER}
            SDK_INT => ${Build.VERSION.SDK_INT}
            Version => ${Build.VERSION.RELEASE}
            Model => ${Build.MODEL}
        """.trimIndent()

        findViewById<TextView>(R.id.textView).text = deviceInfo
    }
}