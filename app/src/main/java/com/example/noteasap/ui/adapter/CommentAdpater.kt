package com.example.noteasap.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R


class CommentAdpater(
    val listcomment: ArrayList<com.example.noteasap.ui.model.Comment>,
    val context: Context,
):RecyclerView.Adapter<CommentAdpater.CommentviewHolder>()
{
    class CommentviewHolder(view: View):RecyclerView.ViewHolder(view){
        val name:TextView;
        val comment:TextView;
        val update_delete:ImageButton;
        init {
            name=view.findViewById(R.id.name)
            comment=view.findViewById(R.id.comment)
            update_delete=view.findViewById(R.id.imageView4)
            update_delete.setOnClickListener(){
                val popupMenu = PopupMenu(view.getContext(), view)
                popupMenu.inflate(R.menu.menu3)
//                popupMenu.setOnMenuItemClickListener()
                popupMenu.show()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentviewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.comment, parent, false)
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
    fun popupmenu(){

    }
}