package com.example.noteasap.ui.uploadNotes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.databinding.ActivityUploadNotesBinding
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.model.OwnNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


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
    var selectedlevel:String=""
    var selectedsubject:String=""

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
                selectedlevel = parent?.getItemAtPosition(position).toString();

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
            spinner2.adapter = adapter2
        spinner2.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedsubject = parent?.getItemAtPosition(position).toString();
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        submit.setOnClickListener(){
           uploadnotes()
        }
    }

        private fun openFile(){
            val intent= Intent()
                .setType("application/*")
                .setAction(Intent.ACTION_GET_CONTENT)
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
private fun uploadnotes(){
    Toast.makeText(this, "${ServiceBuilder.id!!}", Toast.LENGTH_SHORT).show()
    val ownnote=OwnNotes(
        userId = ServiceBuilder.id!!,
        file = "nofile",
        subject = selectedsubject,
        level =selectedlevel,
        c_name = c_name.text.toString(),
        topic = topic.text.toString(),
        description = description.text.toString())
    CoroutineScope(Dispatchers.IO).launch{
        val repository=NoteRepository()
        val response=repository.uploadnotes(ownnote)
        if(response.success==true){
            val id=response.id.toString()
            if(fileUrl != null){
                uploadImage(id!!)
                withContext(Dispatchers.Main) {
                    clear()
                    Toast.makeText(this@UploadNotesActivity, "Student Added Successfully", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                withContext(Dispatchers.Main) {
                    clear()
                    Toast.makeText(this@UploadNotesActivity, "error here", Toast.LENGTH_SHORT).show()
                }
            }

        }
        else{
            withContext(Main){
                Toast.makeText(this@UploadNotesActivity, "here", Toast.LENGTH_SHORT).show()
            }
        }
    }
}override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            if(requestCode == REQUEST_FILE_CODE && data != null) {
                val selectedFile = data.data
                val filePathColumn = arrayOf(MediaStore.Files.FileColumns.DATA)
                val contentResolver = contentResolver
                val cursor =
                    contentResolver.query(selectedFile!!, filePathColumn, null, null, null)
                cursor!!.moveToFirst()
                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                fileUrl = cursor.getString(columnIndex)
                chooseFile.setBackgroundColor(Color.GREEN)
                cursor.close()
            }

        }
    }
    private fun uploadImage(studentId: String) {
        if (fileUrl != null) {
            val file = File(fileUrl!!)
            val reqFile =
                RequestBody.create(MediaType.parse("file/${file.extension}"), file)
            val body =
                MultipartBody.Part.createFormData("file", file.name, reqFile)

            CoroutineScope(Dispatchers.IO).launch {
                try{
                    val studentRepository = NoteRepository()
                    val response = studentRepository.uploadfile(studentId, body)
                    if (response.success == true) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@UploadNotesActivity, "Uploaded", Toast.LENGTH_SHORT)
                                .show()
                            finish()
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@UploadNotesActivity, "${response.msg}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@UploadNotesActivity, "error", Toast.LENGTH_SHORT).show()
                        Log.d("Error uploading file ", ex.toString())
                        Toast.makeText(this@UploadNotesActivity, ex.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}