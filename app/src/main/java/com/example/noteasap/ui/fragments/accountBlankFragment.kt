package com.example.noteasap.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.example.noteasap.ImageUploadActivity
import com.example.noteasap.ui.login.LoginActivity
import com.example.noteasap.ui.pupup.editProfile.EditProfileActivity
import com.example.noteasap.ui.pupup.message.MessageActivity
import com.example.noteasap.R
import com.example.noteasap.RoomDatabase.NoteAsapDb
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.repository.UserRepository
import com.example.noteasap.ui.adapter.OwnNotesAdpater
import com.example.noteasap.ui.model.Notes
import com.example.noteasap.ui.model.OwnNotes
import com.example.noteasap.ui.uploadNotes.UploadNotesActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class accountBlankFragment : Fragment() {
    private val REQUEST_GALLERY_CODE=0;
    private val REQUEST_CAMERA_CODE=1;
    private var imageUrl:String?=null;
    private lateinit var account:CardView;
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var uploadnotesframe:FrameLayout;
    private lateinit var imageviewfor3menus:ImageView;
    private lateinit var imagebtn:ImageView;
    private lateinit var btnlog:ImageButton;
    private lateinit var imagebtn2:ImageView;
    private var listNotes:MutableList<OwnNotes>?=null;
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
        swipeRefreshLayout =view.findViewById(R.id.swipe)
        imagebtn=view.findViewById(R.id.imagebtn)
        btnlog=view.findViewById(R.id.btnlog)
        imagebtn2=view.findViewById(R.id.imabtn2)

        CoroutineScope(Dispatchers.IO).launch {
            val repository=UserRepository()
            val response=repository.getme(ServiceBuilder.id!!)
            if(response.success==true){
                val data=response.data
                val listdata= data?.get(0)
                imageUrl=listdata!!.image
                withContext(Main){

                    val imagePath = ServiceBuilder.loadImagePath() +imageUrl
                    if (!imageUrl.equals("noimg")) {
                        Glide.with(requireActivity())
                            .load(imagePath)
                            .fitCenter()
                            .into(imagebtn)
                    }
                }
            }
        }



        btnlog.setOnClickListener(){
            val builder= AlertDialog.Builder(requireContext());
            builder.setMessage("Do you want logout")
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("Yes"){dialogInterface,which->
                            val sharedPref =requireActivity().getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
                            val editor=sharedPref.edit()
                            editor.remove("email")
                            editor.remove("password")
                            editor.remove("_id")
                            editor.remove("name")
                                .apply()
                            CoroutineScope(Dispatchers.IO).launch{
                                NoteAsapDb.getInstance(requireContext()).getUserDao().logout()
                                withContext(Main){
                                    startActivity(Intent(context,LoginActivity::class.java))
                                }
                            }
            }
            builder.setNegativeButton("No"){
                    dialogInterface,which->
            }
            builder.show()

        }


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
                            val intent = Intent(context, EditProfileActivity::class.java)
//                            intent.putExtra("listNotes",listNotes as ArrayList<OwnNotes>)
                            context?.startActivity(intent);
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
        getvalues()


        swipeRefreshLayout.setOnRefreshListener() {
            CoroutineScope(Dispatchers.IO).launch {
                val repository=UserRepository()
                val response=repository.getme(ServiceBuilder.id!!)
                if(response.success==true){
                    val data=response.data
                    val listdata= data?.get(0)
                    imageUrl=listdata!!.image
                    withContext(Main){

                        val imagePath = ServiceBuilder.loadImagePath() +imageUrl
                        if (!imageUrl.equals("noimg")) {
                            Glide.with(requireActivity())
                                .load(imagePath)
                                .fitCenter()
                                .into(imagebtn)
                        }
                    }
                }
            }
            Handler().postDelayed(Runnable {
                swipeRefreshLayout.isRefreshing = false
            }, 2000)
        }
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

    }
    private fun popup(){
        val popupMenu= PopupMenu(context,imagebtn)
        popupMenu.menuInflater.inflate(R.menu.pmenu2,popupMenu.menu)
        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.update_image -> {
                    requireActivity().run{
                        startActivity(Intent(this, ImageUploadActivity::class.java))
                    }
                    true
                }
                else -> false
            }

        })
        popupMenu.show()
    }
    private fun gotoAnotherFragment(){

    }


    fun getvalues() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val repository= NoteRepository()
                val response=repository.getOwnNotes(ServiceBuilder.id!!);
                listNotes= response.data!!
                if(response.success==true) {
                    context?.let { NoteAsapDb.getInstance(it).getOwnNotes().droptable() }
                    context?.let { NoteAsapDb.getInstance(it).getOwnNotes().RegisterNote(listNotes) }
                    val list= context?.let { NoteAsapDb.getInstance(it).getOwnNotes().getAllNote() }
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "this is recycle", Toast.LENGTH_SHORT).show()
                        val reversedLits=list!!.asReversed()
                        val adpater= context?.let { OwnNotesAdpater(list as ArrayList<OwnNotes>, it) }
                        recyleview.layoutManager = LinearLayoutManager(activity)
                        recyleview.adapter=adpater;
                    }
                }
                else{
                    withContext(Dispatchers.Main){
                        Toast.makeText(context, "data is empty", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        } catch (e: IOException) {
            Toast.makeText(context, "Error ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }

    }

}