import dao.UserDaoImpl
import service.auth.AuthServiceImpl
import presentation.menu.MainMenuImpl

fun main() {
    val userDao = UserDaoImpl()
    val authService = AuthServiceImpl(userDao)
    val consoleMenuService = MainMenuImpl(authService, userDao)
    //val menuDao = MenuDaoImpl()
    //val visitorService = VisitorServiceImpl(menuDao)

    consoleMenuService.run()
}