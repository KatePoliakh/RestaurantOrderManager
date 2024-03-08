package domain.service.order

class OrderProcessingServiceImpl : OrderProcessingService {
    override fun processOrder() {
        println("Order is being processed")
    }

    override fun cancelOrder() {
        println("Order is being cancelled")
    }

    override fun payOrder() {
        println("Order is being paid")
    }

    override fun viewOrder() {
        println("Order is being viewed")
    }

    override fun viewMenu() {
        println("Menu is being viewed")
    }

    override fun addItem() {
        println("Item is being added")
    }

    override fun removeItem() {
        println("Item is being removed")
    }

    override fun updateItem() {
        println("Item is being updated")
    }
}