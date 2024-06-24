package chickenmanfy.scify.modules

var autoWelcomeToggle: Boolean = false
class AutoWelcome {
    fun toggleAutoWelcome() {
        autoWelcomeToggle = !autoWelcomeToggle
        if (autoWelcomeToggle) {
            autoWelcome()
        }
    }

    private fun autoWelcome() {
        println("Auto Welcome")
    }
}