package dao

import entity.MenuItem

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
}