package com.supasheva.bootcamp.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.supasheva.bootcamp.R
import com.supasheva.bootcamp.activities.LearnerProfile
import com.supasheva.bootcamp.activities.MainActivity
import com.supasheva.bootcamp.data.LearnersList

class LearnersAdapter(private val context: Context, private val layout: Int) :
  Adapter<LearnersAdapter.LearnersViewHolder>() {

  private val learners = LearnersList.learners


  class LearnersViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
    val name: TextView = view!!.findViewById(R.id.learnerName)

    val image: ImageView = view!!.findViewById(R.id.learnerImage)

    val learnerClick: CardView = view!!.findViewById(R.id.linearLayout)


  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnersViewHolder {


    val adapterLayout =
      LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)


    return LearnersViewHolder(adapterLayout)

  }

fun handleLearnerCLick(position:Int){
  val allLearner = learners[position]

  val name = allLearner.name
  val email: String = allLearner.email
  val gender: String = allLearner.gender
  val profession :String = allLearner.profession
  val learnerImag :Int = allLearner.image
  val phoneNumb: String = allLearner.phone


  val intent = Intent(context, LearnerProfile::class.java)
  intent.putExtra("name",name)
  intent.putExtra("email",email)
  intent.putExtra("gender",gender)
  intent.putExtra("phone",phoneNumb)
  intent.putExtra("profession",profession)
  intent.putExtra("learnerImg", learnerImag)
  intent.putExtra("AM","AM")
  context.startActivity(intent)
}

  override fun onBindViewHolder(holder: LearnersViewHolder, position: Int) {

    val learnerData = learners[position]


    holder.name.text = learnerData.name

    holder.learnerClick.setOnClickListener {
      handleLearnerCLick(position)
    }

//    Glide.with(context).load(R.raw.kwadwo).into(holder.image);

    Glide
      .with(context)
      .load(learnerData.image)
      .centerCrop()
      .placeholder(R.drawable.ic_launcher_foreground)
      .into(holder.image);
    Log.i("data image ",""+learnerData.image)

    Log.i("images ",""+holder.image)

//    holder.image.setImageResource(learnerData.image)


  }



  override fun getItemCount(): Int {
    return learners.size
  }
}
