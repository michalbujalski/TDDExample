package io.tsh.mb.tddexample.signin

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class SignInPresenter(
    private val view: SignInContract.View,
    private val loginRepository: SignInRepository,
    private val loginValidator: SignInValidator
): SignInContract.Presenter {


}