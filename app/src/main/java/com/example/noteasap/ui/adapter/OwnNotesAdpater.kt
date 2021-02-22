package com.example.noteasap.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.ui.model.OwnNotes

class OwnNotesAdpater( val listpost:ArrayList<OwnNotes>,
val context: Context):RecyclerView.Adapter<OwnNotesAdpater.OwnnotesviewHolder>() {

    class OwnnotesviewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val t_name: TextView;
        val u_name: TextView;
        val dis: TextView;

        init {
            t_name = view.findViewById(R.id.topic)
            u_name = view.findViewById(R.id.Uname)
            dis = view.findViewById(R.id.discription)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OwnnotesviewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.ownnotes,parent,false)
        return OwnNotesAdpater.OwnnotesviewHolder(view)
    }

    override fun onBindViewHolder(holder: OwnnotesviewHolder, position: Int) {
        val post=listpost[position]
        holder.t_name.text=post.topic
        holder.u_name.text=post.c_name
        holder.dis.text=post.describption
    }

    override fun getItemCount(): Int {
        return listpost.size
    }
}