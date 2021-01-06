package com.example.noteasap.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.noteasap.LoginActivity
import com.example.noteasap.Pupup.EditProfileActivity
import com.example.noteasap.R
import com.example.noteasap.UploadNotesActivity


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class accountBlankFragment : Fragment() {
    private lateinit var account:CardView;
    private lateinit var btnlog:Button;
    private lateinit var uploadnotesframe:FrameLayout;
    private lateinit var imageviewfor3menus:ImageView;
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_blank, null);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        account=view.findViewById(R.id.ic_account)
        btnlog=view.findViewById(R.id.btnlog)
        uploadnotesframe=view.findViewById(R.id.uploadnotesframe)
        btnlog.setOnClickListener(){
            requireActivity().run{
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
        uploadnotesframe.setOnClickListener(){
            requireActivity().run{
                startActivity(Intent(this, UploadNotesActivity::class.java))
            }
        }
//        imageviewfor3menus=view.findViewById(R.id.imageView)
//        imageviewfor3menus.setOnClickListener(){
//            val popupMenu=PopupMenu(activity, it)
//            popupMenu.setOnMenuItemClickListener { iteam->
//                when(iteam.itemId){
//                    R.id.edit ->{
//                        requireActivity().run{
//                        startActivity(Intent(this,EditProfileActivity::class.java))
//                        }
//                    }
//                    R.id.message -> {
//                        requireActivity().run{
//                            startActivity(Intent(this,EditProfileActivity::class.java))
//                        }
//                    }
//                    R.id.About->{
//                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://Gopal")))
//                     true
//                    }
//                    else -> false
//                }
//                popupMenu.inflate(R.menu.menu2)
//                popupMenu.show()
//            }
//        }
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
}