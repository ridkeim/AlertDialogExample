package ru.ridkeim.alertdialogexample

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyListDialogFragment : DialogFragment() {
    private lateinit var itemNames : Array<String>
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        itemNames = activity?.resources?.getStringArray(R.array.names) as Array<String>
        return activity?.let {
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.alert_dialog_choice_title))
                .setIcon(R.drawable.ic_launcher_foreground)
                .setItems(itemNames){ _, which ->
                    Toast.makeText(activity,
                        getString(R.string.alert_dialog_you_choose_text, itemNames[which]),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .setPositiveButton(getString(R.string.alert_dialog_ok_text)) { dialog, _ -> dialog.cancel()
                }
                .setNegativeButton(getString(R.string.alert_dialog_cancel_text)) {
                        dialog, _ -> dialog.cancel()
                }
                .create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }
}