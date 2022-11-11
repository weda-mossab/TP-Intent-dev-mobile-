package com.example.intent_app


import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity2 : AppCompatActivity(){
    lateinit var Nom2 : TextView
    lateinit var Date2 : TextView
    lateinit var Email2 : TextView
    lateinit var Classe2 : TextView
    lateinit var Button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Nom2 = findViewById(R.id.Nom2)
        Date2 = findViewById(R.id.Date2)
        Email2= findViewById(R.id.Email2)
        Classe2= findViewById(R.id.Classe2)
        Button2 = findViewById(R.id.button2)

        val bundle = intent.extras
        if (bundle != null){
            Nom2.text = "Nom et Prenom = ${bundle.getString("Nom et Prenom")}"
            Date2.text = "Date de Naissance = ${bundle.getString("Date de Naissance")}"
            Classe2.text = "classe = ${bundle.getString("classe")}"
            Email2.text = "mail = ${bundle.getString("mail")}"
        }

        Button2.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            val title = resources.getString(R.string.app_name)
            val chooser = Intent.createChooser(intent, title)
            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(applicationContext,"succés", Toast.LENGTH_SHORT).show()
            }
        }
    }
}