package presentation.menu.visitor

interface VisitorAuth {
    fun run()
    fun handleVisitorRegistration()
    fun handleVisitorAuthentication()
}