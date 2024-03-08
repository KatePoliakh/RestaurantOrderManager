package data.repository

//import kotlinx.serialization.json.Json
//import kotlinx.serialization.SerializationException
import data.dao.OrdersDao
import domain.entity.Order

class OrdersJsonRepository(private val ordersJsonRepositoryPath: String) : JsonRepository<Order>(), OrdersDao {


    override fun addOrder(order: Order) {
        val orders = loadFromFile(ordersJsonRepositoryPath).toMutableList()
        orders.add(order)
        saveToFile(orders, ordersJsonRepositoryPath)
        //writeFile(ordersJsonRepositoryPath, serialize(orders))
    }
    override fun removeOrder(order: Order){
        val orders = loadFromFile(ordersJsonRepositoryPath).toMutableList()
        orders.remove(order)
        saveToFile(orders, ordersJsonRepositoryPath)
        //writeFile(ordersJsonRepositoryPath, serialize(orders))
    }
    override fun updateOrder(order: Order) {
        val orders = loadFromFile(ordersJsonRepositoryPath).toMutableList()
        val index = orders.indexOf(order)
        if (index != -1) {
            orders[index] = order
        }
        saveToFile(orders, ordersJsonRepositoryPath)
    }
    override fun getAllOrders(): List<Order> {
        return loadFromFile(ordersJsonRepositoryPath)
    }
    override fun getOrderById(orderId: Int): Order? {
        val orders = loadFromFile(ordersJsonRepositoryPath)
        return orders.find { it.orderId == orderId }
    }

}