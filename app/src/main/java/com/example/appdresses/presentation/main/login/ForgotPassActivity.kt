package com.example.appdresses.presentation.main.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_pass.*

class ForgotPassActivity : AppCompatActivity() {

    private lateinit var etxt_email_register: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        etxt_email_register=findViewById(R.id.txtEmailF)
        auth=FirebaseAuth.getInstance()
        progressBar= findViewById(R.id.progressBar_signIn)
    }
    fun send(view: View){
        val email=etxt_email_register.text.toString()

        if (!TextUtils.isEmpty(email)){
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this){
                    task ->

                    if (task.isSuccessful){
                        progressBar.visibility=View.VISIBLE
                        startActivity(Intent(this, LoginActivity::class.java))
                    }else{
                        Toast.makeText(this,"Error en la autenticacion", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
