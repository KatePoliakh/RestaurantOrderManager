package domain.service.visitor

import data.dao.MenuDaoImpl
import domain.entity.Order
import domain.entity.OrderStatus
import domain.entity.SystemState

class VisitorServiceImpl(private val menuDao: MenuDaoImpl) : VisitorService {
    private var order: Order? = null
    private var systemState: SystemState = SystemState()

    override fun viewMenu() {
        menuDao.viewMenu()
    }

    override fun makeOrder() {
       // order = Order(OrderStatus.ACCEPTED)
    }

    override fun viewOrder() {
        throw UnsupportedOperationException("Not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancelOrder() {
        order = null
    }

    override fun payOrder() {
        if (order != null) {
            systemState.revenue += 10.0 // Assume each order costs 10.0
            order = null
        } else {
            println("No order to pay for")
        }
    }
    override fun viewOrderStatus() {
        throw UnsupportedOperationException("Not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}