package ru.ridkeim.alertdialogexample

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MySingleChoiceDialogFragment : DialogFragment() {
    private lateinit var itemNames : Array<String>
    private var selectedItem : Int = -1
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        itemNames = activity?.resources?.getStringArray(R.array.names) as Array<String>
        return activity?.let {
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.alert_dialog_choice_title))
                .setIcon(R.drawable.ic_launcher_foreground)
                .setSingleChoiceItems(itemNames,selectedItem){ _, which ->
                    selectedItem = which
                }
                .setPositiveButton(getString(R.string.alert_dialog_ok_text)) { dialog, id ->
                    if(selectedItem in itemNames.indices) {
                        Toast.makeText(activity,
                            getString(R.string.alert_dialog_you_choose_text, itemNames[selectedItem]),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    dialog.cancel()
                }
                .setNegativeButton(getString(R.string.alert_dialog_cancel_text)) {
                        dialog, _ -> dialog.cancel()
                }
                .create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }
}