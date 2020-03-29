package subtask4

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val input = inputString.toCharArray()
        val output = mutableListOf<String>()

        for (i in input.indices) {
            when (input[i]) {
                '[' -> output.add(getSubString(inputString, i, '[', ']'))
                '<' -> output.add(getSubString(inputString, i, '<', '>'))
                '(' -> output.add(getSubString(inputString, i, '(', ')'))
            }
        }

        return output.toTypedArray()
    }

    private fun getSubString(inputString: String, startPos: Int, openingChar: Char, closingChar: Char): String {
        var count = 0
        var endPos = startPos
        for (i in startPos until inputString.length) {
            if (inputString[i] == openingChar) {
                count++
            }

            if (inputString[i] == closingChar) {
                count--
            }

            if (count == 0) {
                endPos = i
                break
            }
        }

        return if (endPos != startPos) {
            inputString.substring(startPos + 1, endPos)
        } else {
            ""
        }
    }
}