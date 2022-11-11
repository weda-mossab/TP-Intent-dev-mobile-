package com.example.alertdialog

import android.app.ProgressDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val nom = findViewById<EditText>(R.id.nom)
        val prenom = findViewById<EditText>(R.id.prenom)
        val email = findViewById<EditText>(R.id.email)

        button.setOnClickListener {
            val ad = AlertDialog.Builder(this)
            if (nom.length() == 0 || prenom.length() == 0 || email.length() == 0) {
                ad.setMessage("Les champs ne doivent pas être vide");
                ad.setTitle("Error");
                ad.setIcon(android.R.drawable.btn_dialog);
                ad.setPositiveButton("yes") { dialogInterface, which ->
                    Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
                }
                ad.show()
            }
        }

    }
}