package data.dao

import domain.entity.MenuItem

interface MenuDao {
    fun addItem(menuItem: MenuItem)
    fun removeItem(menuItem: MenuItem)
    fun updateItem(menuItem: MenuItem)
    fun getMenuItemByName(menuItemName: String): MenuItem?
    fun getAllItems(): List<MenuItem>

}