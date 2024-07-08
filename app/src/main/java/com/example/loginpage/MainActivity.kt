package com.example.loginpage

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var lastName:EditText;
    lateinit var email:EditText
    lateinit var name:EditText;
    lateinit var buton:Button;
    lateinit var pass:EditText
    lateinit var context:Context


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        context = applicationContext
        email = findViewById(R.id.email);
        name = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        pass = findViewById(R.id.password)
        buton = findViewById(R.id.loginButton)



        buton.setOnClickListener{
            var file:File = File(context.filesDir,"Logins.txt")
            saveInfo(file)
        }

    }

    fun saveInfo( file: File){
        var mail = email.text.toString();
        var nume = name.text.toString()
        var prenume = lastName.text.toString()
        var pasw = pass.text.toString()
        var fileWriter = WriteText(nume,mail,prenume,pasw);
        var nr:Int = fileWriter.writeInFile(file);

        if (nr == -1)
            Toast.makeText(this,"NotSavedData",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this,"SavedData",Toast.LENGTH_SHORT).show()
    }



}