package presentation.menu.visitor

class VisitorAuthImpl() : VisitorAuth {
    override fun run() {
        println("VisitorAuthImpl.run")
    }

    override fun handleVisitorRegistration() {
        println("VisitorAuthImpl.handleVisitorRegistration")
    }

    override fun handleVisitorAuthentication() {
        println("VisitorAuthImpl.handleVisitorAuthentication")
    }

}