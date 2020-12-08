package ru.ridkeim.alertdialogexample

import android.app.Dialog
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyRatingDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val layoutInflater = requireActivity().layoutInflater
            val dialogView = layoutInflater.inflate(R.layout.rating_bar, null)
            val ratingBar = dialogView.findViewById<RatingBar>(R.id.rating_bar)
            val dialogBuilder = AlertDialog.Builder(it)
                .setTitle(getString(R.string.rating_title))
                .setMessage(getString(R.string.rating_message))
                .setView(dialogView)
                .setPositiveButton(getString(R.string.alert_dialog_ok_text)) { dialog, _ ->
                    val rating = ratingBar.rating
                    val numStars = ratingBar.numStars
                    Toast.makeText(requireContext(),"оценка: $rating/$numStars",Toast.LENGTH_SHORT).show()
                    dialog.cancel()
                }
                .setNegativeButton(getString(R.string.alert_dialog_cancel_text)) { dialog,_ ->
                    dialog.cancel()
                }
            dialogBuilder.create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }
}