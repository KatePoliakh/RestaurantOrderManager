package data.repository

//import kotlinx.serialization.json.Json
import data.dao.MenuDao
import domain.entity.MenuItem

class MenuJsonRepository(private val menuJsonRepositoryPath: String) : MenuDao {
    override fun viewMenu() {
        TODO("Not yet implemented")
    }

    override fun addItem(menuItem: MenuItem) {
        TODO("Not yet implemented")
    }

    override fun removeItem(menuItem: MenuItem) {
        TODO("Not yet implemented")
    }

    override fun updateItem(menuItem: MenuItem) {
        TODO("Not yet implemented")
    }

    override fun getMenuItemByName(menuItemName: String): MenuItem? {
        TODO("Not yet implemented")
    }

    override fun getAllItems(): List<MenuItem> {
        TODO("Not yet implemented")
    }


//private val json = Json { prettyPrint = true }
     fun serialize(data: List<MenuItem>): String {
    //    return json.encodeToString(data)
        return ""
    }

     fun deserialize(data: String): List<MenuItem> {
     //   return json.decodeFromString(data)
        return emptyList()
    }

}