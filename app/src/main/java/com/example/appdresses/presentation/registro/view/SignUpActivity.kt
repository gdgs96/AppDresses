package com.example.appdresses.presentation.registro.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.appdresses.base.BaseActivity
import com.example.appdresses.domain.interactor.registerinteractor.SignUpInteractorImpl
import com.example.appdresses.presentation.registro.SignUpContract
import com.example.appdresses.presentation.registro.presenter.SignUpPresenter
import com.example.appdresses.R
import com.example.appdresses.presentation.main.view.MainActivityNav
import kotlinx.android.synthetic.main.activity_reg.*

class SignUpActivity : BaseActivity(),SignUpContract.SignUpView {

    lateinit var presenter:SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SignUpPresenter(SignUpInteractorImpl())
        presenter.attachView(this)


        btn_signUp.setOnClickListener {
            signUp()
        }

    }

    override fun getLayout(): Int {
        return R.layout.activity_reg
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivityNav::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun signUp() {
        val fullname:String = etx_fullname.text.toString().trim()
        val email:String = etxt_email_register.text.toString().trim()
        val pw1:String = etx_pw1.text.toString().trim()
        val pw2:String = etx_pw2.text.toString().trim()

        if (presenter.checkEmptyName(fullname)){
            etx_fullname.error = "El nombre esta vacío"
            return
        }
        if (!presenter.checkValidEmail(email)){
            etxt_email_register.error = "El correo es invalido"
            return
        }
        if (presenter.checkEmptyPasswords(pw1,pw2)){
            etx_pw1.error = "Campo vacio"
            etx_pw2.error = "Campo vacio"
            return
        }
        if (!presenter.checkPasswordsMatch(pw1, pw2)){
            etx_pw1.error = "Las contraseñas no son iguales"
            etx_pw2.error = "Las contraseñas no son iguales"
            return
        }
        presenter.signUp(fullname,email,pw1)

    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        btn_signUp.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        btn_signUp.visibility = View.VISIBLE
    }

    override fun showError(errormsg: String) {
        toast(this,errormsg)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
