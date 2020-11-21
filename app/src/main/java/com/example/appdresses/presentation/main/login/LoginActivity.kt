package com.example.appdresses.presentation.main.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appdresses.R
import com.example.appdresses.presentation.main.view.MainActivityNav
import com.google.firebase.auth.FirebaseAuth
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var txtUser:EditText
    private lateinit var txtPassword:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUser=findViewById(R.id.etxt_email)
        txtPassword=findViewById(R.id.etxt_password)

        progressBar=findViewById(R.id.progressBar_signIn)
        auth= FirebaseAuth.getInstance()
    }
    fun forgotPasswordIn(view: View){
        startActivity(Intent(this,ForgotPassActivity::class.java))
    }
    fun registerIn(view: View){
        startActivity(Intent(this,RegisterActivity::class.java))
    }
    fun loginIn(view: View){
        loginUser()
    }
    //Verificacion de entrada de login
    private fun loginUser(){
        val user:String=txtUser.text.toString()
        val password:String=txtPassword.text.toString()

        if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password)){
            progressBar.visibility=View.VISIBLE

            auth.signInWithEmailAndPassword(user,password)
                .addOnCompleteListener(this){
                    task ->
                    if(task.isSuccessful){
                        action(user)
                    }else{
                        progressBar.visibility=View.GONE
                        Toast.makeText(this,"Error en la autenticacion", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun action(user:String){
        /* Esto es una manera de mandar a otro activitie algun dato
        val intent:Intent = Intent((this),MainActivityNav::class.java)
        intent.putExtra("Email",user)*/
        progressBar.visibility=View.GONE
        startActivity(Intent(this,MainActivityNav::class.java))
    }
}