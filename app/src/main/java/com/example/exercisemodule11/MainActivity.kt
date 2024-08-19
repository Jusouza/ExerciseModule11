package com.example.exercisemodule11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercisemodule11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val activity2 = Intent(this, MainActivity2::class.java)
        val toolbar = binding.toolbar

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        binding.btnStart.setOnClickListener {
            startActivity(activity2)
        }
    }
}