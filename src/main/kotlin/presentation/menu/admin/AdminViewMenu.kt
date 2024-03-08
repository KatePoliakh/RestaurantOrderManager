package presentation.menu.admin
import data.dao.MenuDao
import domain.entity.MenuItem
import domain.service.admin.AdminService
import java.util.*

interface AdminMenu {
    fun run()
    fun handleViewMenu()
    fun handleAddDish()
    fun handleRemoveDish()
    fun handleUpdateDish()
}

class AdminMenuImpl(private val adminService: AdminService,
                    private val menu: MenuDao
) : AdminMenu {

    private val scanner = Scanner(System.`in`)
    override fun run() {
        var choice: Int

        do {
            displayMainMenu()
            choice = scanner.nextInt()

            when (choice) {
                1 -> handleViewMenu()
                2 -> displayMenuMenu()
                3 -> displayOrdersMenu()
            }
        } while (choice != 4)
    }

    private fun displayMainMenu() {
        println("===Admin menu===")
        println("1. View Menu")
        println("2. Manage Menu")
        println("3. Manage Orders")
        println("4. Exit")
    }

    private fun displayMenuMenu() {
        println("===Menu Manager===")
        println("1. View Menu")
        println("2. Add dish")
        println("3. Remove dish")
        println("4. Update dish")
        println("5. Back to main menu")

    }
    private fun displayOrdersMenu() {
        println("===Orders Manager===")
        println("1. View Orders")
        println("2. Update Order")
        println("3. Remove Order")
        println("4. Back to main menu")
    }
    override fun handleViewMenu() {
        displayMenuMenu()
        var choice: Int
        do {
            choice = scanner.nextInt()
            when (choice) {
                1 -> adminService.viewMenu()
                2 -> handleAddDish()
                3 -> handleRemoveDish()
                4 -> handleUpdateDish()
            }
        } while (choice != 5)
    }

    override fun handleAddDish() { // реализация новой функции
        println("Enter dish name:")
        val dishName = scanner.nextLine()
        println("Enter dish quantity:")
        val dishQuantity = scanner.nextInt()
        println("Enter dish price:")
        val dishPrice = scanner.nextDouble()
        println("Enter dish complexity:")
        val dishPreparationTime = scanner.nextInt()
        val menuItem = MenuItem(dishName, dishQuantity, dishPrice, dishPreparationTime)
        adminService.addItem(menuItem)
    }
    override fun handleRemoveDish() {
        println("Enter the name of the dish you want to remove:")
        val itemName = scanner.nextLine()
        val menuItem = menu.getMenuItemByName(itemName)
        adminService.removeItem(menuItem!!)
        // expeption - если блюда нет в меню - выдать ошибку и вернуться в меню
    }
    override fun handleUpdateDish() {
        println("Enter the name of the dish you want to update:")
        val dishName = scanner.nextLine()
        println("Enter the new quantity of the dish:")
        val dishQuantity = scanner.nextInt()
        println("Enter the new price of the dish:")
        val dishPrice = scanner.nextDouble()
        println("Enter the new complexity of the dish:")
        val dishPreparationTime = scanner.nextInt()
        val menuItem = MenuItem(dishName, dishQuantity, dishPrice, dishPreparationTime)
        adminService.updateItem(menuItem)
        // expeption - если блюда нет в меню - выдать ошибку и вернуться в меню
    }
}