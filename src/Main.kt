import java.util.*

class Main {


    fun main(args: Array<String>) {



    }
//Task 1

//Solution by me
//Following solution is not the best in  time and space complexity scope.
    fun singleNumber(nums: Array<Int>): Int {
        var holder = 0
        for (each in nums) {
            if (nums.count { it == each } == 1)
                holder = each

        }
        return holder
    }

//I figured  following solution by research as the most effective
//fun singleNumber(nums: Array<Int>): Int {
//    var res = 0
//    for (number in nums) {
//        res = res xor number
//    }
//    return res
//}

    //Task 2
//Solution by me
    fun minSplit(amount: Int): Int {
        val coins = arrayOf(50, 20, 10, 5, 1)
        var holder = amount
        val resCoins = mutableListOf<Int>()

        for(each in coins){
            val div = holder / each
            for ( i in 1..div){
                resCoins.add(each)
            }
            holder  %= each
        }

        //I could do without list to just count quantity,  but having array can be useful later
        return resCoins.size
    }

//I figured  following solution by research as the most effective
//fun minSplit2(amount: Int): Int {
//    val coins = arrayOf(1, 5, 10, 20, 50)
//    val n = coins.size
//    var amountKeeper = amount
//    val change = mutableListOf<Int>()
//
//    for (i in n - 1 downTo 0) {
//        while (amountKeeper >= coins[i]) {
//            amountKeeper -= coins[i]
//            change.add(coins[i])
//        }
//    }
//    // The variable "change" is an array containing the minimum number of coins needed
//    // println(change)
//
//    return change.size
//
//
//}

    //Task 3
//Solution by me
    fun getPrefix(array: Array<String>): String {

        val size = array.size


        if (size == 0) return ""
        if (size == 1) return array[0]

// In case if we want to handle case sensitivity problem we can use current array instead of "array"
//     val lowerCaseArray = array.map { it.lowercase() }.toTypedArray()
        array.sort()
        val minLength = minOf(array.first().length, array.last().length)
        var prefixLength = 0
        while  (prefixLength < minLength && array[0][prefixLength] == array[array.size - 1][prefixLength]) {
            prefixLength++
        }

        return array[0].take(prefixLength)

    }


//Task 4

    //Solution by me
    fun sumBinaries(a: String, b: String): String {
        var result = ""
        var carry = 0

        val aReversed = a.reversed()
        val bReversed = b.reversed()

        val maxLength = maxOf(a.length, b.length)

        for (i in 0 until maxLength) {
            val digitA = if (i < a.length) aReversed[i].toString().toInt() else 0
            val digitB = if (i < b.length) bReversed[i].toString().toInt() else 0

            val total = digitA + digitB + carry

            val char = (total % 2).toString()
            result = char + result
            carry = total / 2
        }

        if (carry != 0) {
            result = "1" + result
        }

        return result
    }


//I figured  following solution by research as the most effective
//fun sumBinaries(addendOne: String, addendTwo: String): String {
//
//    var i = addendOne.length - 1
//    var j = addendTwo.length - 1
//
//    var holder = 0
//
//    val result = StringBuilder()
//
//    while (i >= 0 || j >= 0 || holder > 0) {
//        var sum = holder
//
//        if (i >= 0) sum += addendOne[i--] - '0'
//        if (j >= 0) sum += addendTwo[j--] - '0'
//
//        holder = sum / 2
//        result.append(sum % 2)
//    }
//
//    return result.reverse().toString()
//
//}

    //Task 5
//Solution by me
    fun getFib(n: Int): Int {
        return  if(n <= 1){
            n
        }else{
            getFib(n - 1) + getFib(n - 2)
        }
    }

    fun countVariants(stairsCount: Int): Int = getFib(stairsCount + 1)


    //Task 6
//Solution by me
    class CustomStructure{

        private val map: MutableMap<Int, Int> = mutableMapOf()
        private val list: MutableList<Int> = mutableListOf()


        fun remove(element: Int){
            val index = map[element] ?: return

            map.remove(element)

            val size = list.size
            val last = list[size - 1]
            Collections.swap(this.list, size - 1, index)

            list.removeAt(size - 1)
            map[last] = index

        }
    }



}