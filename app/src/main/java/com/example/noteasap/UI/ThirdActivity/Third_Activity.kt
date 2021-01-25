package com.example.noteasap.UI.ThirdActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.R
import com.example.noteasap.UI.fragments.BookmarkBlankFragment
import com.example.noteasap.UI.fragments.HomeFragment.HomeBlankFragment
import com.example.noteasap.UI.fragments.accountBlankFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class Third_Activity : AppCompatActivity() {
    private lateinit var frament_container:FrameLayout;
    private val Home= HomeBlankFragment();
    private val Bookmark= BookmarkBlankFragment();
    private val Account=accountBlankFragment();
    private lateinit var bottom_navigation:BottomNavigationView;
    private lateinit var thirdViewModel: thirdActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_)
        thirdViewModel = ViewModelProvider(this).get(thirdActivityViewModel::class.java)
        thirdViewModel.fragment.observe(this,{

            when(thirdViewModel.getFragment()){
                thirdActivityViewModel.Fragment.HOME ->replaceFragments(Home)
                thirdActivityViewModel.Fragment.BOOKMARK ->replaceFragments(Bookmark)
                thirdActivityViewModel.Fragment.ACCOUNT ->replaceFragments(Account)
            }
        })
        frament_container=findViewById(R.id.fragment_container)
        bottom_navigation=findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(){
        when(it.itemId){
            R.id.ic_home ->thirdViewModel.setFragment(thirdActivityViewModel.Fragment.HOME)
            R.id.ic_bookmark ->thirdViewModel.setFragment(thirdActivityViewModel.Fragment.BOOKMARK)
            R.id.ic_account ->thirdViewModel.setFragment(thirdActivityViewModel.Fragment.ACCOUNT)
        }
        true;
    }
    }
    fun replaceFragments(fragment:Fragment){
        if(fragment!=null){
            val transaction=supportFragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container,fragment) //only use this here
            transaction.commit();
        }
    }
}
