package chickenmanfy.scify

object BridgeMixins {
    private var num0: Int = 0
    private var num1: Int = 0

    fun getNum0(): Int {
        return num0
    }
    fun getNum1(): Int {
        return num1
    }

    fun setNum0(number: Int) {
        num0 = number
    }
    fun setNum1(number: Int) {
        num1 = number
    }
}
