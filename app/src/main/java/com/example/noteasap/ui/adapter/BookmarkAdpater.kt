package com.example.noteasap.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.noteasap.ui.content.contentForNote.ContentActivity
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.BookmarkRepository
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.content.contentForBookmarkednote.ContentActivityForBookmark
import com.example.noteasap.ui.model.BookMarkNotes
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.content.Intent as Intent

class BookmarkAdpater(
        val listbookmark:ArrayList<BookMarkNotes>,
        val context: Context):RecyclerView.Adapter<BookmarkAdpater.NoteresViewholder>() {
         class NoteresViewholder(view:View):RecyclerView.ViewHolder(view){
            val universityname:TextView;
             var name:TextView;
             val topic:TextView;
             val bookamarkImage:ImageView
             val list_item:ConstraintLayout

             val imageForBookmark: ImageView
             init {
                 name=view.findViewById(R.id.name)
                 universityname=view.findViewById(R.id.Uname)
                 topic=view.findViewById(R.id.topic)

                 imageForBookmark=view.findViewById(R.id.imageForHomeView)
                 bookamarkImage=view.findViewById(R.id.bookmarkImage)
                 list_item=view.findViewById(R.id.list_item)
             }
         }

    override fun getItemCount(): Int {
        return listbookmark.size
        }

    override fun onBindViewHolder(holder: NoteresViewholder, position: Int) {
        val notes=listbookmark[position]
        holder.list_item.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.trans)
        holder.universityname.text=notes.c_name;
        holder.topic.text=notes.topic;
        val id=notes.userId
        holder.list_item.setOnClickListener(){
            val intent = Intent(context, ContentActivityForBookmark::class.java)
            intent.putExtra("notes",notes)
            context.startActivity(intent);
        }
        holder.bookamarkImage.setOnClickListener(){
            val builder= AlertDialog.Builder(context);
            builder.setMessage("Do you want unMarked the Note")
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("Yes"){dialogInterface,which->
                CoroutineScope(Dispatchers.IO).launch {
                    val repository=BookmarkRepository()
                    val response=repository.deleteBookMarkedNote(notes._id!!)
                    if(response.success==true){
                        withContext(Main){
                            //holder.list_item.animation=AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_in)
//                            Handler().postDelayed(Runnable {
//
//                            },2500)
                            listbookmark.removeAt(position)
                            notifyDataSetChanged()
                            val snack=  Snackbar.make(it,"${response.msg}. Unmarked the Note", Snackbar.LENGTH_SHORT)
                            snack.setAction("Ok") {
                                snack.dismiss()
                            }
                            snack.show()



                        }

                    }
                }
            }
            builder.setNegativeButton("No"){
                    dialogInterface,which->
            }
            builder.show()

        }

        CoroutineScope(Dispatchers.IO).launch {
            val repository= UserRepository()
            val response=repository.getme(id!!)
            if(response.success==true){
                val data=response.data
                withContext(Dispatchers.Main){
                    holder.name.text= data?.get(0)?.name
                    val imageUrl=data?.get(0)?.image
                    val imagePath = ServiceBuilder.loadImagePath() +imageUrl
                    if (!imageUrl.equals("noimg")) {
                        Glide.with(context)
                            .load(imagePath)
                            .fitCenter()
                            .into(holder.imageForBookmark)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteresViewholder {
        val view=LayoutInflater.from(parent.context)
                .inflate(R.layout.bookmark,parent,false)
        return NoteresViewholder(view);
    }

}