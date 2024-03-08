package domain.service.admin
import data.dao.MenuDao
import domain.entity.MenuItem


class AdminServiceImpl(private val menuDao: MenuDao) : AdminService {
    override fun viewMenu() {
        val menuItems = menuDao.getAllItems()
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