package io.tsh.mb.tddexample

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import io.tsh.mb.tddexample.signin.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SignInPresenterTests{

    @JvmField @Rule val rule = RxSchedulersRule()
    @Mock
    lateinit var view: SignInContract.View
    @Mock
    lateinit var validator:SignInValidator
    @Mock
    lateinit var repository: SignInRepository

    private lateinit var presenter: SignInContract.Presenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = SignInPresenter(
            view, repository, validator
        )
    }


    @Test
    fun `login, credentials validation failure, username empty and password empty`(){
        //given
        val username = ""
        val password = ""
        whenever(validator.validate(any(), any())).thenReturn(ValidationResult.USERNAME_EMPTY)
        //when
        presenter.login(username, password)
        //then
        val inOrder = inOrder(view,repository,validator)
        inOrder.verify(validator).validate(eq(username), eq(password))
        inOrder.verify(view).showUsernameError(eq(R.string.signInErrorUsernameEmpty))
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    fun `login, credentials validation failure, username valid and password empty`(){
        //given
        val username = ""
        val password = ""
        whenever(validator.validate(any(), any())).thenReturn(ValidationResult.PASSWORD_EMPTY)
        //when
        presenter.login(username, password)
        //then
        val inOrder = inOrder(view,repository,validator)
        inOrder.verify(validator).validate(eq(username), eq(password))
        inOrder.verify(view).showPasswordError(eq(R.string.signInPasswordEmpty))
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    fun `login, credentials validation failure, username valid and password not valid`(){
        //given
        val username = ""
        val password = ""
        whenever(validator.validate(any(), any())).thenReturn(ValidationResult.PASSWORD_NOT_VALID)
        //when
        presenter.login(username, password)
        //then
        val inOrder = inOrder(view,repository,validator)
        inOrder.verify(validator).validate(eq(username), eq(password))
        inOrder.verify(view).showPasswordError(eq(R.string.signInErrorPasswordNotValid))
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    fun `login success`(){
        //given
        val username = "someUsername01"
        val password = "qWeRtYASDF123!@#"
        whenever(validator.validate(eq(username),eq(password))).thenReturn(ValidationResult.VALID)
        whenever(repository.login(eq(username), eq(password))).thenReturn(Completable.complete())
        //when
        presenter.login(username, password)
        //then
        val inOrder = inOrder(view,repository)
        inOrder.verify(view).showProgress()
        inOrder.verify(view).hideProgress()
        inOrder.verify(view).onLoginSuccess()
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    fun `login backend error`(){
        //given
        val username = "someUsername01"
        val password = "qWeRtYASDF123!@#"
        val errorMessage = "This account is already taken"
        whenever(validator.validate(eq(username),eq(password))).thenReturn(ValidationResult.VALID)
        whenever(repository.login(eq(username), eq(password))).thenReturn(Completable.error(ApiException(errorMessage)))
        //when
        presenter.login(username, password)
        //then
        val inOrder = inOrder(view,repository)
        inOrder.verify(view).showProgress()
        inOrder.verify(view).hideProgress()
        inOrder.verify(view).showError(eq(errorMessage))
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    fun `login network error`(){
        //given
        val username = "someUsername01"
        val password = "qWeRtYASDF123!@#"
        val errorMessage = "This account is already taken"
        whenever(validator.validate(eq(username),eq(password))).thenReturn(ValidationResult.VALID)
        whenever(repository.login(eq(username), eq(password))).thenReturn(Completable.error(NoConnectionException()))
        //when
        presenter.login(username, password)
        //then
        val inOrder = inOrder(view,repository)
        inOrder.verify(view).showProgress()
        inOrder.verify(view).hideProgress()
        inOrder.verify(view).showNoConnectionError()
        inOrder.verifyNoMoreInteractions()
    }

}