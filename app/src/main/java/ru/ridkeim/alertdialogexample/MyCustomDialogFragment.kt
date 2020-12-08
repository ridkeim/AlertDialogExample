package ru.ridkeim.alertdialogexample

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.lang.ClassCastException

class MyCustomDialogFragment : DialogFragment() {
    lateinit var listener : NoticeDialogListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            listener = context as NoticeDialogListener
        } catch (e : ClassCastException){
            throw ClassCastException("${context.toString()} mus implement NoticeDialogListener interface")
        }
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val layoutInflater = requireActivity().layoutInflater
            val dialogView = layoutInflater.inflate(R.layout.dialog_custom, null)

            val dialogBuilder = AlertDialog.Builder(it)
                .setView(dialogView)
                .setPositiveButton(getString(R.string.alert_dialog_ok_text)) { dialog, _ ->
                    listener.onDialogPositiveClick(this)
                    dialog.cancel()
                }
                .setNegativeButton(getString(R.string.alert_dialog_cancel_text)) { dialog,_ ->
                    listener.onDialogNegativeClick(this)
                    dialog.cancel()
                }
            dialogBuilder.create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }

    interface NoticeDialogListener{
        fun onDialogPositiveClick(dialog: DialogFragment)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }
}