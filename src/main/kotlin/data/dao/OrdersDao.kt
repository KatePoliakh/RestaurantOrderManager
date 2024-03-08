package data.dao

interface OrdersDao {
    fun viewOrders()
    fun addOrder()
    fun removeOrder()
    fun updateOrder()
}