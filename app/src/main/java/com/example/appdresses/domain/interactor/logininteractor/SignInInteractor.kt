package com.example.appdresses.domain.interactor.logininteractor

interface SignInInteractor {

    interface SigninCallBack {
        fun onSignInSuccess()
        fun onSignInFailure(errorMsg:String)
    }

    fun signInWithEmailAndPassword(email:String,password:String,listener:SigninCallBack)
}