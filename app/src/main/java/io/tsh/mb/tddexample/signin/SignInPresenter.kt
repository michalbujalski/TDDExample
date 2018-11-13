package io.tsh.mb.tddexample.signin

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.tsh.mb.tddexample.R

class SignInPresenter(
    private val view: SignInContract.View,
    private val loginRepository: SignInRepository,
    private val loginValidator: SignInValidator
): SignInContract.Presenter {
    val compositeDisposable = CompositeDisposable()
    override fun login(username: String, password: String) {
        val validationResult = loginValidator.validate(username, password)
        when (validationResult) {
            ValidationResult.VALID -> {
                view.showProgress()
                loginRepository
                    .login(username, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                        onComplete = {
                            view.hideProgress()
                            view.onLoginSuccess()
                        },
                        onError = {
                            view.hideProgress()
                            if (it is NoConnectionException) {
                                view.showNoConnectionError()
                            } else if (it is ApiException) {
                                view.showError(it.msg)
                            }
                        }
                    ).addTo(compositeDisposable)
            }
            ValidationResult.USERNAME_EMPTY -> view.showUsernameError(R.string.signInErrorUsernameEmpty)
            ValidationResult.PASSWORD_EMPTY -> view.showPasswordError(R.string.signInPasswordEmpty)
            ValidationResult.PASSWORD_NOT_VALID -> view.showPasswordError(R.string.signInErrorPasswordNotValid)
        }
    }
}