class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val operandsStack = ArrayDeque<Int>()
        for(token in tokens) {
            if (token.isOperator()) {
                val b = operandsStack.removeLast()
                val a = operandsStack.removeLast()
                operandsStack.addLast(token.toOperation()(a, b))
            } else {
                operandsStack.addLast(token.toInt())
            }
        }
        return operandsStack.last()
    }

    fun String.isOperator(): Boolean = when(this) {
        "+", "-", "*", "/" -> true
        else -> false
    }

    fun String.toOperation(): (a: Int, b: Int) -> Int = when(this) {
        "+" -> { a, b -> a + b }
        "-" -> { a, b -> a - b }
        "*" -> { a, b -> a * b }
        "/" -> { a, b -> a / b }
        else -> throw IllegalStateException("Not an operand.")
    }
}
