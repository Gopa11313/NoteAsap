package com.example.noteasap.ui.forgetPassword

import android.annotation.SuppressLint
import android.content.Intent
import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.noteasap.R
import com.example.noteasap.databinding.FragmentForgetpasswordBinding
import com.example.noteasap.ui.login.LoginActivity


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ForgetpasswordFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var sendbtn:Button;
    private lateinit var Femail:EditText;
    private lateinit var forgetPasswordViewModel: ForgetPasswordViewModel
    private lateinit var binding:FragmentForgetpasswordBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        binding= FragmentForgetpasswordBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_forgetpassword,
            container,
            false
        )
        Log.i("ForgetPasswordFragment", "Called ViewModelProvider.get")
        forgetPasswordViewModel = ViewModelProvider(this).get(ForgetPasswordViewModel::class.java)
        binding.lifecycleOwner = this
        binding.forgetPasswordViewModel = forgetPasswordViewModel
//        forgetPasswordViewModel.forgetemail.observe(for)
        binding.Femail.text
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendbtn=view.findViewById(R.id.sendbtn);
        sendbtn.setOnClickListener(){
            toast();
            nextact();//// yaha arko activity ko method ni use gaar haiii taw
        }
    }
    companion object {

        fun newInstance(param1: String, param2: String) =
            ForgetpasswordFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    @SuppressLint("WrongConstant")
    fun toast(){
        val toast = Toast.makeText(
                activity, "Please Check Your Email.", 4000
        )
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
    fun nextact(){
        requireActivity().run{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}