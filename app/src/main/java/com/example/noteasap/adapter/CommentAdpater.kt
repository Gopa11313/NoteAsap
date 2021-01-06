package com.example.noteasap.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.ContentActivity
import com.example.noteasap.R
import org.w3c.dom.Comment
import org.w3c.dom.Text

class CommentAdpater(
    val listcomment:ArrayList<com.example.noteasap.model.Comment>,
    val context: Context):RecyclerView.Adapter<CommentAdpater.CommentviewHolder>()
{
    class CommentviewHolder(view:View):RecyclerView.ViewHolder(view){
        val name:TextView;
        val comment:TextView;
        init {
            name=view.findViewById(R.id.name)
            comment=view.findViewById(R.id.comment)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentviewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.comment,parent,false)
        return CommentviewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentviewHolder, position: Int) {
        val comment=listcomment[position]
        holder.name.text=comment.Sname
        holder.comment.text=comment.comment

    }

    override fun getItemCount(): Int {
        return listcomment.size;
    }
}