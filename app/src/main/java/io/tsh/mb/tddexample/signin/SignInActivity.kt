package io.tsh.mb.tddexample.signin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.tsh.mb.tddexample.R

class SignInActivity: SignInContract.View, AppCompatActivity(){
    override fun showUsernameError(error: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPasswordError(error: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoginSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoConnectionError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit var presenter: SignInPresenter

    private val loginRepository = SignInRepositoryImpl()
    private val loginValidator = SignInValidatorImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

    }
}