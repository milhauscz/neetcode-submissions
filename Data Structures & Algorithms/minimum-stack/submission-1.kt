class MinStack() {
    private val stack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        val min = minStack.lastOrNull()
        minStack.add(min(min ?: `val`, `val`))
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
