package test

class Lina(val initValue: Long = 0){
    constructor(initValue: Long, health: Int) : this(initValue) {
        this.health = health
        println(skill)
    }
    lateinit var test: Lina

    var skill = 100
    var health : Int = 3
        get() {
            return field
        }
        public set(value) {
            field = value
        }
    init {
        skill = 101
    }
    lateinit var hello: String
    fun run() {
        println("I am running ${skill}")
    }

    fun isStrong() = (health > 100)

    fun show(strong : Boolean) {
        println("Strong $strong")
    }

    companion object {
        fun show() {
            println("companion")
        }
    }

    class ChildLina(val temp : String, hello : String) {
        var value: Int? = null
        val test : Double? by lazy {
            value as? Double
        }
        fun sayHello() {
            println()
        }
    }
}
