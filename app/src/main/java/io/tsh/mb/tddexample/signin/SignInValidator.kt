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
    private val minUsernameLength = 3
    private val minPasswordLength = 6

    override fun validate(username: String, password: String): ValidationResult {
        return when {
            username.isEmpty() -> ValidationResult.USERNAME_EMPTY
            username.length < minUsernameLength -> ValidationResult.USERNAME_NOT_VALID
            password.isEmpty() -> ValidationResult.PASSWORD_EMPTY
            password.length < minPasswordLength -> ValidationResult.PASSWORD_NOT_VALID
            else -> ValidationResult.VALID
        }
    }
}