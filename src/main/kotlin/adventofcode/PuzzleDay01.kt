package adventofcode

import java.io.File

class PuzzleDay01 {

    fun countDepthIncrease(input: File): Int = input.useLines { seq ->
        seq.map { it.toInt() }
            .windowed(2)
            .map { it[1] - it[0] }
            .count { it > 0 }
    }

    fun countDepthIncreaseGrouped(input: File): Int = input.useLines { seq ->
        seq.map { it.toInt() }
            .windowed(3)
            .map { it[0] + it[1] +it[2] }
            .windowed(2)
            .map { it[1] - it[0] }
            .count { it > 0 }
    }

}