    package presentation.menu.admin
    import domain.entity.MenuItem
import domain.service.InputValidator
import domain.service.admin.AdminService

    class AdminViewMenuImpl(
        private val adminService: AdminService,
        //private val menuDao: MenuDao,
        private val inputValidator: InputValidator
    ) : AdminViewMenu {

        override fun run() {
            var choice: Int
            do {
                println("===Admin menu===")
                handleMenu(
                    listOf("View Menu", "Manage Menu", "Manage Orders", "Back to main menu", "Exit"),
                    listOf({ handleViewMenu() }, { handleManageMenu() }, { handleManageOrders() }, { return@listOf }, { return@listOf })
                )
                choice = inputValidator.readInt()
            } while (choice != 5)
        }

        private fun displayMenu(options: List<String>) {
            options.forEachIndexed { index, option ->
                println("${index + 1}. $option")
            }
        }

        private fun handleMenu(options: List<String>, actions: List<() -> Unit>) {
            var choice: Int
            do {
                displayMenu(options)
                choice = inputValidator.readInt()
                actions.getOrNull(choice - 1)?.invoke()
            } while (choice != options.size)
        }

        override fun handleViewMenu() {
            adminService.viewMenu()
        }

        override fun handleManageMenu() {
            println("===Admin menu===")
            handleMenu(
                listOf("View Menu", "Add dish", "Remove dish", "Update dish", "Back to main menu"),
                listOf({ adminService.viewMenu() }, { handleDishOperation { adminService.addItem(it) } }, { handleDishOperation { adminService.removeItem(it) } }, { handleDishOperation { adminService.updateItem(it) } } , { return@listOf})
            )
        }

        private fun handleManageOrders() {
            println("===Admin menu===")
            handleMenu(
                listOf("View Orders", "Update Order", "Remove Order", "Back to main menu"),
                listOf({ /* adminService.viewOrders() */ }, { /* handleUpdateOrder() */ }, { /* handleRemoveOrder() */ })
            )
        }

        private fun handleDishOperation(operation: (MenuItem) -> Unit) {
            println("Enter dish name:")
            val dishName = inputValidator.readString()
            println("Enter dish quantity:")
            val dishQuantity = inputValidator.readInt()
            println("Enter dish price:")
            val dishPrice = inputValidator.readDouble()
            println("Enter dish complexity:")
            val dishPreparationTime = inputValidator.readInt()
            val menuItem = MenuItem(dishName, dishQuantity, dishPrice, dishPreparationTime)
            operation(menuItem)
        }
    }