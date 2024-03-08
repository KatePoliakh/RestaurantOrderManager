package domain.entity

import data.dao.MenuDao

class SystemState {
    var menu: MenuDao? = null
    var revenue: Double = 0.0
    var users: List<String> = listOf()
    // Add other necessary fields
}