package com.example.noteasap.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.ui.content.contentForNote.ContentActivity
import com.example.noteasap.ui.model.OwnNotes

class HomeAdapter(
        val listpost:ArrayList<OwnNotes>,
        val context: Context):RecyclerView.Adapter<HomeAdapter.HomwviewHolder>() {

    class HomwviewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val t_name: TextView;
        val u_name: TextView;
        val home: ConstraintLayout;
        val des:TextView
        val ratingBar:RatingBar
        init {
            t_name = view.findViewById(R.id.topic)
            u_name = view.findViewById(R.id.u_name)
            home=view.findViewById(R.id.home)
            des=view.findViewById(R.id.des)
            ratingBar=view.findViewById(R.id.ratingBar)
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

        val ratting=note.ratting;
        if(ratting!==null){
            holder.ratingBar.rating=ratting.toFloat()
        }
    }

    override fun getItemCount(): Int {
       return listpost.size
    }
}