package entity

open class User (
    val userId: String,
    val name: String,
    val password: String,
    var salt: ByteArray,
    val role: Role
)