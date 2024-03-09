package presentation.menu.visitor

import data.dao.MenuDao
import data.dao.OrdersDao
import domain.entity.MenuItem
import domain.entity.Order
import domain.entity.OrderStatus
import domain.service.InputValidator
import domain.service.visitor.VisitorService


class VisitorMenuImpl(
    private val menuDao: MenuDao,
    private val visitorService: VisitorService,
    private val ordersDao: OrdersDao,
    private val inputValidator: InputValidator
)
    : VisitorViewMenu {
    override fun run() {
        var choice: Int
        do {
            println("===Visitor menu===")
            handleMenu(
                listOf("View Menu", "Make an Order", "Add items to order (if order is not done yet)",
                    "Cancel order (if order is not done yet)", "Pay for order", "Leave a review", "Exit"),
                listOf({ handleViewMenu() },
                    { handlePlaceOrder()  },
                    { handleAddItemsToOrder() },
                    { handleCancelOrder() },
                    { handlePayForOrder() },
                    { handleLeaveReview() },
                    { return@listOf })
            )
            choice = inputValidator.readInt()
        } while (choice != 7)
    }
    override fun handleViewMenu() {
        visitorService.viewMenu()
    }

    override fun handlePlaceOrder() {
        //val menuItems = menuDao.getAllItems()
        val orderedItems = mutableListOf<MenuItem>()
        var continueOrdering = "yes"
        while (continueOrdering == "yes") {
            visitorService.viewMenu()
            println("Enter the name of the dish you want to order")
            val dishName = inputValidator.readString()
            val dish = menuDao.getMenuItemByName(dishName)
            if (dish != null) {
                orderedItems.add(dish)
            } else {
                println("Dish not found")
            }
            println("Do you want to continue ordering? (yes/no)")
            continueOrdering = inputValidator.readString()
        }
        if (orderedItems.isNotEmpty()) {
            val order = Order(orderedItems, visitorService.generateOrderId())
            visitorService.placeOrder(order)
            println("Order have been placed successfully. Please remember your order id: ${order.orderId}")
        }
    }

    override fun handleCancelOrder() {
        println("Enter the id of the order you want to cancel")
        val orderId = inputValidator.readInt()
        val order = ordersDao.getOrderById(orderId)
        if (order != null) {
            ordersDao.changeOrderStatus(orderId, OrderStatus.CANCELLED)
        } else {
            println("Order not found")
        }
    }

    override fun handlePayForOrder() {
        //visitorService.payForOrder()
    }

    override fun handleLeaveReview() {
        println("Enter the id of the order you want to leave a review for")
        val orderId = inputValidator.readInt()
        val order = ordersDao.getOrderById(orderId)
        if (order != null) {
            println("Enter your review")
            val review = inputValidator.readString()
            println("Enter your mark (1-5)")
            val mark = inputValidator.readInt()
            ordersDao.makeReview(orderId, mark, review)
        } else {
            println("Order not found")
        }
    }

    override fun handleAddItemsToOrder() {
        println("Enter the id of the order you want to add items to")
        val orderId = inputValidator.readInt()
        val order = ordersDao.getOrderById(orderId)
        if (order != null) {
            visitorService.viewMenu()
            println("Enter the name of the dish you want to add to the order")
            val dishName = inputValidator.readString()
            val dish = menuDao.getMenuItemByName(dishName)
            if (dish != null) {
                visitorService.addItemToOrder(orderId, dishName)
            } else {
                println("Dish not found")
            }
        } else {
            println("Order not found")
        }
    }

    private fun displayMenu(options: List<String>) {
        options.forEachIndexed { index, option ->
            println("${index + 1}. $option")
        }
    }

    private fun handleMenu(options: List<String>, actions: List<() -> Unit>) {
        var choice: Int
        do {
            displayMenu(options)
            choice = inputValidator.readInt()
            actions.getOrNull(choice - 1)?.invoke()
        } while (choice != options.size)
    }


}