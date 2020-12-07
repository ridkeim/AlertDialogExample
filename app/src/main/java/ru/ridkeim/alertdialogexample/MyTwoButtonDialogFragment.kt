package ru.ridkeim.alertdialogexample

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyTwoButtonDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.alert_dialog_two_button_title))
                .setMessage(getString(R.string.alert_dialog_two_button_message))
                .setIcon(R.drawable.ic_launcher_foreground)
                .setPositiveButton(getString(R.string.alert_dialog_ok_text)) { _, _ ->
                    Toast.makeText(activity,"Вы сделали правильный выбор", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(getString(R.string.alert_dialog_cancel_text)) { _, _ ->
                    Toast.makeText(activity,"Возможно вы правы", Toast.LENGTH_SHORT).show()
                }
                .create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }
}