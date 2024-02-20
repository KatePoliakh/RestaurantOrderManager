package service.auth

import entity.Role
import entity.User

interface AuthService {
    fun register(username: String, password: String, role: Role) : Boolean
    fun login(name: String, password: String): User?
    fun hashPassword(password: String, salt: ByteArray): String
    fun ByteArray.toHexString(): String
    fun generateUserId(): String
}