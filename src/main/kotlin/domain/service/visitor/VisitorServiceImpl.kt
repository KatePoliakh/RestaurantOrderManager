package domain.service.visitor

import data.dao.MenuDao
import data.dao.OrdersDao
import domain.entity.MenuItem
import domain.entity.Order
import domain.entity.OrderStatus

class VisitorServiceImpl(private val menuDao: MenuDao,
                         private val orderDao: OrdersDao)
    : VisitorService {
   // private var order: Order? = null
   // private var systemState: SystemState = SystemState()

    override fun viewMenu() {
        val menuItems = menuDao.getAllItems()
        for (menuItem in menuItems) {
            println(menuItem)
        }
    }

    override fun makeOrder() {
        val menuItems = menuDao.getAllItems()
        val orderedItems = mutableListOf<MenuItem>()
        var continueOrdering = "yes"
        while (continueOrdering == "yes") {
            for (menuItem in menuItems) {
                println(menuItem)
            }
            println("Enter the name of the dish you want to order")
            val dishName = readLine() ?: ""
            val dish = menuItems.find { it.name == dishName } // getDishByName
            if (dish != null) {
                orderedItems.add(dish)
            } else {
                println("Dish not found")
            }
            println("Do you want to continue ordering? (yes/no)")
            continueOrdering = readLine() ?: "no"
        }
        if (orderedItems.isNotEmpty()) {
            val order = Order(generateOrderId(), orderedItems, OrderStatus.ACCEPTED)
            orderDao.addOrder(order)
        }
    }

    override fun viewOrderById() {
        val orders = orderDao.getAllOrders()
        for (order in orders) {
            println(order)
        }
    }

    override fun cancelOrder() {
        println("Enter the id of the order you want to cancel")
        val orderId = readlnOrNull()?.toInt() ?: -1
        val order = orderDao.getOrderById(orderId)
        if (order != null) {
            order.status = OrderStatus.CANCELLED
        } else {
            println("Order not found")
        }
    }

    override fun payOrder() {
    }
    override fun viewOrderStatus() {
        println("Enter the id of the order you want to cancel")
        val orderId = readlnOrNull()?.toInt() ?: -1
        val order = orderDao.getOrderById(1)
        if (order != null) {
            println(order.status)
        } else {
            println("Order not found")
        }

    }
    private fun generateOrderId(): Int {
        return (Math.random() * 100000).toInt()
    }
}