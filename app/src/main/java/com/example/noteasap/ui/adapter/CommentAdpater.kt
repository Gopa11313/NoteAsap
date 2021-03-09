package com.example.noteasap.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CommentAdpater(
    val listcomment: ArrayList<com.example.noteasap.ui.model.Comment>,
    val context: Context,
):RecyclerView.Adapter<CommentAdpater.CommentviewHolder>()
{
    class CommentviewHolder(view: View):RecyclerView.ViewHolder(view){
        var name:TextView;
        val comment:TextView;
        val update_delete:ImageButton;
        val imageForComment:ImageView
        init {
            name=view.findViewById(R.id.name)
            comment=view.findViewById(R.id.comment)
            update_delete=view.findViewById(R.id.imageView4)
            imageForComment=view.findViewById(R.id.imageForHomeView)
            update_delete.setOnClickListener(){
                val popupMenu = PopupMenu(view.getContext(), view)
                popupMenu.inflate(R.menu.menu3)
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
        val id=comment.userId
        CoroutineScope(Dispatchers.IO).launch {
            val repository=UserRepository()
            val response=repository.getme(id!!)
            if(response.success==true){
                val data=response.data
                withContext(Main){
                    holder.name.text= data?.get(0)?.name
                    val imageUrl=data?.get(0)?.image
                    val imagePath = ServiceBuilder.loadImagePath() +imageUrl
                    if (!imageUrl.equals("noimg")) {
                        Glide.with(context)
                            .load(imagePath)
                            .fitCenter()
                            .into(holder.imageForComment)
                    }
                }
            }
        }

        //holder.name.text=comment.name
        holder.comment.text=comment.comment

    }

    override fun getItemCount(): Int {
        return listcomment.size;
    }
}