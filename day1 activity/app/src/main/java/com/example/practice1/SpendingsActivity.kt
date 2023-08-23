package com.example.practice1

import android.R
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TextView
import com.example.practice1.databinding.ActivityMainBinding
import com.example.practice1.databinding.ActivitySpendingsBinding
import java.util.Calendar

class SpendingsActivity : AppCompatActivity() {
    private var binding: ActivitySpendingsBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpendingsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarSpending)

        supportActionBar?.title = "Spendings"

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolbarSpending?.setNavigationOnClickListener {
            onBackPressed()
        }

        val categories =
            listOf("Category", "Food", "Bills", "Toiletries", "Transportation", "Clout Chasing")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner = binding?.categorySpinner
        spinner?.adapter = adapter

        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position > 0) {
                    val selectedCategory = categories[position]
                    // Do something with the selected category
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected
            }
        }

        binding?.cancelButton?.setOnClickListener {
            val backToHome = Intent(this, MainActivity::class.java)
            startActivity(backToHome)
            finish() // Finish the current activity
        }
    }
}