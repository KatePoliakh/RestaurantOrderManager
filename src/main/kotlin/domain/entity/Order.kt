package domain.entity

import data.dao.MenuDao

class Order(
    val id: OrderStatus,
    val items: MenuDao,
    val status: OrderStatus
)