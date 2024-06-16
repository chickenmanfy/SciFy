package chickenmanfy.scify.Modules

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