package com.example.noteasap.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.ContentActivity
import com.example.noteasap.R
import com.example.noteasap.ui.model.Bookmark
import android.content.Intent as Intent

class BookmarkAdpater(
        val listbookmark:ArrayList<Bookmark>,
        val context: Context):RecyclerView.Adapter<BookmarkAdpater.NoteresViewholder>() {
         class NoteresViewholder(view:View):RecyclerView.ViewHolder(view){
            val universityname:TextView;
             val topic:TextView;
             val description:TextView;
             init {
                 universityname=view.findViewById(R.id.Uname)
                 topic=view.findViewById(R.id.topic)
                 description=view.findViewById(R.id.discription)
             }
         }

    override fun getItemCount(): Int {
        return listbookmark.size
        }

    override fun onBindViewHolder(holder: NoteresViewholder, position: Int) {
        val notes=listbookmark[position]
        holder.universityname.text=notes.universityname;
        holder.topic.text=notes.topic;
        holder.description.text=notes.describption
        holder.universityname.setOnClickListener(){
            val intent = Intent(context, ContentActivity::class.java)
            intent.putExtra("notes",notes)
            context.startActivity(intent);
        }
        holder.topic.setOnClickListener() {
            val intent = Intent(context, ContentActivity::class.java)
            intent.putExtra("notes",notes)
            context.startActivity(intent);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteresViewholder {
        val view=LayoutInflater.from(parent.context)
                .inflate(R.layout.bookmark,parent,false)
        return NoteresViewholder(view);
    }

}