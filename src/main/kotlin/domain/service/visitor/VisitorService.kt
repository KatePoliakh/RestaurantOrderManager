package domain.service.visitor

interface VisitorService {
    fun viewMenu()
    fun makeOrder()
    fun viewOrder()
    fun cancelOrder()
    fun payOrder()
    fun viewOrderStatus()
}