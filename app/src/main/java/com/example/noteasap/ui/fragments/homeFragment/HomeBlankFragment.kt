package com.example.noteasap.ui.fragments.homeFragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.noteasap.R
import com.example.noteasap.RoomDatabase.NoteAsapDb
import com.example.noteasap.databinding.FragmentHomeBlankBinding
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.adapter.HomeAdapter
import com.example.noteasap.ui.model.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeBlankFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    var listStudent:List<Notes>?=null
    private lateinit var recyclehome:RecyclerView;
    private lateinit var search:AutoCompleteTextView;
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var homeFragmetViewModel: HomeFragmetViewModel
    private lateinit var binding:FragmentHomeBlankBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        binding= FragmentHomeBlankBinding.inflate(layoutInflater)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
       binding=DataBindingUtil.inflate(inflater,
       R.layout.fragment_home_blank,
       container,
       false)
        Log.i("HomeFragment","called viewmodelProvider.get")
        homeFragmetViewModel=ViewModelProvider(this).get(HomeFragmetViewModel::class.java)
        binding.lifecycleOwner=this
        binding.homeFragmentViewModel=homeFragmetViewModel
        binding.search.text
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclehome=view.findViewById(R.id.recyclehome);
        search=view.findViewById(R.id.search)
        swipeRefreshLayout =view.findViewById(R.id.swipe)
        getvalues()
        recyclehome.setHasFixedSize(true);
        swipeRefreshLayout.setOnRefreshListener() {
            Handler().postDelayed(Runnable {
                getvalues()
                swipeRefreshLayout.isRefreshing = false
            }, 2000)
        }

    }
    fun getvalues() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val repository=NoteRepository()
                val response=repository.getAllNote();
                if(response.success==true) {
                    listStudent=response.data
                    context?.let { NoteAsapDb.getInstance(it).getNoteDao().droptable() }
                    context?.let { NoteAsapDb.getInstance(it).getNoteDao().RegisterNote(listStudent) }
                    val list= context?.let { NoteAsapDb.getInstance(it).getNoteDao().getAllNote() }
                    withContext(Dispatchers.Main) {
                       //val reversedLits=list!!.asReversed()
                        val adpater= context?.let { HomeAdapter(list as ArrayList<Notes>, it) }
                        recyclehome.layoutManager = LinearLayoutManager(activity)
                        recyclehome.adapter=adpater;
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
    companion object {
        fun newInstance(param1: String, param2: String) =
            HomeBlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}