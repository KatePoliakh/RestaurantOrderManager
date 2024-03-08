package presentation.menu.admin

import data.dao.MenuDao
import di.DI
import domain.entity.Role
import domain.service.admin.AdminService
import domain.service.auth.AuthService
import java.util.*

class AdminAuthImpl(
    private val authService: AuthService,
    //private val userDao: UserDao,
    private val adminService: AdminService,
    private val menuDao: MenuDao
) : AdminAuth {
    private val scanner = Scanner(System.`in`)
    private val adminPassword = "admin123" // Replace with your actual admin password
    override fun run() {
        var choice: Int
            handleAdminAuth()
        do {
            displayMenu()
            choice = scanner.nextInt()
            when (choice) {
                1 -> handleAdminRegistration()
                2 -> handleAdminAuthentication()
                3 -> return
                4 -> System.exit(0)
                else -> println("Invalid choice. Please enter a number between 1 and 3.")
            }
        } while (choice != 4)
    }

    private fun displayMenu() {
        println("===Admin menu===")
        println("1. Admin registration")
        println("2. Admin authentication")
        println("3. Back to main menu")
        println("4. Exit")
    }
    override fun handleAdminAuth() {
        println("===Admin access confirmation===")
        var input: String
        do {
            println("Enter admin password or type 'back' to return to the main menu:")
            input = scanner.next()
            if (input == "back") {
                val mainMenu = DI.consoleMenu
                mainMenu.run()
            }
            try {
                if (input == adminPassword) {
                    //handleAdminRegistration()
                    //handleAdminAuthentication()
                    //AdminMenuImpl(adminService, menuDao).run()
                    break
                } else {
                    println("Incorrect admin password. Please try again.")
                }
            } catch (e: Exception) {
                println("An error occurred: ${e.message}. Please try again.")
            }
        } while (true)
    }


    override fun handleAdminRegistration(){
        println("===Admin registration===")
        println("Enter username:")
        val username = scanner.next()
        println("Enter password:")
        val password = scanner.next()

        val result = authService.register(username, password, Role.ADMIN)
        if (result) {
            println("Registration successful!")
            println("After registration, you can authenticate as an admin.")
        } else {
            println("Registration failed!")
        }
    }

    override fun handleAdminAuthentication() {
        println("===Admin authentication===")
        println("Enter username:")
        val username = scanner.next()
        println("Enter password:")
        val password = scanner.next()

        val user = authService.login(username, password)
        if (user != null) {
            println("Authentication successful!")
            val adminMenu = AdminMenuImpl(adminService, menuDao)
            adminMenu.run()
        } else {
            println("Authentication failed!")
        }
    }
}