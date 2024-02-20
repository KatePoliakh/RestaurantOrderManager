import dao.MenuDaoImpl
import dao.UserDaoImpl
import service.auth.AuthServiceImpl
import service.menu.ConsoleMenuServiceImpl
import service.visitor.VisitorServiceImpl

fun main() {
    val userDao = UserDaoImpl()
    val authService = AuthServiceImpl(userDao)
    val consoleMenuService = ConsoleMenuServiceImpl(authService, userDao)
    //val menuDao = MenuDaoImpl()
    //val visitorService = VisitorServiceImpl(menuDao)

    consoleMenuService.run()
}