package chickenmanfy.scify.modules

var barsToggle: Boolean = false
class Bars {
    fun toggleBars() {
        barsToggle = !barsToggle
    }

    fun bars() {
        if (barsToggle) {
            return
        }
    }
}