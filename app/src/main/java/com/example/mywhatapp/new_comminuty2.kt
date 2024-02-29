package com.example.mywhatapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class new_comminuty2 : AppCompatActivity() {
    lateinit var clearImage:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_comminuty2)

        clearImage = findViewById(R.id.clearCross_imageView)

        clearImage.setOnClickListener {
            onBackPressed()
        }
    }
}