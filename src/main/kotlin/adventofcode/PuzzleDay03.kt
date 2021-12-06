package adventofcode

import java.io.File

class PuzzleDay03(significantBits: Int) {

    private val histogramSize = significantBits * 2

    fun readGammaAndEpsilon(input: File): Pair<Int, Int> =
        input.useLines { bitsSequence ->
            val gammaBits = bitsSequence.deriveBitmask(true)
            val gamma = gammaBits.convertBitsToInt()
            val epsilon = gammaBits.flipBitmask().convertBitsToInt()
            gamma to epsilon
        }

    private fun Sequence<String>.deriveBitmask(mostCommonMode: Boolean) = calculateHistogramPerBitPosition()
        .collectBitmaskFromHistogram(mostCommonMode)

    private fun Sequence<String>.calculateHistogramPerBitPosition(): IntArray =
        fold(IntArray(histogramSize)) { histogram, bitString ->
            bitString.toCharArray().forEachIndexed { index, bit ->
                val histogramPos = if ('0' == bit) 2 * index else 2 * index + 1
                histogram[histogramPos]++
            }
            histogram
        }

    private fun IntArray.collectBitmaskFromHistogram(mostCommonMode: Boolean): CharArray =
        asIterable().windowed(2, 2).map {
            when (mostCommonMode) {
                true -> if (it[1] >= it[0]) '1' else '0'
                false -> if (it[1] < it[0]) '1' else '0'
            }
        }.toCharArray()

    private fun CharArray.flipBitmask(): CharArray = map { if (it == '0') '1' else '0' }.toCharArray()

    private fun CharArray.convertBitsToInt(): Int = fold(0) { int, bit ->
        val bitValue = if ('0' == bit) 0 else 1
        int * 2 + bitValue
    }

    fun readOxygenScrubberRatings(input: File): Int =
        readRatingForMode(input, true)

    fun readCO2ScrubberRatings(input: File): Int =
        readRatingForMode(input, false)

    fun readLifeSupportRating(file: File) = readOxygenScrubberRatings(file) * readCO2ScrubberRatings(file)

    private fun readRatingForMode(input: File, mostCommonMode: Boolean) =
        input.useLines { bitsSequence ->
            var filteredNumbers = bitsSequence.toList()
            var bitmask = filteredNumbers.asSequence().deriveBitmask(mostCommonMode)
            for (bitPosition in bitmask.indices) {
                filteredNumbers = filteredNumbers.filter { it[bitPosition] == bitmask[bitPosition] }
                if (filteredNumbers.count() == 1) break
                bitmask = filteredNumbers.asSequence().deriveBitmask(mostCommonMode)
            }
            filteredNumbers
        }.first().toCharArray().convertBitsToInt()


}