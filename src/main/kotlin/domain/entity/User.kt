package domain.entity
import kotlinx.serialization.Serializable
@Serializable
data class User (
    val userId: String,
    val name: String,
    val password: String,
    val salt: ByteArray,
    val role: Role
)