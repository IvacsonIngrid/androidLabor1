import java.lang.StringBuilder
import java.util.*
import kotlin.random.Random.*

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
    val evenNumb = list2.filter{number -> number.exercise5() == 0}
    println("$list2 -> $evenNumb")

    println("\n6.  days of the week + map() -------------------")
    val elements = listOf(6, 9, "Monday", "Sunday", 32)
    print("The elements of a list of integers *2: ")
    elements.map{
        if(it is Int)
        {
            print("${it*2}, ")
        }
    }
    println("The elements of a list of integers *2: ")
    list2.map{print("${it*2}, ")}

    println("\nThe days of week capitalized: ")
    list.map{print("\t${it.uppercase()}, ")}

    println("\nThe first character of each day capitalized: ")
    list.map{print("${it.lowercase().first()}, ")}

    println("\nThe length of days: ")
    list.map{print("$it -> ${it.length}, ")}

    print("\nThe average length of days: ")
    var sum: Int = 0
    list.map{sum += it.length}
    println(sum/7.0)



    println("\n7. exercises with daysOfWeek -------------------------")
    list.toMutableList()
    list.filter { day -> day.contains('n')}


    println("\n8. exercises with random integers --------------------")
    val randList = mutableListOf<Int>()
    for(i in 1..10)
    {
        randList.add((0..100).random())
    }

    randList.forEach{
        println("$it")
    }

    randList.sort()
    println("The sorted list is: $randList")




    // Try adding program arguments at Run/Debug configuration
    println("Program arguments: ${args.joinToString()}")
}

//1. feladat: String Template
fun exercise1(a: Int,b: Int) {
    println("$a + $b = ${a + b}")
}

//2. feladat: a hét napjai - lista
fun exercise2(list: List<String>) {

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

//mas fajta parameterezessel
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

//5. paros szam - kompakt fuggveny
fun Int.exercise5():Int = this % 2

//7. het napjai ~ immutable list
fun exercise7(list: List<String>) {
    val listNew = list.toMutableList()

    for (i in listNew)
    {
        if(i.contains('n'))
        {
            listNew.remove(i)
        }
    }

    //println("If you remove all days containing the letter 'n': $listNew")
}

//8. random szamok generalasa
