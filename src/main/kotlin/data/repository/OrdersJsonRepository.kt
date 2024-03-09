package data.repository

//import kotlinx.serialization.json.Json
//import kotlinx.serialization.SerializationException
import data.dao.OrdersDao
import domain.entity.Order
import domain.entity.OrderStatus
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class OrdersJsonRepository(private val ordersJsonRepositoryPath: String) : JsonRepository<Order>(), OrdersDao {


    override fun addOrder(order: Order) {
        val textFromFile = readFileOrCreateEmpty(ordersJsonRepositoryPath)
        val items: List<Order> = if (textFromFile.isBlank()) listOf() else Json.decodeFromString(textFromFile)
        val updatedOrders = items.toMutableList()
        updatedOrders.add(order)
        val serializedUpdatedStorage = Json.encodeToString(updatedOrders.toList())
        writeTextToFile(ordersJsonRepositoryPath, serializedUpdatedStorage)
    }
    override fun removeOrder(order: Order){
        val items: List<Order> = getAllOrders()
        val updatedItems = items.toMutableList()

        updatedItems.removeIf { oldItem -> oldItem.orderId == order.orderId }
        val serializedUpdatedStorage = Json.encodeToString(updatedItems.toList())
        writeTextToFile(ordersJsonRepositoryPath, serializedUpdatedStorage)
    }
    override fun updateOrder(order: Order) {
        val items: List<Order> = getAllOrders()
        if(items.find { item -> item.orderId == order.orderId } == null)
            return

        val updatedItems = items.toMutableList()
        updatedItems.removeIf { oldItem -> oldItem.orderId == order.orderId }
        updatedItems.add(order)

        val serializedUpdatedStorage = Json.encodeToString(updatedItems.toList())
        writeTextToFile(ordersJsonRepositoryPath, serializedUpdatedStorage)

    }
    override fun getAllOrders(): List<Order> {
        val textFromFile = readFileOrCreateEmpty(ordersJsonRepositoryPath)

        return if (textFromFile.isBlank())
            listOf() else Json.decodeFromString<List<Order>>(textFromFile)
    }

    override fun getOrderById(orderId: Int): Order? {
        val items: List<Order> = getAllOrders()
        return items.find { it.orderId == orderId }

    }

    override fun changeOrderStatus(orderId: Int, newStatus: OrderStatus) {
        val order = getOrderById(orderId)
        if (order != null) {
            order.status = newStatus
            updateOrder(order)
        }
    }

    override fun changeOrderPaidStatus(order: Order) {
        val items: List<Order> = getAllOrders()
        val updatedItems = items.toMutableList()
        updatedItems.removeIf { oldItem -> oldItem.orderId == order.orderId }
        updatedItems.add(order)
        val serializedUpdatedStorage = Json.encodeToString(updatedItems.toList())
        writeTextToFile(ordersJsonRepositoryPath, serializedUpdatedStorage)
    } // ИСПРАВИТЬ

    override fun makeReview(orderId: Int, mark: Int, review: String) {
        val order = getOrderById(orderId)
        if (order != null) {
            order.review = review
            order.reviewMark = mark
            updateOrder(order)
        }
    }

    override fun getOrdersByStatus(status: OrderStatus): List<Order> {
        val items: List<Order> = getAllOrders()
        return items.filter { it.status == status }
    }

}