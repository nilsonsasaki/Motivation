package com.nilsonsasaki.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nilsonsasaki.motivation.databinding.ActivityMainBinding
import com.nilsonsasaki.motivation.infra.MotivationConstants
import com.nilsonsasaki.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        mSecurityPreferences = SecurityPreferences(this)

        _binding.tvNameText.text= mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

    }
}