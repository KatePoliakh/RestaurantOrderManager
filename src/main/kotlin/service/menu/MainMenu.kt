package service.menu

interface MainMenu {
    fun run()
    fun handleRegistration()
    fun handleAuthentication()
    fun handleGetAllUsers() // убрать позже
}