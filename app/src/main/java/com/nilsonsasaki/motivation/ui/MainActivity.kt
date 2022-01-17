package com.nilsonsasaki.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.nilsonsasaki.motivation.R
import com.nilsonsasaki.motivation.databinding.ActivityMainBinding
import com.nilsonsasaki.motivation.infra.MotivationConstants
import com.nilsonsasaki.motivation.infra.SecurityPreferences
import com.nilsonsasaki.motivation.repository.Mock

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences
    private var phraseFilter = MotivationConstants.FilterHandler.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        mSecurityPreferences = SecurityPreferences(this)

        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        _binding.tvNameText.text = getString(R.string.pt_greetings, name)


        //initial filter setup
        handleFilter(phraseFilter)
        handleNewPhrase(phraseFilter)
        setOnClickListeners()

    }

    private fun setOnClickListeners() {
        _binding.icAll.setOnClickListener() {
            handleFilter(MotivationConstants.FilterHandler.ALL)
        }
        _binding.icHappy.setOnClickListener {
            handleFilter(MotivationConstants.FilterHandler.HAPPY)
        }
        _binding.icMorning.setOnClickListener {
            handleFilter(MotivationConstants.FilterHandler.MORNING)
        }
        _binding.btNewPhrase.setOnClickListener() {
            handleNewPhrase(phraseFilter)
        }
    }

    private fun handleNewPhrase(filter: MotivationConstants.FilterHandler) {
        val phrase = Mock().getPhrase(filter)
        _binding.tvTextPhrase.text = phrase
    }

    private fun handleFilter(value: MotivationConstants.FilterHandler) {

        _binding.icAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        _binding.icHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
        _binding.icMorning.setColorFilter(ContextCompat.getColor(this, R.color.white))

        when (value) {

            MotivationConstants.FilterHandler.ALL -> {
                _binding.icAll.setColorFilter(ContextCompat.getColor(this, R.color.colorSecondary))
            }
            MotivationConstants.FilterHandler.HAPPY -> {
                _binding.icHappy.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.colorSecondary
                    )
                )
            }
            MotivationConstants.FilterHandler.MORNING -> {
                _binding.icMorning.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.colorSecondary
                    )
                )
            }
        }
    }
}