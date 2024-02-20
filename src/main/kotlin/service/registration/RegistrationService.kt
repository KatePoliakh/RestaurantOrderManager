package service.registration

import entity.Role

interface RegistrationService {
    fun register(username: String, password: String, role: Role): Boolean

    fun generateUserId(): String

    fun hashPassword(password: String, salt: ByteArray): String

    fun ByteArray.toHexString(): String
}