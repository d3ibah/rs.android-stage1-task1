package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var min = 0
        var max = n - 1
        var difference = 0
        val characters = digitString.toCharArray()
        var countSteps = k
        var i = 0
        var j = n - 1

        while (i < n / 2) {
            if (characters[i] != characters[j]) {
                difference++
            }
            i++
            j--
        }

        if (difference > countSteps) {
            return "-1"
        }

        while (max >= min) {
            if (countSteps <= 0) {
                break
            }

            val minItem = characters[min]
            val maxItem = characters[max]

            if (minItem == maxItem) {

                if ((countSteps > 1) && ((countSteps - 2) >= difference) && (minItem != '9')) {
                    characters[min] = '9'
                    characters[max] = '9'
                    countSteps = countSteps - 2
                }
            } else {

                if ((countSteps > 1) && ((countSteps - 2) >= difference - 1)) {
                    if (minItem != '9') {
                        characters[min] = '9'
                        countSteps--
                    }

                    if (maxItem != '9') {
                        characters[max] = '9'
                        countSteps--
                    }
                } else {
                    val minDigitValue = characters[min].toInt()
                    val maxDigitValue = characters[max].toInt()

                    if (minDigitValue > maxDigitValue) {
                        characters[max] = characters[min]
                    } else {
                        characters[min] = characters[max]
                    }
                    countSteps--
                }
                difference--
            }

            if ((max == min) && (countSteps > 0)) {
                characters[min] = '9'
                countSteps--
            }
            min++
            max--
        }

        return if (this.isPalindrome(characters)) {
            val result: String = characters.joinToString("")
            result
        } else {
            "-1"
        }
    }

    private fun isPalindrome(stringList: CharArray): Boolean {
        if (stringList.count() == 0) {
            return false
        }

        var i = 0
        var j = stringList.count() - 1

        while (j < i) {
            val firstChar = stringList[i]
            val secondChar = stringList[j]

            if (firstChar == secondChar) {
                i++
                j--
            } else {
                return false
            }
        }

        return true
    }
}