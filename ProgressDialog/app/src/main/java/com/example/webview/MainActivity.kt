package com.example.webview

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressbtn = findViewById<Button>(R.id.progrssbtn)
        val nom = findViewById<EditText>(R.id.nom)
        val prenom = findViewById<EditText>(R.id.prenom)
        val email = findViewById<EditText>(R.id.email)

        progressbtn.setOnClickListener {
            val progress = ProgressDialog(this)
            progress.setMessage("Downloading Music")
            progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); progress.setIndeterminate(true)
            progress.setProgress(0)
            progress.show()
        }
    }
}


























