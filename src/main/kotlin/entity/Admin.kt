package entity

class Admin(
    userId: String,
    name: String,
    password: String,
    salt: ByteArray,
    role: Role
) : User(userId, name, password, salt, role)
