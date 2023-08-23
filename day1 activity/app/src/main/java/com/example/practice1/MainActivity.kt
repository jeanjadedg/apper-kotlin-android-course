package com.example.practice1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.practice1.databinding.ActivityMainBinding
import com.example.practice1.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?= null
    private var isLoggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Check if user is logged in (you can use your actual logic here)
        isLoggedIn = true // Replace with your actual logic to check login status

        // Show appropriate buttons based on login status
        if (isLoggedIn) {
            binding?.spendingsButton?.setOnClickListener { view ->
                val spending = Intent(this, SpendingsActivity::class.java)
                startActivity(spending)
            }

            binding?.budgetButton?.setOnClickListener {
                val budget = Intent(this, IncomeActivity::class.java)
                startActivity(budget)
            }

            binding?.signOutButton?.setOnClickListener {
                isLoggedIn = false
                navigateToLoginActivity()
            }
        } else {
            // Hide the buttons if not logged in
            binding?.spendingsButton?.visibility = View.GONE
            binding?.budgetButton?.visibility = View.GONE
        }
    }

    private fun navigateToLoginActivity() {
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
        finish() // Close the current activity
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}