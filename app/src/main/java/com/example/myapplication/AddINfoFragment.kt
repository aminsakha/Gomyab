package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.view.children
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentAddINfoBinding
import com.example.myapplication.db.AddAd
import com.example.myapplication.utils.changeFragment
import com.example.myapplication.utils.showBeautifulAlertDialog
import com.example.myapplication.utils.showSnackbar
import kotlinx.coroutines.launch

class AddINfoFragment : Fragment() {
    private var checkBoxRes = ""
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
        for (i in 0 until binding.linl.childCount) {
            val child = binding.linl.getChildAt(i)
            if (child is CheckBox) {
                child.setOnClickListener {
                    if (child.isChecked)
                        checkBoxRes = child.text.toString()
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.goNextBTN.setOnClickListener {
            lifecycleScope.launch {
                db!!.adDao().deleteAllAdds()
                db!!.adDao().addAdd(
                    AddAd(
                        label,
                        binding.provinceTB.editText!!.text.toString(),
                        binding.cityTB.editText!!.text.toString(),
                        binding.areaTB.editText!!.text.toString(),
                        binding.dateTB.editText!!.text.toString(),
                        checkBoxRes
                    )
                )
                showBeautifulAlertDialog(
                    requireContext(),
                    "ثبت آگهی با موفقیت انجام شد",
                    "در صورت پیدا شدن موردی مشابه به شما اطلاع خواهیم داد",
                    "باشه"
                ) {
                    changeFragment(
                        binding.goNextBTN,
                        R.id.action_addINfoFragment2_to_addAdFragment2
                    )
                }
            }
        }
    }
}