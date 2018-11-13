package io.tsh.mb.tddexample.signin

import io.reactivex.Completable
import java.lang.RuntimeException

class NoConnectionException : RuntimeException()
class ApiException(val msg:String) : RuntimeException()

interface SignInRepository{
    fun login(username:String, password:String):Completable
}

class SignInRepositoryImpl : SignInRepository{
    override fun login(username: String, password: String): Completable {
        return Completable.complete()
    }
}