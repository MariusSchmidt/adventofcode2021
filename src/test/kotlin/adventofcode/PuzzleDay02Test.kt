package adventofcode

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


internal class PuzzleDay02Test {

    private val day = 2
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    fun moveSubmarineSample() {
        val position = PuzzleDay02().moveSubmarine(testfile)
        assertThat(position).isEqualTo(15 to 10)
    }

    @Test
    fun moveSubmarine() {
        val position = PuzzleDay02().moveSubmarine(datafile)
        softAssert {
            assertThat(position).isEqualTo(2010 to 1030)
            assertThat(position.first * position.second).isEqualTo(2070300)
        }
    }

    @Test
    fun moveAimedSubmarineSample() {
        val position = PuzzleDay02().moveAimedSubmarine(testfile)
        assertThat(position).isEqualTo(Triple(15, 60, 10))
    }

    @Test
    fun moveAimedSubmarine() {
        val position = PuzzleDay02().moveAimedSubmarine(datafile)
        softAssert {
            assertThat(position).isEqualTo(Triple(2010, 1034321, 1030))
            assertThat(position.first * position.second).isEqualTo(2078985210)
        }
    }
}