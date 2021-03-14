package com.example.noteasap.ui.uploadNotes

import android.content.Intent
import android.database.Cursor
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.databinding.ActivityUploadNotesBinding
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.model.Notes
import com.example.noteasap.ui.notification.NotificationChannels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.apache.commons.io.FileUtils.copyInputStreamToFile
import java.io.File
import java.io.IOException
import kotlin.jvm.Throws


class UploadNotesActivity : AppCompatActivity() {
    private val REQUEST_FILE_CODE = 0
    private var fileUrl: String? = null
    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var chooseFile: Button
    private lateinit var c_name: EditText
    private lateinit var topic: EditText
    private lateinit var description: TextView
    private lateinit var submit: Button
    private lateinit var mFile: File
    lateinit var selectedFile: Uri
    lateinit var displayName:String;
    private lateinit var uploadNotesViewModel: UploadNotesViewModel
    var selectedlevel: String = ""
    var selectedsubject: String = ""
    var namePref: String ?=null
    var level = arrayOf("University", "Masters", "Bachelors", "+2", "9/10")
    var subject = arrayOf("Science", "Management")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUploadNotesBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_upload_notes
        )
        binding.lifecycleOwner = this
        uploadNotesViewModel = ViewModelProvider(this).get(UploadNotesViewModel::class.java)
        binding.uploadNoteViewModel = uploadNotesViewModel

        val sharedPref =getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
        namePref = sharedPref?.getString("name", null)
        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)
        c_name = findViewById(R.id.c_name)
        chooseFile = findViewById(R.id.chooseFile)
        topic = findViewById(R.id.topic)
        description = findViewById(R.id.desc)
        submit = findViewById(R.id.submit)
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
        submit.setOnClickListener {
            uploadnotes()
            showHighPriorityNotification()
//            showLowPriorityNotification()
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

    private fun uploadnotes() {
        Toast.makeText(this, "${ServiceBuilder.id!!}", Toast.LENGTH_SHORT).show()
        val ownnote = Notes(
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
            val response = repository.uploadnotes(ownnote)
            if (response.success == true) {
                val id = response.id.toString()
                if (fileUrl != null) {
                    uploadImage(id)
                    withContext(Dispatchers.Main) {
                        clear()
                        Toast.makeText(
                            this@UploadNotesActivity,
                            "Student Added Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        clear()
                        Toast.makeText(this@UploadNotesActivity, "error here", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                withContext(Main) {
                    Toast.makeText(this@UploadNotesActivity, "here", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

//------------notification----------------//
private fun showHighPriorityNotification(){
    val notificationManager= NotificationManagerCompat.from(this)

    val notificationChannels= NotificationChannels(this)
    notificationChannels.createNotificationChannels()

    val notification= NotificationCompat.Builder(this,notificationChannels.CHANNEL_1)
        .setSmallIcon(R.drawable.ic_baseline_sms_24)
        .setContentTitle(namePref)
        .setContentText("Uploaded ${topic.text.toString()} note.")
        .setColor(Color.BLUE)
        .build()
    notificationManager.notify(1,notification)
}

    private fun showLowPriorityNotification(){
        val notificationManager= NotificationManagerCompat.from(this)
        val notificationChannels=NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification= NotificationCompat.Builder(this,notificationChannels.CHANNEL_2)
            .setSmallIcon(R.drawable.ic_baseline_sms_24)
            .setContentTitle(namePref)
            .setContentText("Uploaded ${topic.text.toString()} note.")
            .setColor(Color.BLUE)
            .build()
        notificationManager.notify(2,notification)
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
    private fun importFile(uri: Uri):File {
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
        copyInputStreamToFile(inputStream, tempFile);

        return tempFile
    }


    private fun uploadImage(studentId: String) {
        val reqFile =
            RequestBody.create(MediaType.parse("file/${mFile.extension}"), mFile)
        val body =
            MultipartBody.Part.createFormData("file", mFile.name, reqFile)

        CoroutineScope(Dispatchers.IO).launch {
            try {
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
                        Toast.makeText(
                            this@UploadNotesActivity,
                            "${response.msg}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@UploadNotesActivity, "error", Toast.LENGTH_SHORT).show()
                    Log.d("Error uploading file ", ex.toString())
                    Toast.makeText(
                        this@UploadNotesActivity,
                        ex.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}