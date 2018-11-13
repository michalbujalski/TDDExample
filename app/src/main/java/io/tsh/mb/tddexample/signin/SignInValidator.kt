package io.tsh.mb.tddexample.signin

enum class ValidationResult{
    USERNAME_NOT_VALID,
    PASSWORD_NOT_VALID,
    USERNAME_EMPTY,
    PASSWORD_EMPTY,
    VALID
}
interface SignInValidator{
    fun validate(username:String, password:String):ValidationResult
}

class SignInValidatorImpl : SignInValidator{
    override fun validate(username: String, password: String): ValidationResult {
        return ValidationResult.VALID
    }
}