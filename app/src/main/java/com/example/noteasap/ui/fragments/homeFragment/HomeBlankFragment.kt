package com.example.noteasap.ui.fragments.homeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.databinding.FragmentHomeBlankBinding
import com.example.noteasap.ui.adapter.HomeAdapterval
import com.example.noteasap.ui.model.Home
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeBlankFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private val listPosts=ArrayList<Home>();
    private lateinit var recyclehome:RecyclerView;
    private lateinit var search:AutoCompleteTextView;
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
//        homeFragmetViewModel.autocmptText.observe(viewLifecycleOwner, Observer {text->
//            binding.search.text=text.toString()
//        })


//        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
//            binding.scoreText.text = newScore.toString()
//
//        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclehome=view.findViewById(R.id.recyclehome);
        search=view.findViewById(R.id.search)
        loadvlaue()
        val adpater= context?.let { HomeAdapterval(listPosts, it) }
        recyclehome.setHasFixedSize(true);
        recyclehome.layoutManager = GridLayoutManager(activity,2)
        recyclehome.adapter=adpater;
    }
    private fun loadvlaue(){
        listPosts.add(Home(1,2,"Coventry university","IT","This is note"))
        listPosts.add(Home(101,201,"Trivuban university ","Physics","This is note"))
        listPosts.add(Home(1001,2001,"Coventry university ","Chemistry","This is note"))

        listPosts.add(Home(1,2,"Coventry university ","IT","This is note"))
        listPosts.add(Home(101,201,"Trivuban university ","Physics","This is note"))
        listPosts.add(Home(1001,2001,"Coventry university ","Chemistry","This is note"))

        listPosts.add(Home(1,2,"Coventry university ","IT","This is note"))
        listPosts.add(Home(101,201,"Trivuban university ","Physics","This is note"))
        listPosts.add(Home(1001,2001,"Coventry university ","Chemistry","This is note"))
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