package adventofcode

import java.io.File

class PuzzleDay06 {

    class Ocean(fishes: String) {
        companion object {
            fun populate(file: File): Ocean = file.useLines { Ocean(it.first()) }
        }

        var oceanMap: Map<Lanternfish, Long>
            private set

        init {
            oceanMap =fishes.split(",")
                .map { Lanternfish(it.toInt()) to 1L }
                .populateOceanMap()
        }

        fun oldenOneDay(): Ocean {
            oceanMap = oceanMap.entries.flatMap { entry ->
                val (fish, count) = entry
                fish.oldenOneDay().map { agedFish -> agedFish to count }
            }.populateOceanMap()
            return this
        }

        private fun List<Pair<Lanternfish,Long>>.populateOceanMap(): Map<Lanternfish,Long> =
            fold(mutableMapOf<Lanternfish, Long>()) { nextOceanMap, pair->
                val (fish,count) = pair
                nextOceanMap[fish] = nextOceanMap.getOrDefault(fish, 0L) + count
                nextOceanMap
            }

        fun countFishes(): Long = oceanMap.entries.sumOf { entry -> entry.value }

    }

    data class Lanternfish(var age: Int) {
        fun oldenOneDay(): Sequence<Lanternfish> = when(age) {
            0 -> sequenceOf(Lanternfish(6), Lanternfish(8))
            else -> sequenceOf(Lanternfish(age - 1))
        }
    }


}