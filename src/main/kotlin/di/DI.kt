package di

import data.dao.MenuDao
import data.dao.OrdersDao
import data.dao.UserDao
import data.repository.MenuJsonRepository
import data.repository.OrdersJsonRepository
import data.repository.UserJsonRepository
import domain.service.InputValidator
import domain.service.admin.AdminService
import domain.service.admin.AdminServiceImpl
import domain.service.auth.AuthService
import domain.service.auth.AuthServiceImpl
import domain.service.visitor.VisitorService
import domain.service.visitor.VisitorServiceImpl
import presentation.menu.MainMenu
import presentation.menu.MainMenuImpl

object DI {
    private const val PATH_FOR_USERS = "src/main/resources/users_repository.json"
    private const val PATH_FOR_ORDERS = "src/main/resources/orders_repository.json"
    private const val PATH_FOR_MENU = "src/main/resources/menu_repository.json"

    private val authService: AuthService
        get() = AuthServiceImpl(userDao)

    private val adminService: AdminService
        get() = AdminServiceImpl(menuDao)
    private val visitorService: VisitorService
        get() = VisitorServiceImpl(menuDao, ordersDao)

    private val inputValidator: InputValidator
        get() = InputValidator()
    val consoleMenu : MainMenu
        get() = MainMenuImpl(authService, userDao, menuDao, adminService, visitorService, ordersDao, inputValidator)

    private val userDao: UserDao by lazy {
        UserJsonRepository(PATH_FOR_USERS)
    }

    private val menuDao: MenuDao by lazy {
        MenuJsonRepository(PATH_FOR_MENU)
    }

    private val ordersDao: OrdersDao by lazy {
        OrdersJsonRepository(PATH_FOR_ORDERS)
    }



}