package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        val orderedList = input.sortedArray()
        val sum = input.sum()
        return intArrayOf(sum - orderedList.last(), sum - orderedList.first())
    }
}
