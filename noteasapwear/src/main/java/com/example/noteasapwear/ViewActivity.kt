package com.example.noteasapwear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.model.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewActivity : AppCompatActivity() {
    private lateinit var tvText:TextView
    var listView= arrayOfNulls<String>(10)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        tvText=findViewById(R.id.tvText)
        CoroutineScope(Dispatchers.IO).launch {
            val repository=NoteRepository()
            val response=repository.getAllNote()
            if(response.success==true){
               val  listView1=response.data
                withContext(Main){
                    tvText.setText("no of notes in system:"+listView1!!.size)
                }

            }
        }

    }
}