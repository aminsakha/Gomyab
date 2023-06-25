package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentAddAdBinding
import com.example.myapplication.utils.changeFragment

class AddAdFragment : Fragment() {
    private var _binding: FragmentAddAdBinding? = null
    private val binding get() = _binding!!
    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddAdBinding.inflate(layoutInflater, container, false)
        if (container != null)
            myContext = container.context

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lookingForBtn.setOnClickListener {
            changeFragment(binding.lookingForBtn, R.id.action_addAdFragment2_to_addINfoFragment2)
        }
        binding.finderBtn.setOnClickListener {
            changeFragment(binding.lookingForBtn, R.id.action_addAdFragment2_to_addINfoFragment2)
        }
    }
}