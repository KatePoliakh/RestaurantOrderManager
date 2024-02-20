package service.menu

import dao.UserDao
import entity.ConsoleMenu
import entity.Role
import service.auth.AuthenticationService
import service.registration.RegistrationService
import java.util.*

class ConsoleMenuServiceImpl(
    private val registrationService: RegistrationService,
    private val authenticationService: AuthenticationService,
    private val userDao: UserDao
) : ConsoleMenuService {
    private val scanner = Scanner(System.`in`)

    override fun run() {
        val menu = ConsoleMenu()
        var choice: Int

        do {
            menu.displayMenu()
            choice = scanner.nextInt()

            when (choice) {
                1 -> handleRegistration()
                2 -> handleAuthentication()
                3 -> handleGetAllUsers() // убрать позже
            }
        } while (choice != 4)
    }
    override fun handleGetAllUsers() { // убрать позже
        val users = userDao.getAllUsers()
        users.forEach { user ->
            println("User ID: ${user.userId}, Username: ${user.name}, Role: ${user.role}")
        }
    }
    override fun handleRegistration() {
        //TO DO: Сделать ввод роли проще
        println("Enter role (VISITOR or ADMIN):")
        val role = Role.valueOf(scanner.next().uppercase())
        println("Enter username:")
        val username = scanner.next()
        println("Enter password:")
        val password = scanner.next()


        val result = registrationService.register(username, password, role)
        if (result) {
            println("Registration successful!")
        } else {
            println("Registration failed!")
        }
    }

    override fun handleAuthentication() {
        println("Enter username:")
        val username = scanner.next()
        println("Enter password:")
        val password = scanner.next()

        val user = authenticationService.authenticate(username, password)
        if (user != null) {
            println("Authentication successful!")
        } else {
            println("Authentication failed!")
        }
    }
}