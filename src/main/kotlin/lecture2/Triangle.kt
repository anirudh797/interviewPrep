package lecture2

fun main(){
    var arr = arrayOf(2,19,42,56,7,0)
    printTriangle(5)
}

fun printTriangle(n : Int) {

    for(i in 0 until n){
        for(j in 0..n-1-i)
            print("*")
        println()
    }

}