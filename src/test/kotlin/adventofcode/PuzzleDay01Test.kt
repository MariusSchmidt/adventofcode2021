package adventofcode

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

internal class PuzzleDay01Test {

    private val day = 1
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    fun countDepthIncreaseSample() {
        val increase = PuzzleDay01().countDepthIncrease(testfile)
        assertThat(increase).isEqualTo(7)
    }

    @Test
    fun countDepthIncreasePuzzle() {
        val increase = PuzzleDay01().countDepthIncrease(datafile)
        assertThat(increase).isEqualTo(1557)
    }

    @Test
    fun countDepthIncreaseGroupedSample() {
        val increase = PuzzleDay01().countDepthIncreaseGrouped(testfile)
        assertThat(increase).isEqualTo(5)
    }

    @Test
    fun countDepthIncreaseGroupedPuzzle() {
        val increase = PuzzleDay01().countDepthIncreaseGrouped(datafile)
        assertThat(increase).isEqualTo(1608)
    }

}