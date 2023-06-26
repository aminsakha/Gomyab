package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentAddAdBinding
import com.example.myapplication.databinding.FragmentMyAdsBinding
import com.example.myapplication.utils.changeFragment
import kotlinx.coroutines.launch

class MyAdsFragment : Fragment() {
    private var _binding: FragmentMyAdsBinding? = null
    private val binding get() = _binding!!
    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyAdsBinding.inflate(layoutInflater, container, false)
        if (container != null)
            myContext = container.context

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            try {
                binding.titleOfAd.text = db!!.adDao().getAllAdds()[0].label
                binding.dateOfAd.text = db!!.adDao().getAllAdds()[0].date
            }catch (e:IndexOutOfBoundsException){}

        }
        binding.itemCardView.setOnClickListener {
            changeFragment(it,R.id.action_myAdsFragment_to_detailFragment)
        }
    }
}