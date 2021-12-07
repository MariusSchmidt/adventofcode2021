package adventofcode

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


internal class PuzzleDay03Test {

    private val day = 3
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    fun readGammaAndEpsilonSample() {
        assertThat(PuzzleDay03(5).readGammaAndEpsilon(testfile)).isEqualTo(22 to 9)
    }

    @Test
    fun readGammaAndEpsilon() {
        val gammaAndEpsilon = PuzzleDay03(12).readGammaAndEpsilon(datafile)
        softAssert {
            assertThat(gammaAndEpsilon).isEqualTo(190 to 3905)
            assertThat(gammaAndEpsilon.first * gammaAndEpsilon.second).isEqualTo(741950)
        }
    }

    @Test
    fun readOxigenGeneratorRatingSample() {
        val rating = PuzzleDay03(5).readOxygenScrubberRatings(testfile)
        assertThat(rating).isEqualTo(23)
    }

    @Test
    fun readCO2GeneratorRatingSample() {
        val rating = PuzzleDay03(5).readCO2ScrubberRatings(testfile)
        assertThat(rating).isEqualTo(10)
    }

    @Test
    fun readLifeSupportRatingSample() {
        val rating = PuzzleDay03(5).readLifeSupportRating(testfile)
        assertThat(rating).isEqualTo(230)
    }

    @Test
    fun readOxigenGeneratorRating() {
        val rating = PuzzleDay03(12).readOxygenScrubberRatings(datafile)
        assertThat(rating).isEqualTo(282)
    }

    @Test
    fun readCO2GeneratorRating() {
        val rating = PuzzleDay03(12).readCO2ScrubberRatings(datafile)
        assertThat(rating).isEqualTo(3205)
    }

    @Test
    fun readLifeSupportRating() {
        val rating = PuzzleDay03(12).readLifeSupportRating(datafile)
        assertThat(rating).isEqualTo(903810)
    }
}