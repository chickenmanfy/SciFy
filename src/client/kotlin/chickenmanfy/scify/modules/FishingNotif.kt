package chickenmanfy.scify.modules

var fishingToggle: Boolean = false
class FishingNotif {
    // Fishing Notification Toggle
    fun toggleFishingNotif() {
        fishingToggle = !fishingToggle
    }


    // Code in Menu.kt:
    // toggleFishingNotif()

    fun fishingNotif() {
        if (fishingToggle) {
            return
        }
    }
}