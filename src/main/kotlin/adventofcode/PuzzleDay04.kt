package adventofcode

import java.io.File

class PuzzleDay04 {


    fun determineFirstWinningBoard(file: File): BingoBoard {
        val pulls = readPulls(file)
        val boards = readBoards(file)
        val first = pulls.flatMap { pulledNumber ->
                boards.onEach { it.drawNumber(pulledNumber) }.filter { it.won }
            }.first()
        return first
    }

    private fun readPulls(file: File): List<Int> = file.useLines { seq ->
        seq.first().split(",").map { it.toInt() }
    }

    private fun readBoards(file: File): List<BingoBoard> = file.useLines { seq ->
        seq.drop(2)
            .flatMap { it.split(" ") }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .windowed(25, 25)
            .mapIndexed { index, boardNumbers -> BingoBoard(index + 1, boardNumbers.toIntArray()) }
            .toList()
    }


    class BingoBoard(val id: Int, numbers: IntArray) {

        companion object {
            const val X_SIZE = 5
            const val Y_SIZE = 5
            const val WINNING_COUNT = 5
        }

        private val fields: Array<BingoBoardField> = numbers.map { BingoBoardField(it) }.toTypedArray()
        var won: Boolean = false
        var drawsToWin: Int = 0
        var lastNumber: Int = -1

        fun score(): Int = if (!won) 0 else fields.filter { !it.pulled }.sumOf { it.number } * lastNumber

        fun drawNumber(number: Int) {
            if (won) return
            fields.filter { it.number == number }.onEach { it.pulled = true }
            drawsToWin++
            won = checkWon()
            lastNumber = number
        }

        private fun checkWon(): Boolean =
            ((0 until X_SIZE).map { columnFields(it) } + (0 until Y_SIZE).map { rowFields(it) }).any { it.checkWon() }

        private fun List<BingoBoardField>.checkWon(): Boolean = count { it.pulled } >= WINNING_COUNT

        private fun rowFields(rowIndex: Int): List<BingoBoardField> =
            fields.slice(rowIndex * X_SIZE until rowIndex * X_SIZE + X_SIZE)

        private fun columnFields(columnIndex: Int): List<BingoBoardField> =
            fields.slice(columnIndex until X_SIZE * Y_SIZE step X_SIZE)

    }

    class BingoBoardField(val number: Int) {
        var pulled: Boolean = false
    }
}