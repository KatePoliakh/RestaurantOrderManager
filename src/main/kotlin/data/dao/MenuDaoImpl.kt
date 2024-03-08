package data.dao

import domain.entity.MenuItem
import domain.entity.User

class MenuDaoImpl: MenuDao {
    private val menuItems = mutableListOf<MenuItem>()
    override fun viewMenu() {
        for (menuItem in menuItems) {
            println(menuItem)
        }
    }

    override fun addItem(menuItem: MenuItem) {
        menuItems.add(menuItem)
    }

    override fun removeItem(menuItem: MenuItem) {
        menuItems.remove(menuItem)
    }

    override fun updateItem(menuItem: MenuItem) {
        val index = menuItems.indexOf(menuItem)
        if (index != -1) {
            menuItems[index] = menuItem
        }
    }
    /*override fun getMenuItems(): List<MenuItem> {
        return menuItems
    }*/
    override fun getMenuItemByName(menuItemName: String): MenuItem? {
        return menuItems.find { it.name == menuItemName }
    }
    override fun getAllItems(): List<MenuItem> {
        return menuItems
    }
}