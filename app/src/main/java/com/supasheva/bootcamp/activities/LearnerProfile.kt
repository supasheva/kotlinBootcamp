package com.supasheva.bootcamp.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.supasheva.bootcamp.R
import com.supasheva.bootcamp.databinding.ActivityLearnerProfileBinding

class LearnerProfile : AppCompatActivity() {

  private lateinit var binding: ActivityLearnerProfileBinding


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_learner_profile)
    binding = ActivityLearnerProfileBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val intent = getIntent();
    val name = intent.getStringExtra("name")
    val email = intent.getStringExtra("email")
    val gender = intent.getStringExtra("gender")
    val profession = intent.getStringExtra("profession")
    val phonenumber = intent.getStringExtra("phone")
    val learnerImg = intent.getIntExtra("learnerImg", 0)
    val pm: String? = intent.getStringExtra("PM")
    val am: String? = intent.getStringExtra("AM")
    binding.fullnameField.text = name
    binding.profileImag.setImageResource(learnerImg)
    binding.emailField.text = email
    binding.phoneNumber.text = phonenumber
    binding.genderField.text = gender
    binding.professionField.text = profession
    binding.profileImag.setImageResource(learnerImg)
    binding.profileImagTwo.setImageResource(learnerImg)


  }


}
