package adventofcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class PuzzleDay03Test {

    private val day = 3
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    fun readGammaAndEpsilonSample() {
        assertEquals(22 to 9, PuzzleDay03(5).readGammaAndEpsilon(testfile))
    }

    @Test
    fun readGammaAndEpsilon() {
        val gammaAndEpsilon = PuzzleDay03(12).readGammaAndEpsilon(datafile)
        assertEquals(190 to 3905, gammaAndEpsilon)
        assertEquals(741950, gammaAndEpsilon.first * gammaAndEpsilon.second)
    }

    @Test
    fun readOxigenGeneratorRatingSample() {
        val rating = PuzzleDay03(5).readOxygenScrubberRatings(testfile)
        assertEquals(23, rating)
    }

    @Test
    fun readCO2GeneratorRatingSample() {
        val rating = PuzzleDay03(5).readCO2ScrubberRatings(testfile)
        assertEquals(10, rating)
    }

    @Test
    fun readLifeSupportRatingSample() {
        val rating = PuzzleDay03(5).readLifeSupportRating(testfile)
        assertEquals(230, rating)
    }

    @Test
    fun readOxigenGeneratorRating() {
        val rating = PuzzleDay03(12).readOxygenScrubberRatings(datafile)
        assertEquals(282, rating)
    }

    @Test
    fun readCO2GeneratorRating() {
        val rating = PuzzleDay03(12).readCO2ScrubberRatings(datafile)
        assertEquals(3205, rating)
    }

    @Test
    fun readLifeSupportRating() {
        val rating = PuzzleDay03(12).readLifeSupportRating(datafile)
        assertEquals(903810, rating)
    }
}