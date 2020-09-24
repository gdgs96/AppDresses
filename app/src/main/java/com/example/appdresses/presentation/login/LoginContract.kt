package com.example.appdresses.presentation.login

interface LoginContract {
    interface LoginView{
        fun showError(msgError: String)
        fun showProgressBar()
        fun hideProgressbar()
        fun signIn()
        fun navigateToMain()
        fun navigateToRegister()
        fun navigateToLogin()
    }
    interface LoginPresenter{
        fun attachView(view: LoginView)
        fun dettachView()
        fun isViewAttached():Boolean
        fun signInUserWithEmailAndPassword(email:String,password:String)
        fun checkEmptyFields(email: String,password: String):Boolean
    }
}