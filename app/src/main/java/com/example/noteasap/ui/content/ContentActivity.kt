package com.example.noteasap.ui.content

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.databinding.ActivityContentBinding
import com.example.noteasap.repository.BookmarkRepository
import com.example.noteasap.ui.adapter.CommentAdpater
import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.Comment
import com.example.noteasap.ui.model.OwnNotes
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ContentActivity : AppCompatActivity() {
    private val listcommet=ArrayList<Comment>();
    private lateinit var recyleview: RecyclerView;
    private lateinit var bookamark: ImageView;
    private lateinit var contentviewModel: ContentviewModel
    private lateinit var topic:TextView;
    private lateinit var ratingBar1:RatingBar
    private lateinit var universityname:TextView;
    private lateinit var discriotion:TextView;
    private lateinit var img:ImageView;
    private  lateinit var layout: ConstraintLayout;
    private lateinit var commentbar:TextView;
    var noteid:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binnding:ActivityContentBinding=DataBindingUtil.setContentView(this,R.layout.activity_content)
        binnding.lifecycleOwner=this
        contentviewModel=ViewModelProvider(this).get(ContentviewModel::class.java)
        binnding.contentViewModel=contentviewModel
        topic = findViewById(R.id.topic)
        universityname = findViewById(R.id.Universityname)
        discriotion = findViewById(R.id.dis);
        recyleview=findViewById(R.id.recycler_view1)
        img=findViewById(R.id.comment)
        layout=findViewById(R.id.layout)
        ratingBar1=findViewById(R.id.ratingBar1)
        bookamark=findViewById(R.id.bookmark)
        commentbar=findViewById(R.id.commentbar)
        CoroutineScope(Dispatchers.IO).launch {
            val repository=BookmarkRepository()
            val response=repository.getParticularNote(noteid!!)
            if(response.success==true){
                withContext(Main){
                    bookamark.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext, // Context
                            R.drawable.ic_star_orange // Drawable
                        ))
                }
            }
        }

        bookamark.setOnClickListener(){
            val builder= AlertDialog.Builder(this);
            builder.setMessage("Do you want bookmarked this note.")
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("Yes"){dialogInterface,which->
                CoroutineScope(Dispatchers.IO).launch {
                    val repository=BookmarkRepository()
                    val response= repository.BookamarkNote(Bookmark(noteId = noteid, userId = ServiceBuilder.id!!))
                    if (response.success==true){
                        withContext(Dispatchers.Main){
                            val snack=  Snackbar.make(layout,"${response.msg}", Snackbar.LENGTH_SHORT)
                            snack.setAction("Ok") {
                                snack.dismiss()
                            }
                            snack.show()
                        }
                    }
                    else{
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@ContentActivity, "error occur", Toast.LENGTH_SHORT).show()
                        }
                    }


                }
            }
            builder.setNegativeButton("No"){
                    dialogInterface,which->
            }
            val alertDialog: AlertDialog =builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
            bookamark.setImageDrawable(
                ContextCompat.getDrawable(
                applicationContext, // Context
                R.drawable.ic_star_orange // Drawable
            ))
        }

        /////-------------double click on bookamrk imagebutoon----------//
//        bookamark.setOnClickListener(object : DoubleClickListener() {
//            override fun onDoubleClick(v: View?) {
//                Toast.makeText(applicationContext,"Double Click",Toast.LENGTH_SHORT).show()
//            }
//        })



        val intent = intent.getParcelableExtra<OwnNotes>("notes")
        if (intent != null) {
            val name = intent.topic;
            noteid=intent._id
            val uname = intent.c_name
            val dis = intent.description
            val ratting=intent.ratting
            topic.text = name.toString()
            universityname.text = uname.toString()
            discriotion.text = dis.toString()
            if(ratting!==null) {
                ratingBar1.setRating(ratting!!.toFloat())
            }
        }
        loadcomment()
        val adapter=CommentAdpater(listcommet,this)
        recyleview.layoutManager= LinearLayoutManager(this)
        recyleview.adapter=adapter
    }
    private fun loadcomment(){
        listcommet.add(Comment(1,12,"Vector","This is go damn good","13"))
        listcommet.add(Comment(11,112,"Smith","This is average","14"))
        listcommet.add(Comment(111,1112,"neps","really good","133"))
        listcommet.add(Comment(1,12,"Vector","This is go damn good","13"))
    }
}


/////////---double click class-----------------------/////////
//abstract class DoubleClickListener : View.OnClickListener {
//    var lastClickTime: Long = 0
//    override fun onClick(v: View?) {
//        val clickTime = System.currentTimeMillis()
//        if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
//            onDoubleClick(v)
//        }
//        lastClickTime = clickTime
//    }
//
//    abstract fun onDoubleClick(v: View?)
//
//    companion object {
//        private const val DOUBLE_CLICK_TIME_DELTA: Long = 300 //milliseconds
//    }
//}