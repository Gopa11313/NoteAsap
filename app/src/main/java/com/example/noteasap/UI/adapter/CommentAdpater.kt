package com.example.noteasap.UI.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.UI.pupup.EditProfileActivity
import com.example.noteasap.UI.pupup.MessageActivity
import kotlin.coroutines.coroutineContext

class CommentAdpater(
    val listcomment:ArrayList<com.example.noteasap.UI.model.Comment>,
    val context: Context):RecyclerView.Adapter<CommentAdpater.CommentviewHolder>()
{
    class CommentviewHolder(view:View):RecyclerView.ViewHolder(view){
        val name:TextView;
        val comment:TextView;
        val update_delete:ImageButton;
        init {
            name=view.findViewById(R.id.name)
            comment=view.findViewById(R.id.comment)
            update_delete=view.findViewById(R.id.imageView4)
            update_delete.setOnClickListener(){
                val popupMenu= PopupMenu(this, it)
                popupMenu.menuInflater.inflate(R.menu.menu2,popupMenu.menu)
                popupMenu.setOnMenuItemClickListener { iteam->
                    when(iteam.itemId){
                        R.id.edit ->{
                            requireActivity().run{
                            }
                            true
                        }
                        R.id.message -> {
                            requireActivity().run{
                            }
                            true
                        }
                        R.id.About->{
                            true
                        }
                        else -> false
                    }
                }
                popupMenu.show()
            }
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