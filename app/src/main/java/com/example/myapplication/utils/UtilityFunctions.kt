package com.example.myapplication.utils

import android.view.View
import androidx.navigation.Navigation

fun changeFragment(view: View, action: Int) = Navigation.findNavController(view).navigate(action)