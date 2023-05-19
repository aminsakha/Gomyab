package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentMyGomyabBinding
import com.example.myapplication.utils.phoneNumber
import com.example.myapplication.utils.userName

class MyGomyabFragment : Fragment() {
    private var _binding: FragmentMyGomyabBinding? = null
    private val binding get() = _binding!!
    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyGomyabBinding.inflate(layoutInflater, container, false)
        if (container != null)
            myContext = container.context

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameTV.text = userName
        binding.phoneTV.text = phoneNumber
    }
}