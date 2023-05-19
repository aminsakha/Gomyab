package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentLandingBinding
import com.example.myapplication.databinding.FragmentSplashBinding
import com.example.myapplication.utils.changeFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LandingFragment : Fragment() {
    private var _binding: FragmentLandingBinding? = null
    private val binding get() = _binding!!
    private lateinit var myContext: Context
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLandingBinding.inflate(layoutInflater, container, false)
        if (container != null)
            myContext = container.context

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBTN.setOnClickListener {
            changeFragment(binding.loginBTN, R.id.action_landingFragment_to_loginFragment)
        }
        binding.signUpBTN.setOnClickListener {
            changeFragment(binding.signUpBTN, R.id.action_landingFragment_to_signUpFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}