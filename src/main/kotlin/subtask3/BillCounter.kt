package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, notEatingIndex: Int, annaGives: Int): String {
        val halfPrice = (bill.sum() - bill[notEatingIndex]) / 2

        return if (halfPrice >= annaGives) {
            "bon appetit"
        } else {
            "${annaGives - halfPrice}"
        }
    }
}
