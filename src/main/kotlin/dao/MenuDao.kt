package dao

import entity.MenuItem

interface MenuDao {
    fun viewMenu()
    fun addItem(menuItem: MenuItem)
    fun removeItem(menuItem: MenuItem)
    fun updateItem(menuItem: MenuItem)
}