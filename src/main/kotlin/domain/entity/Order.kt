package domain.entity

import kotlinx.serialization.Serializable

@Serializable
class Order(
    val items: List<MenuItem>,
    val orderId : Int,
    //@Serializable(with = UUIDSerializer::class)
    //val userId : UUID,
    //calculate total price
    //calculate total cooking time
) {

    var timeOfCooking : Int = 0
    var status = OrderStatus.ACCEPTED
    var paid = false
    var reviewMark : Int = 0
    var review : String = ""
    var num : Int = 0
}