package domain.entity

import kotlinx.serialization.Serializable

@Serializable
class MenuItem(
    val name: String,
    var quantity: Int,
    val price: Double,
    val preparationTime: Int
) {
    override fun toString(): String {
        return "MenuItem(name='$name', quantity=$quantity, price=$price, preparationTime=$preparationTime)"
    }
}
