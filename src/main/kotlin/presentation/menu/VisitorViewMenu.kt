package presentation.menu

import java.util.*

interface VisitorMenu {
    fun run()
    fun handleViewMenu()
    fun handlePlaceOrder()
}

class VisitorMenuImpl : VisitorMenu {
    private val scanner = Scanner(System.`in`)

    override fun run() {
        var choice: Int

        do {
            displayMenu()
            choice = scanner.nextInt()

            when (choice) {
                1 -> handleViewMenu()
                2 -> handlePlaceOrder()
            }
        } while (choice != 3)
    }

    private fun displayMenu() {
        println("1. View Menu")
        println("2. Place Order")
        println("3. Exit")
    }

    override fun handleViewMenu() {
        // Code to display the menu
    }

    override fun handlePlaceOrder() {
        // Code to place an order
    }
}