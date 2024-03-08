package presentation.menu

import data.dao.UserDao
import domain.entity.Role
import domain.service.auth.AuthService
import java.util.*

class MainMenuImpl(
    private val authServiceImpl: AuthService,
    private val userDao: UserDao
) : MainMenu {
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
               // 3 -> handleGetAllUsers() // убрать позже
            }
        } while (choice != 3)
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


        val result = authServiceImpl.register(username, password, role)
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

        val user = authServiceImpl.login(username, password)
        if (user != null) {
            println("Authentication successful!")
        } else {
            println("Authentication failed!")
        }
    }
}