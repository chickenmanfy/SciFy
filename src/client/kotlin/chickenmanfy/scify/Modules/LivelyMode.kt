package chickenmanfy.scify.Modules

var livelyModeToggle: Boolean = false
class LivelyMode() {
    fun toggleLivelyMode() {
        livelyModeToggle = !livelyModeToggle
        if (livelyModeToggle) {
            livelyMode()
        }
    }

    private fun livelyMode() {
        println("Lively Mode")
    }
}