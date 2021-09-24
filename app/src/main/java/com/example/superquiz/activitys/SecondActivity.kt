package com.example.superquiz.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.superquiz.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Start Second Activity", Toast.LENGTH_SHORT).show()
    }
}