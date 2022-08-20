package lecture2

fun main(){
    var arr = arrayOf(2,19,42,56,7,0)
    printFlyod(5)
}

fun printFlyod(n: Int) {

    var count = 1
    for (i in 0 until n+1) {
        for (j in 0 until i) {
            print("$count ")
            count += 1
        }
        println()
    }

}