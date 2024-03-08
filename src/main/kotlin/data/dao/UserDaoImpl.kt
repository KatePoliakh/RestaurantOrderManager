package data.dao

import domain.entity.User

class UserDaoImpl : UserDao {
    private val users = mutableListOf<User>()
    override fun saveUser(user: User) {
        users.add(user)
    }

    override fun getUserById(userId : String): User? {
        return users.find { it.userId == userId }
    }

    override fun getUserByName(username: String): User? {
        return users.find { it.name == username }
    }
    override fun getAllUsers(): List<User> {
        return users
    }

    override fun deleteUser(user: User) {
        users.remove(user)
    }
    //fun updateUser(username: String, password: String, role: String): Boolean

}