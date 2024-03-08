package di

import data.dao.MenuDao
import data.dao.OrdersDao
import data.dao.UserDao
import data.repository.MenuJsonRepository
import data.repository.OrdersJsonRepository
import data.repository.UserJsonRepository
import domain.service.auth.AuthService
import domain.service.auth.AuthServiceImpl
import presentation.menu.MainMenu
import presentation.menu.MainMenuImpl

object DI {
    private const val PATH_FOR_USERS = "users_repository.json"
    private const val PATH_FOR_ORDERS = "orders_repository.json"
    private const val PATH_FOR_MENU = "menu_repository.json"

    val authService: AuthService
        get() = AuthServiceImpl(userDao)

    val consoleMenu : MainMenu
        get() = MainMenuImpl(authService, userDao)

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