package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentAddINfoBinding
import com.example.myapplication.databinding.FragmentLandingBinding
import com.example.myapplication.db.AddAd
import com.example.myapplication.utils.showSnackbar

class AddINfoFragment : Fragment() {
    private var _binding: FragmentAddINfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddINfoBinding.inflate(layoutInflater, container, false)
        if (container != null)
            myContext = container.context

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goNextBTN.setOnClickListener {
            db!!.adDao().addAdd(
                AddAd(
                    binding.provinceTB.editText!!.text.toString(),
                    binding.cityTB.editText!!.text.toString(),
                    binding.areaTB.editText!!.text.toString(),
                    binding.dateTB.editText!!.text.toString(),
                    checkBoxRes
                )
            )
        }
    }
}