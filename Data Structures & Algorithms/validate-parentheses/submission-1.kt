class Solution {
    fun isValid(s: String): Boolean {
        val parenthesisStack = ArrayDeque<Char>()
        for (char in s) {
            if (!char.isParenthesis()) continue
            if (char.isOpenParenthesis()) {
                parenthesisStack.addLast(char)
            } else {
                // char is closing parenthesis
                val lastOpened = if (parenthesisStack.isEmpty()) null else parenthesisStack.removeLast()
                if (lastOpened == null || lastOpened != char.toOpenParenthesis()) return false
            }
        }
        return parenthesisStack.isEmpty()
    }

    fun Char.isParenthesis(): Boolean {
        return when(this) {
            '(',')','{','}','[',']' -> true
            else -> false
        }
    }

    fun Char.isOpenParenthesis(): Boolean {
        return when(this) {
            '(','{','[' -> true
            else -> false
        }
    }

    fun Char.toOpenParenthesis(): Char {
        return when(this) {
            ')' -> '('
            '}' -> '{'
            ']' -> '['
            else -> throw IllegalStateException("This is not a parenthesis")
        }
    }
}
