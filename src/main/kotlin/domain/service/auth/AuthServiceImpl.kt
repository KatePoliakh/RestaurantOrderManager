package domain.service.auth

import data.dao.UserDao
import domain.entity.Role
import domain.entity.User
import java.security.MessageDigest
import kotlin.random.Random

class AuthServiceImpl(private val userDao: UserDao) : AuthService {
    override fun register(username: String, password: String, role: Role) : Boolean {
        val userId = generateUserId()
        val salt = ByteArray(16)
        Random.nextBytes(salt)
        val passwordHash = hashPassword(password, salt)
        userDao.saveUser(User(userId, username, passwordHash, salt, role))
        println("The user has been successfully registered.")
        return true
    }

    override fun login(name: String, password: String): User? {
        val user = userDao.getUserByName(name)
        /* if (user != null && user.password == hashPassword(password, user.salt)){
            return user
        }*/
        if (user != null) {
            val salt = user.salt
            val passwordHash = hashPassword(password, salt)
            if (user.password == passwordHash) {
                return user
            }
        }
        return null
    }

    override fun generateUserId(): String {
        return "U-${Random.nextInt(1000, 9999)}"
    }
    override fun hashPassword(password: String, salt: ByteArray): String {
        val md = MessageDigest.getInstance("SHA-256")
        md.update(salt)
        val hashedPassword = md.digest(password.toByteArray())
        return salt.toHexString() + ":" + hashedPassword.toHexString()
    }

    override fun ByteArray.toHexString(): String {
        return joinToString("") { "%02x".format(it) }
    }
}