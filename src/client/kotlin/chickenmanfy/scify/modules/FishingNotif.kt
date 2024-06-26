package chickenmanfy.scify.modules

var fishingToggle: Boolean = false
class FishingNotif {
    // Fishing Notification Toggle
    fun toggleFishingNotif() {
        fishingToggle = !fishingToggle
        if (fishingToggle) {
            fishingNotif()
        }
    }


    // Code in Menu.kt:
    // toggleFishingNotif()

    private fun fishingNotif() {
        return
    }
}