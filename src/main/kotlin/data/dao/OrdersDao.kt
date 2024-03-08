package data.dao

import domain.entity.Order

interface OrdersDao {
    fun addOrder(order: Order)
    fun removeOrder(order: Order)
    fun updateOrder(order: Order)
    fun getAllOrders(): List<Order>
    fun getOrderById(orderId: Int): Order?
}
