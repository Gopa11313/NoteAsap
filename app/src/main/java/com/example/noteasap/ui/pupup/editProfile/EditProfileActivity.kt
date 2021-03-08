package com.example.noteasap.ui.pupup.editProfile

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import com.bumptech.glide.Glide
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class EditProfileActivity : AppCompatActivity() {
    private val REQUEST_GALLERY_CODE=0;
    private val REQUEST_CAMERA_CODE=1;
    private lateinit var profile:ImageView;
    private lateinit var name:EditText;
    private lateinit var email:EditText;
    private lateinit var password:EditText;
    var imageUrl:String?=null
    private lateinit var conpassword:EditText;
    private lateinit var update: Button;
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        profile=findViewById(R.id.profile)
        name=findViewById(R.id.name)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        conpassword=findViewById(R.id.conpassword)
        update=findViewById(R.id.update)

        CoroutineScope(Dispatchers.IO).launch {
            val repository= UserRepository()
            val response=repository.getme(ServiceBuilder.id!!)
            if(response.success==true){
                val data=response.data
                val listdata= data?.get(0)
                withContext(Dispatchers.Main){
                val imageUrl=listdata!!.image
                    val imagePath = ServiceBuilder.loadImagePath() +imageUrl
                    if (!imageUrl.equals("noimg")) {
                        Glide.with(applicationContext)
                            .load(imagePath)
                            .fitCenter()
                            .into(profile)
                    }
                    name.setText("${listdata.name}")
                    email.setText("${listdata.email}")
                    password.setHint("set Password")
                }
            }
        }
    profile.setOnClickListener(){
        popup()
    }

    update.setOnClickListener(){
        val valid=validate()
        if(valid==true){
            val user = User(name = name.text.toString(), email = email.text.toString(), password = password.text.toString())
            CoroutineScope(Dispatchers.IO).launch {
                val repository = UserRepository()
                val response = repository.updateUser(user)
                if (response.success == true) {
                    val id=response.id.toString()
                    if(imageUrl != null){
                        uploadImage(id!!)
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@EditProfileActivity, "Student Added Successfully", Toast.LENGTH_SHORT).show()
                        }
                    }

                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@EditProfileActivity, "error occours", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    }
    fun validate():Boolean {
        var flag:Boolean
        val pas = password.text.toString();
        val cpass = conpassword.text.toString();
        val em =email.text.toString()
        if (em.matches(emailPattern.toRegex())) {
            if(pas==cpass){
                flag=true
            }
            else{
                Toast.makeText(this,"Password and con-password is not matched",Toast.LENGTH_LONG).show()
                flag=false
            }
        }
        else{
            Toast.makeText(this, "invalid email", Toast.LENGTH_SHORT).show()
            flag=false
        }
        return flag
    }


    private fun popup(){
        val popupMenu= PopupMenu(this,profile)
        popupMenu.menuInflater.inflate(R.menu.pmenu,popupMenu.menu)
        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.gallery -> {
                    openGallery()
                    true
                }
                R.id.camera -> {
                    openCamera()
                    true
                }
                else -> false
            }

        })
        popupMenu.show()
    }
    private fun openGallery(){
        val intent= Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent,REQUEST_GALLERY_CODE)
    }
    private fun openCamera(){
        val cameraIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent,REQUEST_CAMERA_CODE)
    }
    private fun bitmapToFile(
        bitmap: Bitmap,
        fileNameToSave: String
    ): File? {
        var file: File? = null
        return try {
            file = File(
                getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                    .toString() + File.separator + fileNameToSave
            )
            file.createNewFile()
            //Convert bitmap to byte array
            val bos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos) // YOU can also save it in JPEG
            val bitMapData = bos.toByteArray()
            //write the bytes in file
            val fos = FileOutputStream(file)
            fos.write(bitMapData)
            fos.flush()
            fos.close()
            file
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            file // it will return null
        }
    }
    private fun uploadImage(studentId: String) {
        if (imageUrl != null) {
            val file = File(imageUrl!!)
            val reqFile =
                RequestBody.create(MediaType.parse("image/${file.extension}"), file)
            val body =
                MultipartBody.Part.createFormData("file", file.name, reqFile)

            CoroutineScope(Dispatchers.IO).launch {
                try{
                    val userRepository = UserRepository()
                    val response = userRepository.uploadimage(studentId, body)
                    if (response.success == true) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@EditProfileActivity, "Uploaded", Toast.LENGTH_SHORT)
                                .show()
                            finish()
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@EditProfileActivity, "${response.msg}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@EditProfileActivity, "error", Toast.LENGTH_SHORT).show()
                        Log.d("Error uploading image ", ex.toString())
                        Toast.makeText(this@EditProfileActivity, ex.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            if(requestCode == REQUEST_GALLERY_CODE && data != null) {
                val selectedImage = data.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val contentResolver = contentResolver
                val cursor =
                    contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
                cursor!!.moveToFirst()
                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                imageUrl = cursor.getString(columnIndex)
                profile.setImageBitmap(BitmapFactory.decodeFile(imageUrl))
                cursor.close()
            }
            else if (requestCode == REQUEST_CAMERA_CODE && data != null) {
                val imageBitmap = data.extras?.get("data") as Bitmap
                val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
                val file = bitmapToFile(imageBitmap, "$timeStamp.jpg")
                imageUrl = file!!.absolutePath
                profile.setImageBitmap(BitmapFactory.decodeFile(imageUrl))
            }
        }
    }
}