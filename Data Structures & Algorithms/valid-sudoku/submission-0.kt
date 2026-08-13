class Solution {
        fun isValidSudoku(board: Array<CharArray>): Boolean {
            val foundInSquare = Array(9) {
                hashSetOf<Char>()
            }
            for (i in 0..<9) {
                val foundInRow = hashSetOf<Char>()
                val foundInCol = hashSetOf<Char>()
                for (j in 0..<9) {
                    var char = board[i][j]
                    if (char != '.' && !foundInRow.add(char)) return false
                    if (char != '.' && !foundInSquare[j / 3 + i / 3 * 3].add(char)) return false
                    char = board[j][i]
                    if (char != '.' && !foundInCol.add(char)) return false
                }
            }
            return true
        }
}