package test

import org.joda.time.LocalDate
import java.math.BigDecimal
import java.util.*
import java.util.regex.Pattern

fun main(args: Array<String>) {
    val lina1 = Lina()
    lina1.health = 1
    val lina2 = Lina()
    lina2.health = 2
    var hello = "12-hello123-01"
    println(hello.replace(Regex("(\\S)*-"), "new-"))
    val dates = listOf(Date(1), Date(2))
    dates.forEach { println(it.time) }
    dates.sortedDescending().forEach { println(it.time) }
    val map = hashMapOf<HelloWorld, String>()
    println(String.format("hello-%04d", 123))
    val temp: HelloWorld? = null
    println(map[temp])

    val map2 = mapOf(Pair("abc1", 1), Pair("c3", 3), Pair("bd4", 4), Pair("bc2", 2), Pair("bc0", 0))
    val map3 = map2.toList().sortedBy { it.second }.toMap()
    println(map3.keys)
    val test: String? = null
    println(test.isNullOrEmpty())
    println(mutableMapOf( 1 to 2, 2 to 4).apply { putAll(mutableMapOf( 1 to 3))})
    println(object : HelloWorld(){
        override fun canEvaluate(): Boolean {
            return true
        }
    }.canEvaluate())

    val temp11 = listOf(1, null) as List<Int>
    println(listOf<Int?>() is List<Any?>)
    var map4 = mutableMapOf<String, Any?>("1" to listOf(null,1), "2" to listOf(1,2))
    for(it in map4) {
        if (it.value != null && it.value is List<Any?>) {
            it.setValue((it.value as List<Any?>).filter { it != null })
        }
    }
//    val date = LocalDate.parse(SimpleDateFormat("yyyy-MM-dd").format(Date()))
//    DayOfWeek.MONDAY.value
    LocalDate.now().toDateTimeAtStartOfDay()
    println("${LocalDate.now().dayOfWeek} --- ${LocalDate.now().toDateTimeAtStartOfDay()}")
    println(Date(1532363400000))
    println(LocalDate.now().toDateTimeAtCurrentTime().millis + 3600000)
    println(listOf(12,13,14).intersect(listOf(1,2,13)))
    println("-----")
    listOf(1,2,13).forEach {
        if (it < 2) {
            return@forEach
        }
        println(it)
    }
    println(Pattern.compile("[A-Z,0-9]{5}").matcher("12345").matches())
    println(listOf(1,3,5,4,null).sortedByDescending { it })
    println(String.format("hello-%04d", 123))
    println(String.format("%s-%d", "123", 4))
    val regex = Regex("([0-9]+.){3}[0-9]+")
    println("hello127.0.0.1dsfsf".replace(regex, "xxx"))

}

fun multiplyDouble(v1: Double? = 0.0, v2: Double? = 0.0): Double {
    return BigDecimal(v1 ?: 0.0).multiply(BigDecimal(v2 ?: 0.0))
            .setScale(4, BigDecimal.ROUND_HALF_UP).toDouble()
}

open class HelloWorld() {

    var period = 2

    open fun canEvaluate(): Boolean {
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)
        when (period) {
            1 -> if (currentMonth == 9) {
                return true
            }
            2 -> if (currentMonth == 2) {
                return true
            }
        }
        return false
    }
}

enum class OrganizationType {
    INNER,
    OUTER;
}

enum class Grade(val score: Double) {
    GradeZero(0.00),
    GradeOne(3.25),
    GradeTwo(3.50),
    GradeThree(3.75),
    GradeFour(4.00);

    companion object {
        fun getByValue(value: Double): Grade? {
            return Grade.values().firstOrNull {
                BigDecimal(it.score).compareTo(BigDecimal(value)) == 0
            }
        }
    }
}