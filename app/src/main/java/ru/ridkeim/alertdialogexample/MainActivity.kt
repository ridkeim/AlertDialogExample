package ru.ridkeim.alertdialogexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity(),MyCustomDialogFragment.NoticeDialogListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener {
            MyDialogFragment().show(supportFragmentManager,"myDialog")
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            MyTwoButtonDialogFragment().show(supportFragmentManager,"myTwoButtonsDialog")
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            MyThreeButtonDialogFragment().show(supportFragmentManager,"myThreeButtonsDialog")
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            MyListDialogFragment().show(supportFragmentManager,"myListDialog")
        }
        findViewById<Button>(R.id.button5).setOnClickListener {
            MySingleChoiceDialogFragment().show(supportFragmentManager,"mySingleChooseDialog")
        }
        findViewById<Button>(R.id.button6).setOnClickListener {
            MyMultipleChoiceDialogFragment().show(supportFragmentManager,"myMultipleChooseDialog")
        }
        findViewById<Button>(R.id.button7).setOnClickListener {
            MyRatingDialogFragment().show(supportFragmentManager,"myRatingDialog")
        }
        findViewById<Button>(R.id.button8).setOnClickListener {
            val myCustomDialogFragment = MyCustomDialogFragment()
            myCustomDialogFragment.show(supportFragmentManager,"myCustomDialog")
        }

    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        Toast.makeText(this,"CustomDialogPositive",Toast.LENGTH_SHORT).show()
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Toast.makeText(this,"CustomDialogNegative",Toast.LENGTH_SHORT).show()

    }
}