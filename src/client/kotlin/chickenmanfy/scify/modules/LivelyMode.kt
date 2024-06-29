package chickenmanfy.scify.modules

var livelyModeToggle: Boolean = false
class LivelyMode {
    fun toggleLivelyMode() {
        livelyModeToggle = !livelyModeToggle
    }

    fun livelyMode() {
        if (livelyModeToggle) {
            return
        }
    }
}