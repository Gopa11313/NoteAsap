package com.example.noteasap.ui.uploadNotes

import android.content.Intent
import android.database.Cursor
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.databinding.ActivityUpdateNoteBinding
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.model.OwnNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import kotlin.jvm.Throws

class UpdateNoteActivity : AppCompatActivity() {
    private val REQUEST_FILE_CODE = 0
    private var fileUrl: String? = null
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var chooseFile: Button
    private lateinit var c_name: EditText
    private lateinit var topic: EditText
    private lateinit var description: TextView
    private lateinit var Update: Button
    private lateinit var mFile: File
    lateinit var selectedFile: Uri
    lateinit var displayName:String;
    private lateinit var uploadNotesViewModel: UploadNotesViewModel
    var selectedlevel: String = ""
    var _id:String?=""
    var ratting:String?=""
    var selectedsubject: String = ""
    var namePref: String ?=null
    var level = arrayOf("University", "Masters", "Bachelors", "+2", "9/10")
    var subject = arrayOf("Science", "Management")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUpdateNoteBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_update_note
        )
        binding.lifecycleOwner = this
        uploadNotesViewModel = ViewModelProvider(this).get(UploadNotesViewModel::class.java)
        binding.uploadNoteViewModel = uploadNotesViewModel

        val sharedPref = getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
        namePref = sharedPref?.getString("name", null)
        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)
        c_name = findViewById(R.id.c_name)
        chooseFile = findViewById(R.id.chooseFile)
        topic = findViewById(R.id.topic)
        description = findViewById(R.id.desc)
        Update = findViewById(R.id.update)
        chooseFile.setOnClickListener {
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
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedlevel = parent?.getItemAtPosition(position).toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        spinner2.adapter = adapter2
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedsubject = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        Update.setOnClickListener {
            Updatenotes()
        }
        val intent = intent.getParcelableExtra<OwnNotes>("Note")
        if (intent != null) {
            val name = intent.topic;
            _id = intent._id
            val uname = intent.c_name
            val dis = intent.description
            val topi = intent.topic
            c_name.setText(uname)
            topic.setText(topi)
            description.setText(dis)
//            topic.text=name.toString()
//            description.text = dis.toString()
            fileUrl = intent.file


        }
    }

    private fun openFile() {
        var intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "application/*"
        intent = Intent.createChooser(intent, "Choose a file")
        startActivityForResult(intent, REQUEST_FILE_CODE)

    }

    fun validation(): Boolean {
        var flag: Boolean
        flag =
            c_name.text.toString() !== "" && topic.text.toString() !== "" && description.text.toString() !== ""
        return flag
    }

    fun clear() {
        c_name.setText("")
        topic.setText("")
        description.text = ""
    }

    private fun Updatenotes() {
        Toast.makeText(this, "${ServiceBuilder.id!!}", Toast.LENGTH_SHORT).show()
        val ownnote = OwnNotes(
            _id = _id,
            userId = ServiceBuilder.id!!,
            file = "nofile",
            subject = selectedsubject,
            level = selectedlevel,
            c_name = c_name.text.toString(),
            topic = topic.text.toString(),
            description = description.text.toString()
        )
        CoroutineScope(Dispatchers.IO).launch {
            val repository = NoteRepository()
            val response = repository.updateNote(ownnote)
            val res=response
            if (response.success == true) {
                if (fileUrl != null) {
                    updateFile(_id!!)
                    withContext(Dispatchers.Main) {
                        clear()
                        Toast.makeText(
                            this@UpdateNoteActivity,
                            "Student Updated Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        clear()
                        Toast.makeText(this@UpdateNoteActivity, "error here", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@UpdateNoteActivity, "here", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_FILE_CODE && data != null) {
            selectedFile = data.data!!
            data.data?.also {
                fileUrl = it.path
                mFile = importFile(it);
                chooseFile.setText("$mFile")
                chooseFile.setTextColor(Color.parseColor("#006400"))
            }
        }
    }
    //return a new file created in application cache directory
    private fun importFile(uri: Uri): File {
        val fileName: String = getFileName(uri)
        Log.i("TAGGER", "Display Name: $fileName")
        // The temp file could be whatever you want
        val directory = application.cacheDir
        val Tempfile  = File(directory,fileName);
        val fileCopy: File = copyToTempFile(uri, Tempfile)
        return fileCopy;
    }

    // return the fileName from given URI
    private fun getFileName(uri: Uri): String {
        // The query, because it only applies to a single document, returns only
        // one row. There's no need to filter, sort, or select fields,
        // because we want all fields for one document.
        val cursor: Cursor? = contentResolver.query(
            uri, null, null, null, null, null
        )
        cursor?.use {
            // moveToFirst() returns false if the cursor has 0 rows. Very handy for
            // "if there's anything to look at, look at it" conditionals.
            if (it.moveToFirst()) {

                // Note it's called "Display Name". This is
                // provider-specific, and might not necessarily be the file name.
                val fileName: String =
                    it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                displayName = fileName
            }
        }
        return displayName;
    }
    //copies the inputStream from given file to a temporary file.
    @Throws(IOException::class)
    private fun copyToTempFile(uri: Uri, tempFile: File): File {
        // Obtain an input stream from the uri
        val inputStream = contentResolver.openInputStream(uri)
            ?: throw IOException("Unable to obtain input stream from URI")
        // Copy the stream to the temp file
        FileUtils.copyInputStreamToFile(inputStream, tempFile);

        return tempFile
    }


    private fun updateFile(studentId: String) {
        val reqFile =
            RequestBody.create(MediaType.parse("file/${mFile.extension}"), mFile)
        val body =
            MultipartBody.Part.createFormData("file", mFile.name, reqFile)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = NoteRepository()
                val response = repository.uploadfile(studentId, body)
                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@UpdateNoteActivity, "Uploaded", Toast.LENGTH_SHORT)
                            .show()
                        finish()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@UpdateNoteActivity,
                            "${response.msg}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@UpdateNoteActivity, "error", Toast.LENGTH_SHORT).show()
                    Log.d("Error uploading file ", ex.toString())
                    Toast.makeText(
                        this@UpdateNoteActivity,
                        ex.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}