package domain.service

import data.dao.OrdersDao
import domain.entity.Order
import domain.entity.OrderStatus
import domain.service.Kitchen
/*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

import kotlinx.coroutines.*
class KitchenImpl(private val ordersDao: OrdersDao) : Kitchen {
    override fun makeOrder(ordersDao: OrdersDao) {
        val prepareOrderJob = launch { prepareOrder(order) }
        delay(2000L) // Wait for 2 seconds
        launch { addDishToOrder(order) }
        delay(2000L) // Wait for 2 seconds
        launch { removeDishFromOrder(order) }
        prepareOrderJob.join() // Wait for the order to be prepared before returning
    }
    override suspend fun prepareOrder(ordersDao: OrdersDao) {
        order.status = OrderStatus.PREPARING
        delay(5000L) // Simulate the time it takes to prepare the order
        order.status = OrderStatus.READY
        ordersDao.updateOrder(order)
        println("Order ${order.id} is ready!")
    }
    override suspend fun addDishToOrder(ordersDao: OrdersDao) {
        delay(1000L) // Simulate the time it takes to add a dish to the order
        // Add logic to add a dish to the order
        ordersDao.updateOrder(order)
        println("Dish added to order ${order.id}")
    }
    override suspend fun removeDishFromOrder(order: OrdersDao) {
        delay(1000L) // Simulate the time it takes to remove a dish from the order
        // Add logic to remove a dish from the order
        ordersDao.updateOrder(order)
        println("Dish removed from order ${order.id}")
    }
}*/