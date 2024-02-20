package service.admin
import dao.MenuDao
import entity.MenuItem


class AdminServiceImpl(private val menuDao: MenuDao) : AdminService {
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