package adventofcode

import java.io.File

class PuzzleDay02() {

    private val FORWARD = "forward "
    private val UP = "up "
    private val DOWN = "down "

    fun moveSubmarine(input: File): Pair<Int, Int> = input.useLines { line ->
        line.map {
            when {
                it.startsWith(FORWARD) -> it.removePrefix(FORWARD).toInt() to 0
                it.startsWith(UP) -> 0 to -it.removePrefix(UP).toInt()
                it.startsWith(DOWN) -> 0 to it.removePrefix(DOWN).toInt()
                else -> 0 to 0
            }
        }.reduce { position, displacement ->
            position.first + displacement.first to position.second + displacement.second
        }
    }

    fun moveAimedSubmarine(input: File): Triple<Int, Int, Int> = input.useLines { line ->
        line.map {
            when {
                it.startsWith(FORWARD) -> Triple(it.removePrefix(FORWARD).toInt(), 0, 0)
                it.startsWith(UP) -> Triple(0, 0, -it.removePrefix(UP).toInt())
                it.startsWith(DOWN) -> Triple(0, 0, it.removePrefix(DOWN).toInt())
                else -> Triple(0, 0, 0)
            }
        }.reduce { position, displacement ->
            Triple(
                position.first + displacement.first,
                position.second + displacement.first * position.third,
                position.third + displacement.third
            )
        }
    }

}