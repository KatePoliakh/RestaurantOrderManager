package domain.service.visitor

import domain.entity.Order
import domain.entity.OrderStatus

interface VisitorService {
    fun viewMenu()
    fun placeOrder(order: Order)
    //fun viewOrderById(orderId: Int) : Order? // мб убрать
    //fun cancelOrder(orderId: Int)
    fun payOrder(orderId: Int)
    fun viewOrderStatus(orderId: Int) : OrderStatus
    fun leaveReview(orderId: Int, mark: Int, review: String)
    fun addItemToOrder(orderId: Int, menuItem: String)
    fun generateOrderId(): Int
}