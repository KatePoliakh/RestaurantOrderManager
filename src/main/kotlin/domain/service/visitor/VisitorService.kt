package domain.service.visitor

interface VisitorService {
    fun viewMenu()
    fun makeOrder()
    fun viewOrderById()
    fun cancelOrder()
    fun payOrder()
    fun viewOrderStatus()
}