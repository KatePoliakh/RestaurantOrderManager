package service.order

interface OrderProcessingService {
    fun processOrder()
    fun cancelOrder()
    fun payOrder()
    fun viewOrder()
    fun viewMenu()
    fun addItem()
    fun removeItem()
    fun updateItem()
}