package com.example.appdresses.domain.interactor.registerinteractor

interface SignUpInteractor {
    interface RegisterCallBack{
        fun onRegisterSuccess()
        fun onRegisterFailure(errorMsg:String)
    }

    fun signUp(fullname:String, email:String, password:String,listener:RegisterCallBack)
}