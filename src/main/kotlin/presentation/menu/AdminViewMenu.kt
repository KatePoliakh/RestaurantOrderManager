package presentation.menu
import service.admin.AdminServiceImpl
import java.util.*

interface AdminMenu {
    fun run()
    fun handleManageUsers()
    fun handleManageOrders()
}

class AdminMenuImpl(private val adminService: AdminServiceImpl) : AdminMenu {
    private val scanner = Scanner(System.`in`)

    override fun run() {
        var choice: Int

        do {
            displayMenu()
            choice = scanner.nextInt()

            when (choice) {
                1 -> handleManageUsers()
                2 -> handleManageOrders()
            }
        } while (choice != 3)
    }

    private fun displayMenu() {
        println("1. Manage Users")
        println("2. Manage Orders")
        println("3. Exit")
    }

    override fun handleManageUsers() {
        adminService.manageUsers()
    }

    override fun handleManageOrders() {
        adminService.manageOrders()
    }
} {
}