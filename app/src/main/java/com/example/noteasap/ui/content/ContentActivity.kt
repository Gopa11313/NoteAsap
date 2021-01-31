package com.example.noteasap.ui.content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.databinding.ActivityContentBinding
import com.example.noteasap.ui.adapter.CommentAdpater
import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.Comment
import com.example.noteasap.ui.thirdActivity.ThirdActivityViewModel

private lateinit var topic:TextView;
private lateinit var universityname:TextView;
private lateinit var discriotion:TextView;
private lateinit var img:ImageView;
private lateinit var commentbar:TextView;
class ContentActivity : AppCompatActivity() {
    private val listcommet=ArrayList<Comment>();
    private lateinit var recyleview: RecyclerView;
    private lateinit var contentviewModel: ContentviewModel
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
        commentbar=findViewById(R.id.commentbar)
        val intent = intent.getParcelableExtra<Bookmark>("notes")
        if (intent != null) {
            val name = intent.topic;
            val uname = intent.universityname
            val dis = intent.describption
            topic.text = name;
            universityname.text = uname;
            discriotion.text = dis
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