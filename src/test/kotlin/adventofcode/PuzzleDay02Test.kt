package adventofcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class PuzzleDay02Test {

    private val day = 2
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    fun moveSubmarineSample() {
        assertEquals(15 to 10, PuzzleDay02().moveSubmarine(testfile))
    }

    @Test
    fun moveSubmarine() {
        val position = PuzzleDay02().moveSubmarine(datafile)
        assertEquals(2010 to 1030, position)
        assertEquals(2070300, position.first * position.second)
    }

    @Test
    fun moveAimedSubmarineSample() {
        assertEquals(Triple(15, 60, 10), PuzzleDay02().moveAimedSubmarine(testfile))
    }

    @Test
    fun moveAimedSubmarine() {
        val position = PuzzleDay02().moveAimedSubmarine(datafile)
        assertEquals(Triple(2010, 1034321, 1030), position)
        assertEquals(2078985210, position.first * position.second)
    }
}