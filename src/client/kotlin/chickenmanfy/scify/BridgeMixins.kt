package chickenmanfy.scify

object BridgeMixins {
    private var num0: Int = 0
    private var num1: Int = 0

    fun getNum0(): Int {
        return num0
    }

    fun getStrNum0(): String {
        if (num0 != 0) {
            return num0.toString()
        }
        return "1"
    }
    fun getStrNum1(): String {
        if (num1 != 0) {
            val strNum1 = num1 + 20
            return strNum1.toString()
        }
        return "1"
    }

    fun setNum0(number: Int) {
        num0 = number
    }
    fun setNum1(number: Int) {
        num1 = number
    }
}
