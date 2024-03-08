package domain.entity

import kotlinx.serialization.Serializable

@Serializable
class Order(
    val orderId: Int,
    val items: List<MenuItem>,
    var status: OrderStatus
    //calculate total price
    //calculate total cooking time
)