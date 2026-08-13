class Solution {
    private val separatorRegex = Regex("\\|")
    private val escapedSeparatorRegex = Regex("\\\\\\|")
    private val unescapedSeparatorRegex = Regex("(?<!\\\\)\\|")

    fun encode(strs: List<String>): String {
        if (strs.isEmpty()) return ""
        val sb = StringBuilder()
        for(i in 0..<strs.size) {
            sb.append("|")
            sb.append(escape(strs[i]))
        }
        sb.append("|")
        return sb.toString()
    }

    fun escape(str: String): String {
        return str.replace(separatorRegex, "\\\\|")
    }

    fun unescape(str: String): String {
        return str.replace(escapedSeparatorRegex, "|")
    }

    fun decode(str: String): List<String> {
        if (str.isEmpty()) return emptyList()
        return str.substring(1, str.length - 1).split(unescapedSeparatorRegex).map { unescape(it) }
    }
}
