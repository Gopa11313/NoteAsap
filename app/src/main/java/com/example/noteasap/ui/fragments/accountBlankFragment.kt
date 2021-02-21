package com.example.noteasap.ui.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.ui.login.LoginActivity
import com.example.noteasap.ui.pupup.editProfile.EditProfileActivity
import com.example.noteasap.ui.pupup.message.MessageActivity
import com.example.noteasap.R
import com.example.noteasap.ui.adapter.OwnNotesAdpater
import com.example.noteasap.ui.model.OwnNotesval
import com.example.noteasap.ui.uploadNotes.UploadNotesActivity
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class accountBlankFragment : Fragment() {
    private val REQUEST_GALLERY_CODE=0;
    private val REQUEST_CAMERA_CODE=1;
    private var imageUrl:String?=null;
    private lateinit var account:CardView;
    private lateinit var uploadnotesframe:FrameLayout;
    private lateinit var imageviewfor3menus:ImageView;
    private lateinit var imagebtn:ImageView;
    private lateinit var imagebtn2:ImageView;
    private val listNotes=ArrayList<OwnNotesval>();
    private lateinit var recyleview: RecyclerView;
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account_blank, null);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        account=view.findViewById(R.id.ic_account)
        uploadnotesframe=view.findViewById(R.id.uploadnotesframe)
        recyleview=view.findViewById(R.id.recycler_view)
        imagebtn=view.findViewById(R.id.imagebtn)
        imagebtn2=view.findViewById(R.id.imabtn2)
        imagebtn2.setOnClickListener(){
        popup()
        }
        imagebtn.setOnClickListener(){
        popup()
        }
        uploadnotesframe.setOnClickListener(){
            requireActivity().run{
                startActivity(Intent(this, UploadNotesActivity::class.java))
            }
        }
        imageviewfor3menus=view.findViewById(R.id.imageView)
        imageviewfor3menus.setOnClickListener(){
            val popupMenu=PopupMenu(activity, it)
            popupMenu.menuInflater.inflate(R.menu.menu2,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { iteam->
                when(iteam.itemId){
                    R.id.edit ->{
                        requireActivity().run{
                        startActivity(Intent(this, EditProfileActivity::class.java))
                        }
                        true
                    }
                    R.id.message -> {
                        requireActivity().run{
                            startActivity(Intent(this, MessageActivity::class.java))
                        }
                        true
                    }
                    R.id.About->{
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://Gopal")))
                     true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }

        loadvlaue()
        val adpater= context?.let { OwnNotesAdpater(listNotes, it) }
        recyleview.setHasFixedSize(true);
        recyleview.layoutManager = LinearLayoutManager(activity)
        recyleview.adapter=adpater;
    }
    companion object {
        fun newInstance(param1: String, param2: String) =
            accountBlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun loadvlaue(){
        listNotes.add(OwnNotesval(1,2,"Coventry university ","Not Aviable now","IT","This is note"))
        listNotes.add(OwnNotesval(101,201,"Trivuban university ","Not Aviable now","Physics","This is note"))
        listNotes.add(OwnNotesval(1001,2001,"Coventry university ","Not Aviable now","Chemistry","This is note"))

        listNotes.add(OwnNotesval(1,2,"Coventry university ","Not Aviable now","IT","This is note"))
        listNotes.add(OwnNotesval(101,201,"Trivuban university ","Not Aviable now","Physics","This is note"))
        listNotes.add(OwnNotesval(1001,2001,"Coventry university ","Not Aviable now","Chemistry","This is note"))
    }
    private fun popup(){
        val popupMenu= PopupMenu(context,imagebtn)
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
        val intent=Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent,REQUEST_GALLERY_CODE)
    }
    private fun openCamera(){
        val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent,REQUEST_CAMERA_CODE)
    }
    private fun bitmapToFile(
        bitmap: Bitmap,
        fileNameToSave: String
    ): File? {
        var file: File? = null
        return try {
            file = File(
                activity?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
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
}