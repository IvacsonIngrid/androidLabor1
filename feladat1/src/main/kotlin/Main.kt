import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt

fun main(args: Array<String>) {
    println("1. String template -----------------")
    val number1 = 2
    val number2 = 3
    exercise1(number1,number2)

    println("\n2. daysOfWeek ----------------------")
    val list = listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    exercise2(list)

    println("\n3. prime number ----------------------")
    for (i in -5..20)
    {
        if(i.exercise3())
        {
            print("$i, ")
        }
    }

    println("\n\n4. encode-decode ---------------------")
    val myString = "Zebra"

    val myEncodeS = myString.encode()
    println("Encoded text: $myString -> $myEncodeS")

    val myDecodeS = myEncodeS.decode()
    println("Decoded text: $myEncodeS -> $myDecodeS")

    println("With a higher-order function:")
    val encodeText = messageCoding(myString, ::encode2)
    println("\t$myString -> $encodeText")
    val decodeText = messageCoding(encodeText, ::decode2)
    println("\t$encodeText -> $decodeText")

    println("5.  Even numbers from a list -------------------")
    val list2 = listOf(5,16,9,3,67,24,54,1)

    val evenNumb = list2.exercise5()
    println("$list2 -> $evenNumb")

    println("\n6.  days of the week + map() -------------------")
    print("The elements of a list of integers *2:\n\t")
    print("$list2 -> ")
    list2.map{print("${it*2}, ")}

    print("\nThe days of week capitalized:\n\t")
    list.map{print("${it.uppercase()}, ")}

    print("\nThe first character of each day capitalized:\n\t")
    list.map{print("${it.lowercase().first()} for $it, ")}

    print("\nThe length of days:\n\t")
    list.map{print("$it -> ${it.length}, ")}

    print("\nThe average length of days: ")
    var sum: Int = 0
    list.map{sum += it.length}
    println(sum/7.0)


    println("\n7. exercises with daysOfWeek -------------------------")
    val list3 = list.toMutableList()
    val list4 = list3.filter { day -> day.contains('n')}
    list3 -= list4
    println("Each day that doesn't contain the letter \"n\": $list3")

    for ((index, value) in list3.withIndex()) {
        println("Item at $index is $value")
    }

    list3.sort()
    println("The sorted list: $list3")


    println("\n8. exercises with random integers --------------------")
    val randArrayList = arrayListOf<Int>()
    for(i in 1..10)
    {
        randArrayList.add((0..100).random())
    }

    println("The random list: ")
    randArrayList.forEach{
        println("$it")
    }

    randArrayList.sort()
    println("The sorted list is: $randArrayList")

    when (randArrayList.exercise8_1())
    {
        true -> println("The array contains any even number.")
        else -> println("The array doesn't contain any even number.")
    }

    when (randArrayList.exercise8_2())
    {
        true -> println("All numbers are even.")
        else -> println("Not all numbers are even.")
    }

    var avg = 0
    randArrayList.forEach{
        avg += it
    }
    println("The average of generated numbers: ${avg/10.0}")
}

//1. feladat: String Template
fun exercise1(a: Int,b: Int) {
    println("$a + $b = ${a + b}")
}

//2. feladat: a hét napjai - lista
fun exercise2(list: List<String>) {
    print("The days of the week: ")
    for(day in list)
    {
        print("$day ")
    }
    print("\nDays starting with letter 'T':")

    var filterListT = list.filter { day -> day.first() == 'T'}
    println(filterListT)

    print("Days containing the letter 'e':")
    var filterListE = list.filter { day -> day.contains('e')}
    println(filterListE)

    print("All the days of length 6:")
    var filterLength6 = list.filter { day -> day.length == 6 }
    println(filterLength6)
}

//3. feladat: prim szam-e
fun Int.exercise3() : Boolean{
    var trueFalse = true

    if (this < 2)
    {
        return false
    }

    for (i in 2..this / 2) {
        if (this % i == 0) {
            trueFalse = false
            break
        }
    }

    return trueFalse
}

//4. feladat: kodol-dekodol
fun String.encode() :String{
    val sb = StringBuilder(this.length)
    for (c in this)
    {
        sb.append(c+1)
    }

    return sb.toString()
}

fun String.decode() :String{
    val sb = StringBuilder(this.length)
    for (c in this)
    {
        sb.append(c-1)
    }

    return sb.toString()
}

//mas fajta parameterezessel es szaballyal
fun encode2(msg:String) :String{
    val sb = StringBuilder(msg.length)
    for (c in msg)
    {
        sb.append(c+2)
    }

    return sb.toString()
}

fun decode2(msg: String) :String{
    val sb = StringBuilder(msg.length)
    for (c in msg)
    {
        sb.append(c-2)
    }

    return sb.toString()
}

fun messageCoding(msg: String, func: (String) -> String): String {
    return func(msg)
}

fun List<Int>.exercise5() = this.filter{number -> number%2 == 0}

//8. random szamokkal
fun ArrayList<Int>.exercise8_1() : Boolean {
    this.forEach{
        if(it % 2 == 0)
        {
            return true
        }
    }

    return false
}

fun ArrayList<Int>.exercise8_2() : Boolean {
    this.forEach{
        if(it % 2 != 0)
        {
            return false
        }
    }

    return true
}
