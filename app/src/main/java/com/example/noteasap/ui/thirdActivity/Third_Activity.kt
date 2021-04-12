package com.example.noteasap.ui.thirdActivity

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.noteasap.R
import com.example.noteasap.ui.fragments.bookmarkFragment.BookmarkBlankFragment
import com.example.noteasap.ui.fragments.homeFragment.HomeBlankFragment
import com.example.noteasap.ui.fragments.accountBlankFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class Third_Activity : AppCompatActivity(), SensorEventListener {
    private lateinit var frament_container:FrameLayout;
    private val Home= HomeBlankFragment();
    private val Bookmark= BookmarkBlankFragment();
    private val Account=accountBlankFragment();
    private lateinit var bottom_navigation:BottomNavigationView;
    private lateinit var thirdViewModel: ThirdActivityViewModel
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_)
        thirdViewModel = ViewModelProvider(this).get(ThirdActivityViewModel::class.java)
        thirdViewModel.fragment.observe(this) {
            when(thirdViewModel.getFragment()){
                ThirdActivityViewModel.Fragment.HOME ->replaceFragments(Home)
                ThirdActivityViewModel.Fragment.BOOKMARK ->replaceFragments(Bookmark)
                ThirdActivityViewModel.Fragment.ACCOUNT ->replaceFragments(Account)
            }
        }
        frament_container=findViewById(R.id.fragment_container)
        bottom_navigation=findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(){
        when(it.itemId){
            R.id.ic_home ->thirdViewModel.setFragment(ThirdActivityViewModel.Fragment.HOME)
            R.id.ic_bookmark ->thirdViewModel.setFragment(ThirdActivityViewModel.Fragment.BOOKMARK)
            R.id.ic_account ->thirdViewModel.setFragment(ThirdActivityViewModel.Fragment.ACCOUNT)
        }
        true;
    }
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        if (!checkSensor())
            return
        else {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    private fun checkSensor(): Boolean {
        var flag = true
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) == null) {
            flag = false
        }
        return flag
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val values = event!!.values[1]
//        if (values < 0)
//            replaceFragments(Bookmark)
//        else if (values > 0){
//            replaceFragments(Home)
//        }


    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    fun replaceFragments(fragment:Fragment){
        val transaction=supportFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment) //only use this here
        transaction.commit();
    }
}
