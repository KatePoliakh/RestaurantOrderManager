package domain.service.visitor

import data.dao.MenuDao
import data.dao.OrdersDao
import domain.entity.Order
import domain.entity.OrderStatus
import presentation.model.OutputModel

class VisitorServiceImpl(private val menuDao: MenuDao,
                         private val orderDao: OrdersDao)
    : VisitorService {
    override fun viewMenu() {
        println(OutputModel("===Midnight restaurant menu==="))
        val menuItems = menuDao.getAllItems()
        if (menuItems.isEmpty()) {
            println(OutputModel("Menu is empty! Restaurant is not available. Please come back later."))
            return
        }
        for (menuItem in menuItems) {
            println(menuItem)
        }

    }

    override fun placeOrder(order: Order) {
        val newOrder = Order(order.items, order.orderId)
        orderDao.addOrder(newOrder)
    }


    override fun payOrder(orderId: Int) {

    }
    override fun viewOrderStatus(orderId: Int) :OrderStatus{
        val order = orderDao.getOrderById(orderId)
        return order?.status ?: OrderStatus.NOT_FOUND
    }

    override fun leaveReview(orderId: Int, mark: Int, review: String) {
        orderDao.makeReview(orderId, mark, review)
    }

    override fun addItemToOrder(orderId: Int, menuItem: String) {
        val order = orderDao.getOrderById(orderId)
        if (order != null) {
            val item = menuDao.getMenuItemByName(menuItem)
            if (item != null) {
                val updatedOrder = Order(order.items + item, order.orderId)
                orderDao.updateOrder(updatedOrder)
            }
        }
    }

    override fun generateOrderId(): Int {
        return (Math.random() * 100000).toInt()
    }
}