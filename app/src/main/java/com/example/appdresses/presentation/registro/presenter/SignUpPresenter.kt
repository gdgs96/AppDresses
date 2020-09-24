package com.example.appdresses.presentation.registro.presenter

import androidx.core.util.PatternsCompat
import com.example.appdresses.domain.interactor.registerinteractor.SignUpInteractor
import com.example.appdresses.presentation.registro.SignUpContract

class SignUpPresenter(signUpInteractor: SignUpInteractor):
    SignUpContract.SignUpPresenter {

    var view:SignUpContract.SignUpView? = null
    var signUpInteractor:SignUpInteractor? = null

    init {
        this.signUpInteractor = signUpInteractor
    }

    override fun attachView(view: SignUpContract.SignUpView) {
        this.view = view
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun detachView() {
        view = null
    }

    override fun checkEmptyName(fullname: String): Boolean {
        return fullname.isEmpty()
    }

    override fun checkValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun checkEmptyPasswords(pw1: String, pw2: String): Boolean {
        return pw1.isEmpty() or pw2.isEmpty()
    }

    override fun checkPasswordsMatch(pw1: String, pw2: String): Boolean {
        return pw1 == pw2
    }

    override fun signUp(fullname: String, email: String, password: String) {
        view?.showProgress()
        signUpInteractor?.signUp(fullname,email,password,object : SignUpInteractor.RegisterCallBack{
            override fun onRegisterSuccess() {
                view?.navigateToMain()
                view?.hideProgress()
            }

            override fun onRegisterFailure(errorMsg: String) {
                view?.showError(errorMsg)
                view?.hideProgress()
            }

        })
    }
}