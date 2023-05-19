package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentSplashBinding
import com.example.myapplication.utils.changeFragment
import com.example.myapplication.utils.phoneNumber
import com.example.myapplication.utils.showSnackbar
import com.example.myapplication.utils.userName
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        if (container != null)
            myContext = container.context

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBTN.setOnClickListener {
            userName = binding.userNameTV.editText?.text.toString()

            lifecycleScope.launch {
                //phoneNumber = read(binding.userNameTV.editText?.text.toString())!!
                if (read(binding.userNameTV.editText?.text.toString()) != null && binding.pass2TV.editText?.text.toString() == read(
                        binding.userNameTV.editText?.text.toString()
                    )
                ) {
                    changeFragment(binding.loginBTN, R.id.action_loginFragment_to_bottomNavActivity)
                } else
                    showSnackbar(binding.loginBTN, "شما نمیتوانید وارد شوید")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}