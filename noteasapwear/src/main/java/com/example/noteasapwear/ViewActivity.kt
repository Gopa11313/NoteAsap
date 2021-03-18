package com.example.noteasapwear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.model.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewActivity : AppCompatActivity() {
    private lateinit var recipe_list_view:ListView
    var listView= arrayOfNulls<String>(10)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        recipe_list_view=findViewById(R.id.recipe_list_view)
        CoroutineScope(Dispatchers.IO).launch {
            val repository=NoteRepository()
            val response=repository.getAllNote()

            if(response.success==true){
               val  listView1=response.data
//                listView= arrayOfNulls<String>(listView1!!.size)
                for (i in listView1!!.indices){
                    val title=listView1[i]
                    listView = arrayOf(title.topic)

                }
            }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listView)
        recipe_list_view.adapter = adapter
    }
}