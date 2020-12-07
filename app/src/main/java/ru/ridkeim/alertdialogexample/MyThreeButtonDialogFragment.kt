package ru.ridkeim.alertdialogexample

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyThreeButtonDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setMessage(getString(R.string.alert_dialog_three_buttons_message))
                .setIcon(R.drawable.ic_launcher_foreground)
                .setPositiveButton(getString(R.string.alert_dialog_positive_text)) { dialog, _ ->
                    dialog.cancel()
                }
                .setNegativeButton(getString(R.string.alert_dialog_negative_text)) { dialog, _ ->
                    dialog.cancel()
                }
                .setNeutralButton(getString(R.string.alert_dialog_neutral_text)){dialog,_->
                    dialog.cancel()
                }
                .create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }
}