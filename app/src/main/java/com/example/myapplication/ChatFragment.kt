package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.api.ApiService
import com.example.myapplication.api.PostRequestBody
import com.example.myapplication.api.SkyroomApi
import com.example.myapplication.databinding.FragmentChatBinding
import com.example.myapplication.db.User
import com.example.myapplication.utils.userName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
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

      val BASE_URL = "https://www.skyroom.online/"

        val api: SkyroomApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SkyroomApi::class.java)
        }

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
                        Log.d("onViewCreated", "onViewCreated peyda kardde: $users")
                        if (users.size < 2)
                            delay(3000)
                        else {
                            binding.isTherChatTB.visibility=View.INVISIBLE
                            binding.cardChat.visibility=View.VISIBLE
                            binding.nameOfUserOfChat.text = users[1].name
                            val postRequestBody = PostRequestBody(
                                action = "createLoginUrl",
                                params = mapOf(
                                    "room_id" to 1,
                                    "user_id" to "t1",
                                    "nickname" to "t1",
                                    "access" to 3,
                                    "concurrent" to 1,
                                    "language" to "en",
                                    "ttl" to 3600
                                )
                            )
                            val postResponse = api.postRequest(postRequestBody).awaitResponse()
                            if (postResponse.isSuccessful) {
                                val result = postResponse.body()?.result as? String
                                Log.d("MainActivity", "POST Result: $result")
                            }
                            break
                        }
                        }
                    }catch (e: Exception) { }
                }
            }
        }
    }
    fun test(){
        CoroutineScope(Dispatchers.IO).launch {
//            val getResponse = RetrofitInstance.api.getResponse().awaitResponse()
//            if (getResponse.isSuccessful) {
//                val result = getResponse.body()?.result
//                Log.d("MainActivity", "GET Result: $result")
//            }


    }
}