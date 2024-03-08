package domain.service.auth

import domain.entity.User

interface OldAuthenticationService {
    fun authenticate(username: String, password: String): User?

    fun hashPassword(password: String, salt: ByteArray): String

    fun ByteArray.toHexString(): String

}