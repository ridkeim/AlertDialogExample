package ru.ridkeim.alertdialogexample

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.lang.StringBuilder

class MyMultipleChoiceDialogFragment : DialogFragment(){
    private lateinit var itemNames : Array<String>
    private lateinit var selectedItems : BooleanArray
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        itemNames = activity?.resources?.getStringArray(R.array.names) as Array<String>
        selectedItems = BooleanArray(itemNames.size) {false}
        return activity?.let {
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.alert_dialog_choice_title))
                .setIcon(R.drawable.ic_launcher_foreground)
                .setMultiChoiceItems(itemNames,selectedItems,null)
                .setPositiveButton(getString(R.string.alert_dialog_ok_text)) { dialog, _ ->
                    val stringBuilder = StringBuilder()
                    for (i in itemNames.indices){
                        if (selectedItems[i]){
                            stringBuilder.append("\n${itemNames[i]}")
                        }
                    }
                    Toast.makeText(activity,
                        getString(R.string.alert_dialog_you_choose_text,stringBuilder),
                        Toast.LENGTH_SHORT
                    ).show()
                    dialog.cancel()
                }
                .setNegativeButton(getString(R.string.alert_dialog_cancel_text)) {
                        dialog, _ -> dialog.cancel()
                }
                .create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }
}