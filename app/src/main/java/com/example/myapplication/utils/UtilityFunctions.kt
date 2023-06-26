package com.example.myapplication.utils

import android.content.Context
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar

fun changeFragment(view: View, action: Int) = Navigation.findNavController(view).navigate(action)
fun showSnackbar(view: View, message: String) =
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()

fun showBeautifulAlertDialog(
    context: Context,
    title: String,
    message: String,
    positiveButtonText: String,
    onPositiveButtonClick: () -> Unit,
) {
    val builder = AlertDialog.Builder(context)
    builder.setTitle(title)
    builder.setMessage(message)

    // Set the positive button text and click listener
    builder.setPositiveButton(positiveButtonText) { dialog, _ ->
        onPositiveButtonClick()
        dialog.dismiss()
    }

    // Create and show the alert dialog
    val dialog = builder.create()
    dialog.show()
}
var userName=""
var phoneNumber=""