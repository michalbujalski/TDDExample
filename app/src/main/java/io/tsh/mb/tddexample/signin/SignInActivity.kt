package io.tsh.mb.tddexample.signin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.tsh.mb.tddexample.R

class SignInActivity: SignInContract.View, AppCompatActivity(){


    lateinit var presenter: SignInPresenter

    private val loginRepository = SignInRepositoryImpl()
    private val loginValidator = SignInValidatorImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

    }
}