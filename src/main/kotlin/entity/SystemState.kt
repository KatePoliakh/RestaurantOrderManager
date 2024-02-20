package entity

import dao.MenuDaoImpl
import entity.MenuItem

class SystemState {
    var menu: MenuDaoImpl? = null
    var revenue: Double = 0.0
    var users: List<String> = listOf()
    // Add other necessary fields
}