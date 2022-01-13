package com.nilsonsasaki.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.nilsonsasaki.motivation.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var _binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Setting to Light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        //hiding the ActionBar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.btSaveButton.setOnClickListener {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = _binding.etUserName.text.toString()

        if (name.isNotBlank()) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Informe o seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}