package com.example.appdresses.presentation.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.appdresses.R
import com.example.appdresses.base.BaseActivity
import com.example.appdresses.domain.interactor.logininteractor.SignInInteractorImpl
import com.example.appdresses.presentation.login.LoginContract
import com.example.appdresses.presentation.login.presenter.LoginPresenter
import com.example.appdresses.presentation.main.view.MainActivityNav
import com.example.appdresses.presentation.registro.view.SignUpActivity
import kotlinx.android.synthetic.main.activity_main.*

open class LoginActivity : BaseActivity(),
    LoginContract.LoginView {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(SignInInteractorImpl())
        presenter.attachView(this)
        //setContentView(R.layout.activity_main)
        /*textView.text = "HOLA A"
        textView.setOnClickListener {
            startActivity<DetailActivity>("text" to "Hola desde Anko")
        }*/
        btn_signIn.setOnClickListener {
            signIn()
        }
        txt_signUp.setOnClickListener {
            navigateToRegister()
        }
    }
    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun showError(msgError: String) {
        toast(this, msgError)
    }

    override fun showProgressBar() {
        progressBar_signIn.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        progressBar_signIn.visibility = View.GONE
    }

    override fun signIn() {
        val email = etxt_email.text.toString().trim()
        val password = etxt_password.text.toString().trim()
        if (presenter.checkEmptyFields(email, password))toast(this,"Uno o ambos campos estan vacíos")
        else presenter.signInUserWithEmailAndPassword(email,password)

    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivityNav::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

    }

    override fun navigateToRegister() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    override fun navigateToLogin() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dettachView()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.dettachView()
    }

}
