package io.tsh.mb.tddexample.signin

import android.support.annotation.StringRes

interface SignInContract{
    interface View{
        fun showUsernameError(@StringRes error: Int)
        fun showPasswordError(@StringRes error: Int)
        fun showProgress()
        fun hideProgress()
        fun onLoginSuccess()
        fun showError(error: String)
        fun showNoConnectionError()
    }
    interface Presenter{
        fun login(username: String, password: String)
    }
}