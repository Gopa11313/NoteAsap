package com.example.noteasap.ui.ownnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.RoomDatabase.NoteAsapDb
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.adapter.OwnNotesAdpater
import com.example.noteasap.ui.model.OwnNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OwnNotesActivity : AppCompatActivity() {
    private lateinit var ownNotesRecycle:RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_own_notes)
        ownNotesRecycle=findViewById(R.id.ownNotesRecycle)
        getvalues()
    }
    fun getvalues(){
        CoroutineScope(Dispatchers.IO).launch{
            val repository=NoteRepository()
            val response=repository.getOwnNotes(ServiceBuilder.id!!)
            if(response.success==true) {
                val listNotes=response.data!!
                 NoteAsapDb.getInstance(this@OwnNotesActivity).getOwnNotes().droptable()
                 NoteAsapDb.getInstance(this@OwnNotesActivity).getOwnNotes().RegisterNote(listNotes)
                val list=  NoteAsapDb.getInstance(this@OwnNotesActivity).getOwnNotes().getAllNote()
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@OwnNotesActivity, "this is recycle", Toast.LENGTH_SHORT).show()
                    val reversedLits=list!!.asReversed()
                    val adpater= OwnNotesAdpater(list as ArrayList<OwnNotes>,this@OwnNotesActivity)
                    ownNotesRecycle.layoutManager= LinearLayoutManager(this@OwnNotesActivity)
                    ownNotesRecycle.adapter=adpater;
                }
            }
            else{
                withContext(Dispatchers.Main){
                    Toast.makeText(this@OwnNotesActivity, "data is empty", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}