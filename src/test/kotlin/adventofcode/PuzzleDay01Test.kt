package adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PuzzleDay01Test {

    private val day = 1
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    fun countDepthIncreaseSample() {
        assertEquals(7, PuzzleDay01().countDepthIncrease(testfile))
    }

    @Test
    fun countDepthIncreasePuzzle() {
        assertEquals(1557, PuzzleDay01().countDepthIncrease(datafile))
    }

    @Test
    fun countDepthIncreaseGroupedSample() {
        assertEquals(5, PuzzleDay01().countDepthIncreaseGrouped(testfile))
    }

    @Test
    fun countDepthIncreaseGroupedPuzzle() {
        assertEquals(1608, PuzzleDay01().countDepthIncreaseGrouped(datafile))
    }

}