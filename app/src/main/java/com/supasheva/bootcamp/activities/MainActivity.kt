package com.supasheva.bootcamp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.supasheva.bootcamp.R
import com.supasheva.bootcamp.adapter.LearnersAdapter
import com.supasheva.bootcamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

      binding.list.adapter = LearnersAdapter(
        this,
        1
      )

      // Specify fixed size to improve performance
      binding.list.setHasFixedSize(true)
    }
}
