package com.example.noteasap.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.ui.model.Home

class HomeAdapterval(
        val listpost:ArrayList<Home>,
        val context: Context):RecyclerView.Adapter<HomeAdapterval.HomwviewHolder>() {

    class HomwviewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val t_name: TextView;
        val u_name: TextView;
        val dis: TextView;

        init {
            t_name = view.findViewById(R.id.topic)
            u_name = view.findViewById(R.id.u_name)
            dis = view.findViewById(R.id.dis)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomwviewHolder {
        val view= LayoutInflater.from(parent.context)
                .inflate(R.layout.forhome,parent,false)
        return HomeAdapterval.HomwviewHolder(view)
    }

    override fun onBindViewHolder(holder: HomwviewHolder, position: Int) {
        val post=listpost[position]
        holder.t_name.text=post.topic
        holder.u_name.text=post.u_name
        holder.dis.text=post.dis
    }

    override fun getItemCount(): Int {
       return listpost.size
    }
}