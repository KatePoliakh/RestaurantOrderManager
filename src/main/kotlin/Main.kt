import dao.UserDaoImpl
import service.auth.AuthenticationServiceImpl
import service.menu.ConsoleMenuServiceImpl
import service.registration.RegistrationServiceImpl

fun main() {
    val userDao = UserDaoImpl()
    val registrationService = RegistrationServiceImpl(userDao)
    val authenticationService = AuthenticationServiceImpl(userDao)
    val consoleMenuService = ConsoleMenuServiceImpl(registrationService, authenticationService, userDao)

    consoleMenuService.run()
}