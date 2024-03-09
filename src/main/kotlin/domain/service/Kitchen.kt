package domain.service

import data.dao.OrdersDao

interface Kitchen {
    fun makeOrder(ordersDao: OrdersDao)

    suspend fun prepareOrder(ordersDao: OrdersDao)
    suspend fun addDishToOrder(ordersDao: OrdersDao)
    suspend fun removeDishFromOrder(order: OrdersDao)
}