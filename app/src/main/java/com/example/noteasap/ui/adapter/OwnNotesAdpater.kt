package com.example.noteasap.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.RoomDatabase.NoteAsapDb
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.login.LoginActivity
import com.example.noteasap.ui.model.Notes
import com.example.noteasap.ui.model.OwnNotes
import com.example.noteasap.ui.uploadNotes.UpdateNoteActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OwnNotesAdpater(val listpost:ArrayList<OwnNotes>,
                      val context: Context):RecyclerView.Adapter<OwnNotesAdpater.OwnnotesviewHolder>() {

    class OwnnotesviewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val t_name: TextView;
        val u_name: TextView;
        val list_item:ConstraintLayout;
        val deletenote:ImageView
        val updatenote:ImageView
        init {
            t_name = view.findViewById(R.id.topic)
            u_name = view.findViewById(R.id.Uname)
            list_item=view.findViewById(R.id.list_item)
            deletenote=view.findViewById(R.id.deleteNote)
            updatenote=view.findViewById(R.id.updateNote)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OwnnotesviewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.ownnotes,parent,false)
        return OwnNotesAdpater.OwnnotesviewHolder(view)
    }

    override fun onBindViewHolder(holder: OwnnotesviewHolder, position: Int) {
        val post=listpost[position]
        holder.list_item.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.trans)
        holder.t_name.text=post.topic
        holder.u_name.text=post.c_name
    holder.deletenote.setOnClickListener(){
        val builder= AlertDialog.Builder(context);
        builder.setMessage("Are you sure You Want to delete this ${post.topic} named Note?")
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("Yes"){dialogInterface,which->
            CoroutineScope(Dispatchers.IO).launch{
                val repository=NoteRepository()
                val response=repository.deleteNote(post._id!!)
                notifyDataSetChanged()
                if(response.success==true)
                withContext(Dispatchers.Main){
                    Toast.makeText(context, "${response.msg}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        builder.setNegativeButton("No"){
                dialogInterface,which->
        }
        builder.show()
    }
        holder.updatenote.setOnClickListener(){
            val intent=Intent(context,UpdateNoteActivity::class.java)
            intent.putExtra("Note",post)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listpost.size
    }
}