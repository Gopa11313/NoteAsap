package com.example.noteasap.ui.uploadNotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.databinding.ActivityUploadNotesBinding
import retrofit2.Call
import retrofit2.Response


class UploadNotesActivity : AppCompatActivity() {
    private val REQUEST_FILE_CODE=0;
    private var fileUrl:String?=null;
    private lateinit var spinner1:Spinner;
    private lateinit var spinner2:Spinner;
    private lateinit var chooseFile:Button;
    private lateinit var c_name:EditText;
    private lateinit var topic:EditText;
    private lateinit var description: TextView;
    private lateinit var submit:Button;
    private lateinit var uploadNotesViewModel: UploadNotesViewModel
    var selectedItem:String=""
    var level= arrayOf("University","Masters","Bachelors","+2","9/10")
    var subject= arrayOf("Science","Management")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityUploadNotesBinding=DataBindingUtil.setContentView(this,R.layout.activity_upload_notes)
        binding.lifecycleOwner=this
        uploadNotesViewModel=ViewModelProvider(this).get(UploadNotesViewModel::class.java)
        binding.uploadNoteViewModel=uploadNotesViewModel
        spinner1=findViewById(R.id.spinner1)
        spinner2=findViewById(R.id.spinner2)
        c_name=findViewById(R.id.c_name)
        chooseFile=findViewById(R.id.chooseFile)
        topic=findViewById(R.id.topic)
        description=findViewById(R.id.desc)
        submit=findViewById(R.id.submit)
        chooseFile.setOnClickListener(){
            openFile()
        }
            val adapter1 = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    level
            )
        val adapter2 = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                subject
        )
        spinner1.adapter = adapter1
        spinner1.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = parent?.getItemAtPosition(position).toString();

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
            spinner2.adapter = adapter2
        spinner2.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = parent?.getItemAtPosition(position).toString();
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        submit.setOnClickListener(){
           // uploadnotes()
        }
    }

        private fun openFile(){
            val intent= Intent(Intent.ACTION_PICK)
            intent.type="file/*"
            startActivityForResult(intent,REQUEST_FILE_CODE)

    }
    fun validation():Boolean{
        var flag=false;
        flag = c_name.text.toString()!==""&&topic.text.toString()!==""&&description.text.toString()!==""
        return flag
    }
    fun clear(){
        c_name.setText("")
        topic.setText("")
        description.setText("")
    }

}