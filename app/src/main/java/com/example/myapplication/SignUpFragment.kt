package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentSignUpBinding
import com.example.myapplication.utils.changeFragment
import com.example.myapplication.utils.phoneNumber
import com.example.myapplication.utils.showSnackbar
import com.example.myapplication.utils.userName
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        if (container != null)
            myContext = container.context

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signBTN.setOnClickListener {
            userName = binding.userNameTV2.editText?.text.toString()
            phoneNumber = binding.idNumberTvSignUp.editText?.text.toString()
            lifecycleScope.launch {
                save(
                    binding.idNumberTvSignUp.editText?.text.toString(),
                    binding.passTV.editText?.text.toString()
                )
                showSnackbar(binding.signBTN, "شما با موفقیت ثبت نام شدید")
                changeFragment(binding.signBTN, R.id.action_signUpFragment_to_bottomNavActivity)
            }
        }
    }
}