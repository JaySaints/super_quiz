package com.example.superquiz.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.superquiz.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.main_btn_start)
        btnStart.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Start app", Toast.LENGTH_SHORT).show()


    }




}