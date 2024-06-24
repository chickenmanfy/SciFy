package chickenmanfy.scify.modules

var barsToggle: Boolean = false
class Bars {
    fun toggleBars() {
        barsToggle = !barsToggle
        if (barsToggle) {
            bars()
        }
    }

    private fun bars() {
        println("Bars")
    }
}