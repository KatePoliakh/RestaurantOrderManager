package service.admin

import entity.MenuItem

interface AdminService {
    fun addItem (menuItem: MenuItem)
    fun removeItem (menuItem: MenuItem)
    fun updateItem (menuItem: MenuItem)

}