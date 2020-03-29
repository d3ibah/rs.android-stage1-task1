package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val numberList: MutableList<Int> = sadArray.toMutableList()
        var isSadArray = true

        while (isSadArray) {
            var badIndex = -1
            val size = numberList.size
            if (size > 0) {
                for (i in 1 until size - 1) {
                    if (numberList[i - 1] + numberList[i + 1] < numberList[i]) {
                        badIndex = i
                    }
                }
            }

            if (badIndex > 0) {
                numberList.removeAt(badIndex)
            } else {
                isSadArray = false
            }
        }

        return numberList.toIntArray()
    }
}
