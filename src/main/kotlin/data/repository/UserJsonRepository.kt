package data.repository

//import domain.entity.Order

//import kotlinx.serialization.json.Json
import data.dao.UserDao
import domain.entity.User
import java.io.File
import java.io.FileNotFoundException

class UserJsonRepository(private val userJsonRepositoryPath: String) : UserDao {
    //private val json = Json { prettyPrint = true }
     fun serialize(data: List<User>): String {
        //    return json.encodeToString(data)
        return ""
    }



    fun deserialize(data: String): List<User> {
        //   return json.decodeFromString(data)
        return emptyList()
    }

    override fun saveUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUserById(userId: String): User? {
        TODO("Not yet implemented")
    }

    override fun getUserByName(username: String): User? {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(): List<User> {
        val storageFileText = readFileOrCreateEmpty(userJsonRepositoryPath)
        val accounts: List<User> = if (storageFileText.isBlank()) {
            listOf()
        } else {
            // Json.decodeFromString<List<User>>(storageFileText)
            // Replace the above line with your deserialization logic
            deserialize(storageFileText)
        }
        return accounts
    }

    override fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }

    private fun readFileOrCreateEmpty(filePath: String): String {
        val file = File(filePath)
        return try {
            file.readText()
        } catch (exception: FileNotFoundException) {
            file.createNewFile()
            ""
        }
    }
}