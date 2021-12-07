package adventofcode

import java.io.File

class PuzzleDay05 {

    fun calculateVentPositions(file: File, filterToStraightLines: Boolean = false): Map<Vector2D, Int> = file.useLines { seq ->
        LineSpecParser.parse(seq)
            .filter { pair ->
                if(filterToStraightLines) (pair.first.x == pair.second.x || pair.first.y == pair.second.y)
                else true
            }
            .flatMap { startAndEnd -> startAndEnd.first.pathTo(startAndEnd.second) }
            .fold(mutableMapOf()) { histogram, current ->
                histogram[current] = histogram.getOrDefault(current, 0) + 1
                histogram
            }
    }

    object LineSpecParser {
        val regex = Regex("(\\d+),(\\d+) -> (\\d+),(\\d+)")
        fun parse(lineSpecs: Sequence<String>): Sequence<Pair<Vector2D, Vector2D>> = lineSpecs.map { parse(it) }
        fun parse(lineSpec: String): Pair<Vector2D, Vector2D> = regex.findAll(lineSpec)
            .flatMap { matchResult -> matchResult.groupValues }
            .drop(1)
            .map { value -> value.toInt() }
            .windowed(2, 2)
            .map { Vector2D(it[0], it[1]) }
            .windowed(2)
            .map { it[0] to it[1]}
            .first()
    }

    data class Vector2D(val x: Int, val y: Int) {
        fun pathTo(destination: Vector2D): Sequence<Vector2D> = sequence {
            val direction = Vector2D(gradient(x, destination.x), gradient(y, destination.y))
            var currentPosition = this@Vector2D
            yield(currentPosition)
            while (currentPosition != destination) {
                currentPosition = currentPosition + direction
                yield(currentPosition)
            }
        }

        private fun gradient(start: Int, end: Int) = when {
            start < end -> 1
            start > end -> -1
            else -> 0
        }

        operator fun plus(other: Vector2D) = Vector2D(x + other.x, y + other.y)
    }


}