package service.auth
import dao.UserDao
import java.security.MessageDigest
import entity.User

class AuthenticationServiceImpl(private val userDao: UserDao) : AuthenticationService {
    override fun authenticate(name: String, password: String): User? {
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