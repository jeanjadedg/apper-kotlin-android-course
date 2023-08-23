package com.example.practice1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice1.databinding.ActivityIncomeBinding

class IncomeActivity : AppCompatActivity() {

    private var binding: ActivityIncomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarBudget)

        supportActionBar?.title = "Income"

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolbarBudget?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.cancelButton?.setOnClickListener {
            val backToHome = Intent(this, MainActivity::class.java)
            startActivity(backToHome)
            finish() // Finish the current activity
        }
    }
}
