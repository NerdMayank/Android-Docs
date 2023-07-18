package com.example.dialogueboxes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogueboxes.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            val builder1= MaterialAlertDialogBuilder(this)
            builder1.setTitle("Are You Sure?")
            builder1.setMessage("Do You want to Close the App?")
            builder1.setIcon(R.drawable.ic_baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
//                What action should be performed when yes is clicked
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
//                What action should be performed when no is clicked

            })
            builder1.show()

        }
        binding.btn2.setOnClickListener {
            val options= arrayOf("Gulab Jamun","Rasmalai","Kaju Katli")
            val builder2= AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder2.show()
        }

    }
}