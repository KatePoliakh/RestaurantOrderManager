package data.repository

import data.dao.OrdersDao

package data.repository

//import domain.entity.Order

//import kotlinx.serialization.json.Json
import data.dao.UserDao
import domain.entity.User
import java.io.File
import java.io.FileNotFoundException

class OrdersJsonRepository(private val ordersJsonRepositoryPath: String) : OrdersDao {
    //private val json = Json { prettyPrint = true }
    fun serialize(data: List<User>): String {
        //    return json.encodeToString(data)
        return ""
    }



    fun deserialize(data: String): List<User> {
        //   return json.decodeFromString(data)
        return emptyList()
    }
    override fun viewOrders() {
        TODO("Not yet implemented")
    }

    override fun addOrder() {
        TODO("Not yet implemented")
    }

    override fun removeOrder() {
        TODO("Not yet implemented")
    }

    override fun updateOrder() {
        TODO("Not yet implemented")
    }

}