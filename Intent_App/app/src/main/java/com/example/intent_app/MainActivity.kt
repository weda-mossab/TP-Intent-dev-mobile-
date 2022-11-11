package com.example.intent_app


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var nom: EditText
    lateinit var date: EditText
    lateinit var email: EditText
    lateinit var classe: EditText
    lateinit var button: Button
    lateinit var main: ConstraintLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nom = findViewById(R.id.nom)
        date = findViewById(R.id.date)
        email = findViewById(R.id.email)
        classe = findViewById(R.id.classe)
        main = findViewById(R.id.main)
        button = findViewById(R.id.button)

        date.setOnClickListener {
            val C = Calendar.getInstance()
            //declaration
            val YY = C.get(Calendar.YEAR)
            val MM = C.get(Calendar.MONTH)
            val DD = C.get(Calendar.DAY_OF_MONTH)
            //Function
            val datePickerDialog = DatePickerDialog(
                this,
                { view, YY, MM, DD ->
                    val DATE = (MM.toString() + "-" + (MM + 1) + "-" + YY)
                    date.setText(DATE)
                }, YY, MM, DD
            )
            datePickerDialog.show()
        }

        button.setOnClickListener {
            val Name = nom.text.toString()
            val Date = date.text.toString()
            val Email = email.text.toString()
            val Classe = classe.text.toString()
            val bundle = Bundle()
            
            bundle.putString("étudiant : ",Name)
            bundle.putString("Date de Naissance : ", Date)
            bundle.putString("Classe : ", Classe)
            bundle.putString("Email : ", Email)


            if (TextUtils.isEmpty(Name) || TextUtils.isEmpty(Date) || TextUtils.isEmpty(Email) || TextUtils.isEmpty(Classe)) {
                Toast.makeText(applicationContext, "Champ vide", Toast.LENGTH_SHORT).show()
                val snackbar = Snackbar.make(main, "Veuillez remplire tous les champs", Snackbar.LENGTH_LONG)
                snackbar.show()

            }

            else {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Vous devez confirmer les données enregistrées?")
                builder.setTitle("Alert")
                builder.setCancelable(false)
                builder.setPositiveButton("Yes") {
                        dialog, which ->
                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                builder.setNegativeButton("No") {
                        dialog, which ->
                    dialog.cancel()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }
    }
}