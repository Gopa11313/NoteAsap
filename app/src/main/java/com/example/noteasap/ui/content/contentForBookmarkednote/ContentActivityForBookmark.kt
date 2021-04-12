package com.example.noteasap.ui.content.contentForBookmarkednote

import android.app.DownloadManager
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.noteasap.R
import com.example.noteasap.RoomDatabase.NoteAsapDb
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.BookmarkRepository
import com.example.noteasap.repository.CommentRepository
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.adapter.CommentAdpater
import com.example.noteasap.ui.content.contentForNote.ContentviewModel
import com.example.noteasap.ui.model.BookMarkNotes
import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.Comment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContentActivityForBookmark : AppCompatActivity(), SensorEventListener {
    private var listcommet:List<Comment>?=null;
    private lateinit var recyleview: RecyclerView;
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var bookamark: ImageView;
    private lateinit var contentviewModel: ContentviewModel
    private lateinit var topic: TextView;
    private lateinit var ratingBar1: RatingBar
    private lateinit var universityname: TextView;
    private lateinit var discriotion: TextView;
    private lateinit var img: ImageView;
    private lateinit var download: Button;
    private lateinit var comment: ImageView;
    private  lateinit var layout: ConstraintLayout;
    private lateinit var commentbar: TextView;

    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null
    var rattingNum:Int?=null
    var ratting:Int?=null
    var noteid:String?=null
    var fileUrl:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_for_bookmark)
//        val binnding: ActivityContentBinding = DataBindingUtil.setContentView(this,R.layout.activity_content_for_bookmark)
//        binnding.lifecycleOwner=this
//        contentviewModel= ViewModelProvider(this).get(ContentviewModel::class.java)
//        binnding.contentViewModel=contentviewModel
        topic = findViewById(R.id.topic)
        universityname = findViewById(R.id.Universityname)
        discriotion = findViewById(R.id.dis);
        recyleview=findViewById(R.id.recycler_view1)
        download=findViewById(R.id.download)
        img=findViewById(R.id.comment)
        swipeRefreshLayout =findViewById(R.id.swipe)
        layout=findViewById(R.id.layout)
        ratingBar1=findViewById(R.id.ratingBar1)
        bookamark=findViewById(R.id.bookmark)
        commentbar=findViewById(R.id.commentbar)
        comment=findViewById(R.id.comment)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        if (!checkSensor())
            return
        else {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        comment.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                val repository= CommentRepository()
                val response=repository.commentNote(Comment(userId = ServiceBuilder.id!!,noteId = noteid,comment = commentbar.text.toString()))
                if(response.success==true){
                    withContext(Dispatchers.Main){
                        commentbar.setText("")
                        val snack=  Snackbar.make(layout,"${response.msg}. Swipe Down to refresh", Snackbar.LENGTH_SHORT)
                        snack.setAction("Ok") {
                            snack.dismiss()
                        }
                        snack.show()

                    }
                }
                else{
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@ContentActivityForBookmark, "error", Toast.LENGTH_SHORT).show()
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
                    val repository= BookmarkRepository()
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
                            Toast.makeText(this@ContentActivityForBookmark, "error occur", Toast.LENGTH_SHORT).show()
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
            val request= DownloadManager.Request(Uri.parse(ServiceBuilder.loadImagePath() +fileUrl))
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            request.setTitle("Download")
            request.setDescription("The File is Downloading............")
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${System.currentTimeMillis()}")
            val manager=getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            manager.enqueue(request)
        }
        swipeRefreshLayout.setOnRefreshListener() {
            Handler().postDelayed(Runnable {
                loadcomment()
                if(ratting!==null) {
                    ratingBar1.setRating(ratting!!.toFloat())
                }
                swipeRefreshLayout.isRefreshing = false
            }, 2000)
        }
        ratingBar1.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { p0, p1, p2 ->
                val numofRat=rattingNum!!+1
                val actualRating=p1.toInt()+ratting!!
                val rat=(actualRating)/(numofRat)
                Toast.makeText(this@ContentActivityForBookmark, "Given rating is: $p1 ", Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    val repository=NoteRepository()
                    val response=repository.RateNote(noteid!!,rat.toString(),numofRat.toString())
                    if(response.success==true){
                        withContext(Dispatchers.Main){
                            val snack=  Snackbar.make(layout,"${response.msg}", Snackbar.LENGTH_SHORT)
                            snack.setAction("Ok") {
                                snack.dismiss()
                            }
                            snack.show()
                        }

                    }

                }
            }

        /////-------------double click on bookamrk imagebutoon----------//
//        bookamark.setOnClickListener(object : DoubleClickListener() {
//            override fun onDoubleClick(v: View?) {
//                Toast.makeText(applicationContext,"Double Click",Toast.LENGTH_SHORT).show()
//            }
//        })




        val intent = intent.getParcelableExtra<BookMarkNotes>("notes")
        if (intent != null) {
            val name = intent.topic;
            noteid=intent._id
            val uname = intent.c_name
            val dis = intent.description
            ratting=intent.ratting
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
        swipeRefreshLayout.setOnRefreshListener() {
            Handler().postDelayed(Runnable {
                loadcomment()
                if(ratting!==null) {
                    ratingBar1.setRating(ratting!!.toFloat())
                }
                swipeRefreshLayout.isRefreshing = false
            }, 2000)
        }

    }

    private fun loadcomment(){
        CoroutineScope(Dispatchers.IO).launch {
            val repository= CommentRepository()
            val response=repository.getComment(noteid!!)
            if(response.success==true)
                listcommet=response.data
            NoteAsapDb.getInstance(this@ContentActivityForBookmark).getCommentDao().droptable()
            NoteAsapDb.getInstance(this@ContentActivityForBookmark).getCommentDao().CommentNote(listcommet)
            val listCommentFromRoom= NoteAsapDb.getInstance(this@ContentActivityForBookmark).getCommentDao().getComment()
            withContext(Dispatchers.Main){
                val adapter= CommentAdpater(listCommentFromRoom as ArrayList<Comment>,this@ContentActivityForBookmark)
                recyleview.layoutManager= LinearLayoutManager(this@ContentActivityForBookmark)
                recyleview.adapter=adapter
            }
        }
    }
    private fun checkSensor(): Boolean {
        var flag = true
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null) {
            flag = false
        }
        return flag
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val values = event!!.values[0]
        if(values<=4)
            loadcomment()
//            swipeRefreshLayout.setOnRefreshListener() {
//                Handler().postDelayed(Runnable {
//                    loadcomment()
//                    swipeRefreshLayout.isRefreshing = false
//                }, 2000)
//            }
        else {
//            swipeRefreshLayout.isRefreshing = false;
//            swipeRefreshLayout.isEnabled = false;
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}
