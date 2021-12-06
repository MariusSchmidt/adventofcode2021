
package adventofcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PuzzleDay04Test {

    private val day = 4
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    internal fun testBingoGameNotWon() {
        val bingo = PuzzleDay04.BingoBoard(1, IntArray(25) { i -> i + 1})
        (1 .. 25 step 2).forEach { bingo.drawNumber(it) }
        assertFalse(bingo.won)
    }

    @Test
    internal fun testBingoGameWonInLastColumn() {
        val bingo = PuzzleDay04.BingoBoard(1, IntArray(25) { i -> i + 1})
        bingo.drawNumber(1)
        ( 5 .. 25 step 5).forEach {
            bingo.drawNumber(it)
        }
        bingo.drawNumber(2)
        assertTrue(bingo.won)
        assertEquals(6, bingo.drawsToWin)
        assertEquals(25, bingo.lastNumber)
        assertEquals(6225, bingo.score())
    }

    @Test
    internal fun testBingoGameWonInLastRow() {
        val bingo = PuzzleDay04.BingoBoard(1, IntArray(25) { i -> i + 1})
        bingo.drawNumber(1)
        bingo.drawNumber(2)
        (21 .. 25).forEach {
            bingo.drawNumber(it)
        }
        assertTrue(bingo.won)
        assertEquals(7, bingo.drawsToWin)
        assertEquals(25, bingo.lastNumber)
        assertEquals(5175, bingo.score())
    }

    @Test
    internal fun determineFirstWinningBoardSample() {
        val board = PuzzleDay04().determineWinningBoardOrder(testfile).first()
        assertEquals(3, board.id)
        assertEquals(12, board.drawsToWin)
        assertEquals(4512, board.score())
    }

    @Test
    internal fun determineFirstWinningBoard() {
        val board = PuzzleDay04().determineWinningBoardOrder(datafile).first()
        assertEquals(44, board.id)
        assertEquals(22, board.drawsToWin)
        assertEquals(58374, board.score())
    }

    @Test
    internal fun determineLastWinningBoardSample() {
        val board = PuzzleDay04().determineWinningBoardOrder(testfile).last()
        assertEquals(2, board.id)
        assertEquals(15, board.drawsToWin)
        assertEquals(1924, board.score())
    }

    @Test
    internal fun determineLastWinningBoard() {
        val board = PuzzleDay04().determineWinningBoardOrder(datafile).last()
        assertEquals(17, board.id)
        assertEquals(82, board.drawsToWin)
        assertEquals(11377, board.score())
    }
}