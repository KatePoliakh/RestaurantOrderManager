package data.dao

import domain.entity.User

interface UserDao {
    fun saveUser(user: User)
   // fun getUserById(userId : String): User?
    fun getUserByName(username: String): User?
    fun getAllUsers(): List<User>
    //fun deleteUser(user: User)
    //fun updateUser(username: String, password: String, role: String): Boolean
}