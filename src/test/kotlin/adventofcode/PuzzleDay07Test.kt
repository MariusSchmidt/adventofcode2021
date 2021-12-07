package adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PuzzleDay07Test {

    private val day = 7
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    fun findMostCentralPointForCrabsToRallySample() {
        val rallyPlace = PuzzleDay07().findMostCentralPointForCrabsToRally(testfile, true)
        assertThat(rallyPlace).isEqualTo(2 to 37)
    }

    @Test
    fun findMostCentralPointForCrabsToRally() {
        val rallyPlace = PuzzleDay07().findMostCentralPointForCrabsToRally(datafile, true)
        assertThat(rallyPlace).isEqualTo(337 to 342641)
    }

    @Test
    fun findImprovedMostCentralPointForCrabsToRallySample() {
        val rallyPlace = PuzzleDay07().findMostCentralPointForCrabsToRally(testfile, false)
        assertThat(rallyPlace).isEqualTo(5 to 168)
    }

    @Test
    fun findImprovedMostCentralPointForCrabsToRally() {
        val rallyPlace = PuzzleDay07().findMostCentralPointForCrabsToRally(datafile, false)
        assertThat(rallyPlace).isEqualTo(470 to 93006301)
    }
}