package data.dao

import domain.entity.User

interface UserDao {
    fun saveUser(user: User)
    fun getUserByName(username: String): User?
    fun getAllUsers(): List<User>

}