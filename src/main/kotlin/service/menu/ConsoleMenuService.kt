package service.menu

interface ConsoleMenuService {
    fun run()
    fun handleRegistration()
    fun handleAuthentication()
    fun handleGetAllUsers() // убрать позже
}