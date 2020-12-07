package ru.ridkeim.alertdialogexample

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.alert_dialog_title))
                .setMessage(getString(R.string.alert_dialog_message))
                .setIcon(R.drawable.ic_launcher_foreground)
                .setPositiveButton(getString(R.string.alert_dialog_ok_text)) { dialog, _ ->
                    dialog.cancel()
                }.create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }
}