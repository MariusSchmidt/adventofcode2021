package adventofcode

import java.io.File
import kotlin.math.*

/**
 *
 * PART I
 * Interestingly enough, for any series of numbers in R^1 the central point that minimizes the sum of distances to each
 * other point is the median. In fact "The median minimizes the sum of absolute deviations". Until AoC 2021 I did not
 * realize that and wanted to see proof:
 *
 * A explanatory and a formal proof can be found here https://math.stackexchange.com/questions/113270/the-median-minimizes-the-sum-of-absolute-deviations-the-ell-1-norm
 * Also this paper https://tommasorigon.github.io/StatI/approfondimenti/Schwertman1990.pdf gives a similar proof
 *
 *
 * PART II
 * Mainly since the answer the first riddle was the median, I guessed, that the second might be the arithmetic average.
 * I still search for an explanation why this works and why we need to introduce the +.0.5 variance and why for some
 * it works without that adjustment. It might the difference between float and double based calculation
 *
 */
class PuzzleDay07 {

    fun findMostCentralPointForCrabsToRally(file: File, constantCost: Boolean): Pair<Int, Int> = file.useLines { seq ->
        return if (constantCost) findForConstantCostPerDistance(seq)
        else findForLinearIncreasingCostPerDistance(seq)
    }

    private fun findForConstantCostPerDistance(seq: Sequence<String>): Pair<Int, Int> {
        val crabPositions = seq.first().split(",").map { it.toInt() }.sorted()
        val medianIndex = crabPositions.size / 2
        val median = crabPositions[medianIndex]
        val sumOfDistances = crabPositions.fold(0) { sum, position -> sum + abs(position - median) }
        return median to sumOfDistances
    }

    private fun findForLinearIncreasingCostPerDistance(seq: Sequence<String>): Pair<Int, Int> {
        val crabPositions = seq.first().split(",").map { it.toInt() }
        val arithmeticAverage = crabPositions.average()
        val lowerBound = (arithmeticAverage - 0.5).roundToInt()
        val upperBound = (arithmeticAverage + 0.5).roundToInt()
        val resultLowerBound = calculateFuelUsage(crabPositions, lowerBound)
        val resultUpperBound = calculateFuelUsage(crabPositions, upperBound)
        return if (resultLowerBound.second < resultUpperBound.second) resultLowerBound else resultUpperBound
    }

    private fun calculateFuelUsage(crabPositions: List<Int>, rallyPoint: Int): Pair<Int, Int> {
        val fuelUsed = crabPositions.fold(0) { fuelAggregator, position ->
            val distance = abs(position - rallyPoint)
            val fuelConsumption = (0..distance).sum()
            fuelAggregator + fuelConsumption
        }
        return rallyPoint to fuelUsed
    }

}