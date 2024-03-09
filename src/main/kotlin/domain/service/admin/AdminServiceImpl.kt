package domain.service.admin
import data.dao.MenuDao
import domain.entity.MenuItem
import presentation.model.OutputModel


class AdminServiceImpl(private val menuDao: MenuDao) : AdminService {
    override fun viewMenu() {
        println(OutputModel("===Midnight restaurant menu==="))
        val menuItems = menuDao.getAllItems()
        if (menuItems.isEmpty()) {
            println("Menu is empty! Restaurant is not available. Please come back later.")
            return
        }
        for (menuItem in menuItems) {
            println(menuItem)
        }
    }
    override fun addItem(menuItem: MenuItem) {
        menuDao.addItem(menuItem)
    }

    override fun removeItem(menuItem: MenuItem) {
        menuDao.removeItem(menuItem)
    }

    override fun updateItem(menuItem: MenuItem) {
        menuDao.updateItem(menuItem)
    }
}