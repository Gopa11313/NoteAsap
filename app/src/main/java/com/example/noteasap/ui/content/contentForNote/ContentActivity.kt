package com.example.noteasap.ui.content.contentForNote

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.noteasap.R
import com.example.noteasap.RoomDatabase.NoteAsapDb
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.databinding.ActivityContentBinding
import com.example.noteasap.repository.BookmarkRepository
import com.example.noteasap.repository.CommentRepository
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.adapter.CommentAdpater
import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.Comment
import com.example.noteasap.ui.model.Notes
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ContentActivity : AppCompatActivity() {
    private var listcommet:List<Comment>?=null;
    private lateinit var recyleview: RecyclerView;
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var bookamark: ImageView;
    private lateinit var contentviewModel: ContentviewModel
    private lateinit var topic:TextView;
    private lateinit var ratingBar1:RatingBar
    private lateinit var universityname:TextView;
    private lateinit var discriotion:TextView;
    private lateinit var download:Button;
    private lateinit var img:ImageView;
    private lateinit var comment:ImageView;
    private  lateinit var layout: ConstraintLayout;
    private lateinit var commentbar:TextView;
    var rattingNum:Int?=null
    var ratting:Int?=null
    var noteid:String?=null
    var fileUrl:String?=null
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
        download=findViewById(R.id.download)
        swipeRefreshLayout =findViewById(R.id.swipe)
        layout=findViewById(R.id.layout)
        ratingBar1=findViewById(R.id.ratingBar1)
        bookamark=findViewById(R.id.bookmark)
        commentbar=findViewById(R.id.commentbar)
        comment=findViewById(R.id.comment)

        comment.setOnClickListener(){
CoroutineScope(Dispatchers.IO).launch {
    val repository=CommentRepository()
    val response=repository.commentNote(Comment(userId = ServiceBuilder.id!!,noteId = noteid,comment = commentbar.text.toString()))
    if(response.success==true){
        withContext(Main){
            commentbar.setText("")
            val snack=  Snackbar.make(layout,"${response.msg}. Swipe Down to refresh", Snackbar.LENGTH_SHORT)
            snack.setAction("Ok") {
                snack.dismiss()
            }
            snack.show()

        }
    }
    else{
        withContext(Main){
            Toast.makeText(this@ContentActivity, "error", Toast.LENGTH_SHORT).show()
        }
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
        download.setOnClickListener(){
            val request=DownloadManager.Request(Uri.parse(fileUrl))
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            request.setTitle("Download")
            request.setDescription("The File is Dowloading............")
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${System.currentTimeMillis()}")

            val manager=getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            manager.enqueue(request)
        }

        /////-------------double click on bookamrk imagebutoon----------//
//        bookamark.setOnClickListener(object : DoubleClickListener() {
//            override fun onDoubleClick(v: View?) {
//                Toast.makeText(applicationContext,"Double Click",Toast.LENGTH_SHORT).show()
//            }
//        })


        swipeRefreshLayout.setOnRefreshListener() {

            Handler().postDelayed(Runnable {
                loadcomment()
                if(ratting!==null) {
                    ratingBar1.setRating(ratting!!.toFloat())
                }
                swipeRefreshLayout.isRefreshing = false
            }, 2000)
        }

        val intent = intent.getParcelableExtra<Notes>("notes")
        if (intent != null) {
            val name = intent.topic;
            noteid=intent._id
            val uname = intent.c_name
            val dis = intent.description
            ratting= intent.ratting
            topic.text = name.toString()
            universityname.text = uname.toString()
            discriotion.text = dis.toString()
            rattingNum=intent.noofRating
            fileUrl=intent.file
            if(ratting!==null) {
                ratingBar1.setRating(ratting!!.toFloat())
            }
        }
        loadcomment()


        ratingBar1.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { p0, p1, p2 ->
//                val numofRat=rattingNum!!+1
//                val actualRating=p1.toInt()+ratting!!
//                val rat=(actualRating)/(numofRat)
                Toast.makeText(this@ContentActivity, "Given rating is: $p1 ", Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    val repository=NoteRepository()
                    val response=repository.RateNote(noteid!!,p1.toString(),3.toString())
                    if(response.success==true){
                        withContext(Main){
                            val snack=  Snackbar.make(layout,"${response.msg}", Snackbar.LENGTH_SHORT)
                            snack.setAction("Ok") {
                                snack.dismiss()
                            }
                            snack.show()
                        }

                    }

                }
            }
//        ratingBar1.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
//            val rate=ratingBar1.rating.toString()
//            Toast.makeText(this, "$rate", Toast.LENGTH_SHORT).show()
//        CoroutineScope(Dispatchers.IO).launch {
//            val repository=NoteRepository()
//            val response=repository.RateNote(OwnNotes(_id = noteid,ratting = 3,noofRating = 1))
//            if(response.success==true){
//            val snack=  Snackbar.make(layout,"${response.msg}", Snackbar.LENGTH_SHORT)
//            snack.setAction("Ok") {
//                snack.dismiss()
//            }
//            snack.show()
//            }
//
//        }

//        }

    }

    private fun loadcomment(){
    CoroutineScope(Dispatchers.IO).launch {
        val repository=CommentRepository()
        val response=repository.getComment(noteid!!)
        if(response.success==true)
            listcommet=response.data
            NoteAsapDb.getInstance(this@ContentActivity).getCommentDao().droptable()
            NoteAsapDb.getInstance(this@ContentActivity).getCommentDao().CommentNote(listcommet)
            val listCommentFromRoom=NoteAsapDb.getInstance(this@ContentActivity).getCommentDao().getComment()
        withContext(Main){
            val adapter=CommentAdpater(listCommentFromRoom as ArrayList<Comment>,this@ContentActivity)
            recyleview.layoutManager= LinearLayoutManager(this@ContentActivity)
            recyleview.adapter=adapter
        }
    }
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