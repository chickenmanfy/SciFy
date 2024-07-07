package chickenmanfy.scify

object BridgeMixins {
    private var num0: Int = 0
    private var num1: Int = 0

    fun getNum0(): Int {
        return num0
    }

    fun getStrNum0(): String {
        return num0.toString()
    }
    fun getStrNum1(): String {
        val strNum1 = num1 + 20
        return strNum1.toString()
    }

    fun setNum0(number: Int) {
        num0 = number
    }
    fun setNum1(number: Int) {
        num1 = number
    }
}
