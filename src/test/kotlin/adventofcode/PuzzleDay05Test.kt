package adventofcode

import adventofcode.PuzzleDay05.LineSpecParser
import adventofcode.PuzzleDay05.Vector2D
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


internal class PuzzleDay05Test {

    private val day = 5
    private val testfile = FileHelper.testfile(day)
    private val datafile = FileHelper.datafile(day)

    @Test
    internal fun determineDangerousVentsStraightOnlySample() {
        val dangerousVents = PuzzleDay05().calculateVentPositions(testfile, true).filter { entry ->
            entry.value > 1
        }.keys
        softAssert {
            assertThat(dangerousVents).containsExactlyInAnyOrder(
                Vector2D(0, 9),
                Vector2D(1, 9),
                Vector2D(2, 9),
                Vector2D(7, 4),
                Vector2D(3, 4)
            )
        }
    }

    @Test
    internal fun determineDangerousStraightOnlyVents() {
        val dangerousVents = PuzzleDay05().calculateVentPositions(datafile, true).filter { entry ->
            entry.value > 1
        }.keys
        assertThat(dangerousVents).hasSize(6856)
    }

    @Test
    internal fun determineDangerousVents() {
        val dangerousVents = PuzzleDay05().calculateVentPositions(datafile,).filter { entry ->
            entry.value > 1
        }.keys
        assertThat(dangerousVents).hasSize(20666)
    }

    @Test
    internal fun lineSpecParse() {
        val startAndEnd = LineSpecParser.parse("464,762 -> 592,762")
        softAssert {
            assertThat(startAndEnd.first).isEqualTo(Vector2D(464, 762))
            assertThat(startAndEnd.second).isEqualTo(Vector2D(592, 762))
        }
    }

    @Test
    internal fun lineSpecsParse() {
        val pairs = LineSpecParser.parse(sequenceOf("464,762 -> 592,762", "6,4 -> 2,0"))
        softAssert {
            assertThat(pairs.toList()).containsExactlyElementsOf(
                listOf(
                    Vector2D(464, 762) to Vector2D(592, 762),
                    Vector2D(6, 4) to Vector2D(2, 0),
                )
            )
        }
    }

    @Test
    internal fun vectorAddition() {
        val a = Vector2D(-1, 0)
        val b = Vector2D(3, -2)
        assertThat(a + b).isEqualTo(Vector2D(2, -2))
    }


    @Test
    internal fun expandToPositionsVerticalIncrease() {
        val a = Vector2D(0, 0)
        val b = Vector2D(0, 2)
        val positions = a.pathTo(b)
        softAssert {
            assertThat(positions.toList()).containsExactlyElementsOf(
                listOf(
                    Vector2D(0, 0),
                    Vector2D(0, 1),
                    Vector2D(0, 2)
                )
            )
        }
    }

    @Test
    internal fun expandToPositionsVerticalDecrease() {
        val a = Vector2D(0, 2)
        val b = Vector2D(0, 0)
        val positions = a.pathTo(b)
        softAssert {
            assertThat(positions.toList()).containsExactlyElementsOf(
                listOf(
                    Vector2D(0, 2),
                    Vector2D(0, 1),
                    Vector2D(0, 0)
                )
            )
        }
    }

    @Test
    internal fun expandToPositionsHorizontalIncrease() {
        val a = Vector2D(0, 0)
        val b = Vector2D(2, 0)
        val positions = a.pathTo(b)
        softAssert {
            assertThat(positions.toList()).containsExactlyElementsOf(
                listOf(
                    Vector2D(0, 0),
                    Vector2D(1, 0),
                    Vector2D(2, 0)
                )
            )
        }
    }

    @Test
    internal fun expandToPositionsHorizontalDecrease() {
        val a = Vector2D(2, 0)
        val b = Vector2D(0, 0)
        val positions = a.pathTo(b)
        softAssert {
            assertThat(positions.toList()).containsExactlyElementsOf(
                listOf(
                    Vector2D(2, 0),
                    Vector2D(1, 0),
                    Vector2D(0, 0)
                )
            )
        }
    }

    @Test
    internal fun expandToPositionsDiagonal() {
        val a = Vector2D(6, 4)
        val b = Vector2D(2, 0)
        val positions = a.pathTo(b)
        softAssert {
            assertThat(positions.toList()).containsExactlyElementsOf(
                listOf(
                    Vector2D(6, 4),
                    Vector2D(5, 3),
                    Vector2D(4, 2),
                    Vector2D(3, 1),
                    Vector2D(2, 0),
                )
            )
        }
    }
}