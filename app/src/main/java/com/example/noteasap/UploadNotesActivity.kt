package com.example.noteasap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import com.example.noteasap.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response


class UploadNotesActivity : AppCompatActivity() {
    private lateinit var spinner1:Spinner;
    private lateinit var spinner2:Spinner;
    private lateinit var c_name:EditText;
    private lateinit var topic:EditText;
    private lateinit var description: TextView;
    private lateinit var submit:Button;
    var selectedItem:String=""
    var level= arrayOf("University","Masters","Bachelors","+2","9/10")
    var subject= arrayOf("Science","Management")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_notes)
        spinner1=findViewById(R.id.spinner1)
        spinner2=findViewById(R.id.spinner2)
        c_name=findViewById(R.id.c_name)
        topic=findViewById(R.id.topic)
        description=findViewById(R.id.desc)
        submit=findViewById(R.id.submit)
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
                selectedItem = parent?.getItemAtPosition(position).toString();

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
            spinner2.adapter = adapter2
        spinner2.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = parent?.getItemAtPosition(position).toString();
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        submit.setOnClickListener(){
            uploadnotes()
        }
    }

    fun uploadnotes(){
        if(validation()){
            var map=HashMap<String,String>()
            map["file"]=""
            map["level"]=spinner1.selectedItem.toString()
            map["subject"]=spinner2.selectedItem.toString()
            map["c_name"]=c_name.text.toString()
            map["topic"]=topic.text.toString()
            map["description"]=description.text.toString()
            val call:Call<Void?>?=RetrofitClient.getInstance().uploadNotes(map)
            if(call!=null){
                call.enqueue(object : retrofit2.Callback<Void?> {
                    override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                        if (response.code() == 200) {
                            Toast.makeText(this@UploadNotesActivity,
                                "Upload note successfully",
                                Toast.LENGTH_SHORT).show()
                            Handler(Looper.getMainLooper()).postDelayed({
                                clear()
                            }, 1000)
                        } else {
                            Toast.makeText(this@UploadNotesActivity,
                                response.errorBody().toString(),
                                Toast.LENGTH_SHORT).show()
                        }

                    }

                    override fun onFailure(call: Call<Void?>, t: Throwable) {
                        Toast.makeText(this@UploadNotesActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }

                })
            }
        }
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

}