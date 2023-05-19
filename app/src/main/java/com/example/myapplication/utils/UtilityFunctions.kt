package com.example.myapplication.utils

import android.view.View
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar

fun changeFragment(view: View, action: Int) = Navigation.findNavController(view).navigate(action)
fun showSnackbar(view: View, message: String) =
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
var userName=""
var phoneNumber=""