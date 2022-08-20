package lecture2

fun main(){
    var arr = arrayOf(2,19,42,56,7,0)
    printTable(5)
}

fun printTable(n: Int) {


    for (i in 1 until 11) {
            print("${n*i} ")
        println()
    }

}