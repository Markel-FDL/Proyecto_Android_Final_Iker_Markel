package com.example.proyecto_android_final_iker_markel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExtraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra)

        val volver: Button = findViewById(R.id.VolverActivity)

        findViewById<Button>(R.id.VolverActivity).setOnClickListener {
            finish()
        }

    }

}