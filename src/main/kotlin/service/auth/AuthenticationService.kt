package service.auth

import entity.User

interface AuthenticationService {
    fun authenticate(username: String, password: String): User?

    fun hashPassword(password: String, salt: ByteArray): String

    fun ByteArray.toHexString(): String

}