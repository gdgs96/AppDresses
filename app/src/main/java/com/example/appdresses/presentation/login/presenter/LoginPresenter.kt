package com.example.appdresses.presentation.login.presenter

import com.example.appdresses.domain.interactor.logininteractor.SignInInteractor
import com.example.appdresses.presentation.login.LoginContract

class LoginPresenter(signInInteractor: SignInInteractor): LoginContract.LoginPresenter {

    var view: LoginContract.LoginView? = null
    var signInInteractor:SignInInteractor? = null

    init {
        this.signInInteractor = signInInteractor
    }

    override fun attachView(view: LoginContract.LoginView) {
        this.view = view
    }

    override fun dettachView() {
        view = null
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun signInUserWithEmailAndPassword(email: String, password: String) {
        view?.showProgressBar()
        signInInteractor?.signInWithEmailAndPassword(email,password,object: SignInInteractor.SigninCallBack{
            override fun onSignInSuccess() {
                if (isViewAttached()){
                    view?.hideProgressbar()
                    view?.navigateToMain()
                }
            }

            override fun onSignInFailure(errorMsg: String) {
                if (isViewAttached()){
                    view?.hideProgressbar()
                    view?.showError(errorMsg)
                }
            }
        })

    }

    override fun checkEmptyFields(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }

}