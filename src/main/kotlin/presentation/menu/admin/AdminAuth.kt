package presentation.menu.admin

interface AdminAuth {
    fun run()
    fun handleAdminAuth()
    fun handleAdminRegistration()
    fun handleAdminAuthentication()
}