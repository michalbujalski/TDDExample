package io.tsh.mb.tddexample

import io.tsh.mb.tddexample.signin.SignInValidator
import io.tsh.mb.tddexample.signin.SignInValidatorImpl
import io.tsh.mb.tddexample.signin.ValidationResult
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SignInValidatorTests {
    lateinit var validator:SignInValidator

    @Before
    fun setUp(){
        validator = SignInValidatorImpl()
    }
}

