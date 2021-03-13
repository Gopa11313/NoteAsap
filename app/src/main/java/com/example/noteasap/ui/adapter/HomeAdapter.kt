package com.example.noteasap.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.CommentRepository
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.content.contentForNote.ContentActivity
import com.example.noteasap.ui.model.Notes
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class HomeAdapter(
    val listpost:ArrayList<Notes>,
    val context: Context):RecyclerView.Adapter<HomeAdapter.HomwviewHolder>() {

    class HomwviewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val t_name: TextView;
        val u_name: TextView;
        val home: ConstraintLayout;
        val des:TextView
        val ratingBar:RatingBar
        val Ratting:TextView
        val numberOfRatting:TextView
        val comntCount:TextView
        val imageForHomeView:ImageView
        val name:TextView
        init {
            t_name = view.findViewById(R.id.topic)
            u_name = view.findViewById(R.id.u_name)
            home=view.findViewById(R.id.home)
            Ratting=view.findViewById(R.id.Ratting)
            numberOfRatting=view.findViewById(R.id.numberOfRatting)
            des=view.findViewById(R.id.des)
            ratingBar=view.findViewById(R.id.ratingBar)
            comntCount=view.findViewById(R.id.comntCount)
            imageForHomeView=view.findViewById(R.id.imageForHomeView)
            name=view.findViewById(R.id.name)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomwviewHolder {
        val view= LayoutInflater.from(parent.context)
                .inflate(R.layout.forhome,parent,false)
        return HomeAdapter.HomwviewHolder(view)
    }

    override fun onBindViewHolder(holder: HomwviewHolder, position: Int) {
        val note=listpost[position]
        holder.home.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.trans)
        holder.t_name.text=note.topic
        holder.u_name.text=note.c_name
        holder.home.setOnClickListener(){
            val intent = Intent(context, ContentActivity::class.java)
            intent.putExtra("notes",note)
            context.startActivity(intent);
        }
        holder.des.text=note.description
        holder.Ratting.text=note.ratting.toString()
        holder.numberOfRatting.text=note.noofRating.toString()
        val ratting=note.ratting;
        if(ratting!==null){
            holder.ratingBar.rating=ratting.toFloat()
        }

        val id=note.userId
        CoroutineScope(Dispatchers.IO ).launch {
            val repository=UserRepository()
            val response=repository.getme(id!!)
            if(response.success==true){
                val data=response.data
                withContext(Main){
                    val img=data?.get(0)?.image
                    val name=data?.get(0)?.name
                    val imagePath = ServiceBuilder.loadImagePath() +img
                    if (!img.equals("noimg")) {
                        Glide.with(context)
                            .load(imagePath)
                            .fitCenter()
                            .into(holder.imageForHomeView)
                    }
                    holder.name.text=name
                }

            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            val repository=CommentRepository()
            val response=repository.getComment(note._id!!)
            if(response.success==true){
                val data=response.data?.size
                withContext(Main){
                    holder.comntCount.text="$data Comment"
                }
            }
        }
    }

    override fun getItemCount(): Int {
       return listpost.size
    }
}