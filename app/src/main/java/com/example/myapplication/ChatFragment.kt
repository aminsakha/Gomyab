package com.example.myapplication

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.api.ApiService
import com.example.myapplication.databinding.FragmentAddINfoBinding
import com.example.myapplication.databinding.FragmentChatBinding
import com.example.myapplication.db.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatFragment : Fragment() {
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(layoutInflater, container, false)
        if (container != null)
            myContext = container.context

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://64996e1979fbe9bcf83f3c40.mockapi.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        binding.isTherChatTB.visibility=View.VISIBLE
        lifecycleScope.launch {
            if (label == "گم کرده")
                try {
                    while (true) {
                        val users = apiService.getUsers()
                        Log.d("onViewCreated", "onViewCreated: $users")
                        if (users.isEmpty())
                            delay(3000)
                        else {
                            binding.isTherChatTB.visibility=View.INVISIBLE
                            binding.cardChat.visibility=View.VISIBLE
                            binding.nameOfUserOfChat.text = users[0].name
                            val user = User(hashCode().toString(), userName)
                            apiService.addUser(user)
                            break
                        }
                    }
                } catch (e: Exception) {
                }
            else if (label == "پیدا کرده"){
                try {
                    val user = User(hashCode().toString(), userName)
                    apiService.addUser(user)

                    while (true) {
                        val users = apiService.getUsers()
                        Log.d("onViewCreated", "onViewCreated: $users")
                        if (users.size < 2)
                            delay(3000)
                        else {
                            binding.isTherChatTB.visibility=View.INVISIBLE
                            binding.cardChat.visibility=View.VISIBLE
                            binding.nameOfUserOfChat.text = users[1].name
                            break
                        }
                    }
                } catch (e: Exception) {
                }
            }
        }
    }
}