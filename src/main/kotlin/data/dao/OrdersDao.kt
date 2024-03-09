package data.dao

import domain.entity.Order
import domain.entity.OrderStatus

interface OrdersDao {
    fun addOrder(order: Order)
    fun removeOrder(order: Order)
    fun updateOrder(order: Order)
    fun getAllOrders(): List<Order>
    fun getOrderById(orderId: Int): Order?
    fun changeOrderStatus(orderId: Int, newStatus: OrderStatus)
    fun changeOrderPaidStatus(order: Order)
    fun makeReview(orderId: Int, mark: Int, review: String)
    fun getOrdersByStatus(status: OrderStatus): List<Order>

}
