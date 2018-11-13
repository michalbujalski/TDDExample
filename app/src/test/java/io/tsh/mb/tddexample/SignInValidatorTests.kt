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

    @Test
    fun `validate username empty, password empty`(){
        //given
        val username = ""
        val password = ""
        //when
        val result = validator.validate(username,password)
        //then
        Assert.assertEquals(ValidationResult.USERNAME_EMPTY,result)
    }

    @Test
    fun `validate username valid, password empty`(){
        //given
        val username = "someUsername!@#"
        val password = ""
        //when
        val result = validator.validate(username,password)
        //then
        Assert.assertEquals(ValidationResult.PASSWORD_EMPTY,result)
    }

    @Test
    fun `validate username not valid, password empty`(){
        //given
        val username = "s"
        val password = ""
        //when
        val result = validator.validate(username,password)
        //then
        Assert.assertEquals(ValidationResult.USERNAME_NOT_VALID,result)
    }

    @Test
    fun `validate username not valid, password not valid`(){
        //given
        val username = "s"
        val password = "asdf"
        //when
        val result = validator.validate(username,password)
        //then
        Assert.assertEquals(ValidationResult.USERNAME_NOT_VALID,result)
    }

    @Test
    fun `validate username valid, password valid`(){
        //given
        val username = "usernam01"
        val password = "someLongPassword123"
        //when
        val result = validator.validate(username,password)
        //then
        Assert.assertEquals(ValidationResult.VALID,result)
    }
}

