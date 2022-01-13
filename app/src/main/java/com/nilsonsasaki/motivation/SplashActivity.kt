package com.nilsonsasaki.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.nilsonsasaki.motivation.databinding.ActivitySplashBinding
import com.nilsonsasaki.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity() {

    private lateinit var _binding: ActivitySplashBinding
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Setting to Light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        //hiding the ActionBar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        mSecurityPreferences= SecurityPreferences(this)

        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.btSaveButton.setOnClickListener {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = _binding.etUserName.text.toString()

        if (name.isNotBlank()) {
            mSecurityPreferences.storeString("name",name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "Informe o seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}