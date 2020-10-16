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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity(){

    private lateinit var etx_fullname:EditText
    private lateinit var etxt_email_register:EditText
    private lateinit var etx_pw1:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database : FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        etx_fullname=findViewById(R.id.etx_fullname)
        etxt_email_register=findViewById(R.id.etxt_email_register)
        etx_pw1=findViewById(R.id.etx_pw1)

        progressBar= findViewById(R.id.progressBar)

        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()

        dbReference=database.reference.child("User")

    }

    fun register(view:View) {
        createNewAccount()
    }

    private fun createNewAccount(){
        val name:String=etx_fullname.text.toString()
        val email:String=etxt_email_register.text.toString()
        val password:String=etx_pw1.text.toString()

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
                progressBar.visibility= View.VISIBLE

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) {
                    task ->
                    if(task.isComplete){
                        val user:FirebaseUser?=auth.currentUser
                        verifyEmail(user)

                        val userBD= dbReference.child(user?.uid!!)

                        userBD.child("Name").setValue(name)
                        action()
                    }
                }
        }
    }

    private fun action(){
        startActivity(Intent(this,LoginActivity::class.java))
    }

    private fun verifyEmail(user:FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this) {
                task ->

                if (task.isComplete){
                    Toast.makeText(this,"Email enviado", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this,"Error al enviar el email", Toast.LENGTH_LONG).show()
                }
            }
    }
}