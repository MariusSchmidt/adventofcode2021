package adventofcode

import adventofcode.PuzzleDay06.Lanternfish
import adventofcode.PuzzleDay06.Ocean
import kotlin.test.Test

internal class PuzzleDay06Test {

    private val day = 6
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    internal fun oceanOfFirstGenerationSample() {
        val ocean = Ocean.populate(testfile)
        softAssert {
            assertThat(ocean.oceanMap).containsExactlyInAnyOrderEntriesOf(
                mapOf(
                    Lanternfish(1) to 1,
                    Lanternfish(2) to 1,
                    Lanternfish(3) to 2,
                    Lanternfish(4) to 1
                )
            )
            assertThat(ocean.countFishes()).isEqualTo(5)
        }
    }

    @Test
    internal fun oceanOfEighteensGenerationSample() {
        val ocean = Ocean.populate(testfile)
        (0 until 18).onEach {
            ocean.oldenOneDay()
        }
        softAssert {
            assertThat(ocean.oceanMap).containsExactlyInAnyOrderEntriesOf(
                mapOf(
                    Lanternfish(0) to 3,
                    Lanternfish(1) to 5,
                    Lanternfish(2) to 3,
                    Lanternfish(3) to 2,
                    Lanternfish(4) to 2,
                    Lanternfish(5) to 1,
                    Lanternfish(6) to 5,
                    Lanternfish(7) to 1,
                    Lanternfish(8) to 4,
                )
            )
            assertThat(ocean.countFishes()).isEqualTo(26)
        }
    }

    @Test
    internal fun oceanOfEightyGenerationSample() {
        val ocean = Ocean.populate(testfile)
        (0 until 80).onEach {
            ocean.oldenOneDay()
        }
        softAssert {
            assertThat(ocean.countFishes()).isEqualTo(5934)
        }
    }

    @Test
    internal fun oceanOfEightyGeneration() {
        val ocean = Ocean.populate(datafile)
        (0 until 256).onEach {
            ocean.oldenOneDay()
        }
        softAssert {
            assertThat(ocean.countFishes()).isEqualTo(376194)
        }
    }

    @Test
    internal fun oceanOf256GenerationSample() {
        val ocean = Ocean.populate(testfile)
        (0 until 256).onEach {
            ocean.oldenOneDay()
        }
        softAssert {
            assertThat(ocean.countFishes()).isEqualTo(26984457539)
        }
    }

    @Test
    internal fun oceanOf256Generation() {
        val ocean = Ocean.populate(datafile)
        (0 until 256).onEach {
            ocean.oldenOneDay()
        }
        softAssert {
            assertThat(ocean.countFishes()).isEqualTo(1693022481538)
        }
    }

}