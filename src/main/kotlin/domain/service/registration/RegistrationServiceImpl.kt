package domain.service.registration
import data.dao.UserDao
import domain.entity.Role
import java.security.MessageDigest
import kotlin.random.Random
import domain.entity.User

class RegistrationServiceImpl(private val userDao: UserDao) : RegistrationService {
    override fun register(username: String, password: String, role: Role): Boolean {
        val userId = generateUserId()
        val salt = ByteArray(16)
        Random.nextBytes(salt)
        val passwordHash = hashPassword(password, salt)
        val newUser = User(userId, username, passwordHash, salt, role)
        userDao.saveUser(newUser)
        println("The user has been successfully registered.")
        return true
    }

    override fun generateUserId(): String {
        return "U-${Random.nextInt(1000, 9999)}"
    }

    override fun hashPassword(password: String, salt : ByteArray): String {
        val salt = ByteArray(16)
        Random.nextBytes(salt)
        val md = MessageDigest.getInstance("SHA-256")
        md.update(salt)
        val hashedPassword = md.digest(password.toByteArray())
        return salt.toHexString() + ":" + hashedPassword.toHexString()

    }

    override fun ByteArray.toHexString(): String {
        return joinToString("") { "%02x".format(it) }
    }
}