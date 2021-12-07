
package adventofcode

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

internal class PuzzleDay04Test {

    private val day = 4
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    internal fun testBingoGameNotWon() {
        val bingo = PuzzleDay04.BingoBoard(1, IntArray(25) { i -> i + 1})
        (1 .. 25 step 2).forEach { bingo.drawNumber(it) }
        assertThat(bingo.won).isFalse
    }

    @Test
    internal fun testBingoGameWonInLastColumn() {
        val bingo = PuzzleDay04.BingoBoard(1, IntArray(25) { i -> i + 1})
        bingo.drawNumber(1)
        ( 5 .. 25 step 5).forEach {
            bingo.drawNumber(it)
        }
        bingo.drawNumber(2)
        softAssert {
            assertThat(bingo.won).isTrue
            assertThat(bingo.drawsToWin).isEqualTo(6)
            assertThat(bingo.lastNumber).isEqualTo(25)
            assertThat(bingo.score()).isEqualTo(6225)
        }
    }

    @Test
    internal fun testBingoGameWonInLastRow() {
        val bingo = PuzzleDay04.BingoBoard(1, IntArray(25) { i -> i + 1})
        bingo.drawNumber(1)
        bingo.drawNumber(2)
        (21 .. 25).forEach {
            bingo.drawNumber(it)
        }
        softAssert {
            assertThat(bingo.won).isTrue
            assertThat(bingo.drawsToWin).isEqualTo(7)
            assertThat(bingo.lastNumber).isEqualTo(25)
            assertThat(bingo.score()).isEqualTo(5175)
        }
    }

    @Test
    internal fun determineFirstWinningBoardSample() {
        val board = PuzzleDay04().determineWinningBoardOrder(testfile).first()
        softAssert {
            assertThat(board.id).isEqualTo(3)
            assertThat(board.drawsToWin).isEqualTo(12)
            assertThat(board.score()).isEqualTo(4512)
        }
    }

    @Test
    internal fun determineFirstWinningBoard() {
        val board = PuzzleDay04().determineWinningBoardOrder(datafile).first()
        softAssert {
            assertThat(board.id).isEqualTo(44)
            assertThat(board.drawsToWin).isEqualTo(22)
            assertThat(board.score()).isEqualTo(58374)
        }
    }

    @Test
    internal fun determineLastWinningBoardSample() {
        val board = PuzzleDay04().determineWinningBoardOrder(testfile).last()
        softAssert {
            assertThat(board.id).isEqualTo(2)
            assertThat(board.drawsToWin).isEqualTo(15)
            assertThat(board.score()).isEqualTo(1924)
        }
    }

    @Test
    internal fun determineLastWinningBoard() {
        val board = PuzzleDay04().determineWinningBoardOrder(datafile).last()
        softAssert {
            assertThat(board.id).isEqualTo(17)
            assertThat(board.drawsToWin).isEqualTo(82)
            assertThat(board.score()).isEqualTo(11377)
        }
    }
}