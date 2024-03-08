package presentation.menu

import data.dao.MenuDao
import domain.entity.Role
import domain.service.admin.AdminService
import domain.service.auth.AuthService
import presentation.menu.admin.AdminAuthImpl
import presentation.menu.visitor.VisitorAuthImpl
import java.util.*

class MainMenuImpl(
    private val authService: AuthService,
    //private val userDao: UserDao,
    private val menuDao: MenuDao,
    private val AdminService: AdminService,
    //private val ordersDao: OrdersDao
) : MainMenu {
    private val scanner = Scanner(System.`in`)

    override fun run() {
        val menu = ConsoleMenu()
        var choice: Int

        do {
            menu.displayMenu()
            choice = scanner.nextInt()

            when (choice) {
                1 -> handleViewMenu()
                2 -> handleVisitorAuth()
                3 -> handleAdminAuth()
                4 -> System.exit(0)
                else -> println("Invalid choice. Please enter a number between 1 and 3.")
            }
        } while (choice != 3)
    }

    override fun handleViewMenu() {
        val menuItems = menuDao.getAllItems()
        if (menuItems.isEmpty()) {
            println("Menu is empty")
            return
        }
        for (menuItem in menuItems) {
            println(menuItem)
        }
    }

    override fun handleVisitorAuth() {
        val visitorAuth = VisitorAuthImpl()
        visitorAuth.run()

    }
    override fun handleAdminAuth() {
        val adminAuth = AdminAuthImpl(authService, AdminService, menuDao)
        adminAuth.run()
    }
    override fun handleRegistration() {
        var role: Role? = null
        while (role == null) {
            try {
                println("Enter role (VISITOR or ADMIN):")
                role = Role.valueOf(scanner.next().uppercase())
            } catch (e: IllegalArgumentException) {
                println("Invalid role name. Please enter VISITOR or ADMIN. (uppercase or lowercase)")
            }
        }

        println("Enter username:")
        val username = scanner.next()
        println("Enter password:")
        val password = scanner.next()

        val result = authService.register(username, password, role)
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

        val user = authService.login(username, password)
        if (user != null) {
            println("Authentication successful!")
        } else {
            println("Authentication failed!")
        }
    }

}