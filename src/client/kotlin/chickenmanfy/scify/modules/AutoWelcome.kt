package chickenmanfy.scify.modules

var autoWelcomeToggle: Boolean = false
class AutoWelcome {
    fun toggleAutoWelcome() {
        autoWelcomeToggle = !autoWelcomeToggle
    }

    fun autoWelcome() {
        if (autoWelcomeToggle) {
            return
        }
    }
}