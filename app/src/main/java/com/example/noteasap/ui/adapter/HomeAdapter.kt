package com.example.noteasap.ui.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.ui.content.ContentActivity
import com.example.noteasap.ui.model.OwnNotes

class HomeAdapter(
        val listpost:ArrayList<OwnNotes>,
        val context: Context):RecyclerView.Adapter<HomeAdapter.HomwviewHolder>() {

    class HomwviewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val t_name: TextView;
        val u_name: TextView;
        val dis: TextView;
        val home: RelativeLayout;

        init {
            t_name = view.findViewById(R.id.topic)
            u_name = view.findViewById(R.id.u_name)
            dis = view.findViewById(R.id.dis)
            home=view.findViewById(R.id.home)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomwviewHolder {
        val view= LayoutInflater.from(parent.context)
                .inflate(R.layout.forhome,parent,false)
        return HomeAdapter.HomwviewHolder(view)
    }

    override fun onBindViewHolder(holder: HomwviewHolder, position: Int) {
        val note=listpost[position]
        holder.t_name.text=note.topic
        holder.u_name.text=note.c_name
        holder.dis.text=note.description
        holder.home.setOnClickListener(){
            val intent = Intent(context, ContentActivity::class.java)
            intent.putExtra("notes",note)
            context.startActivity(intent);
        }
    }

    override fun getItemCount(): Int {
       return listpost.size
    }
}