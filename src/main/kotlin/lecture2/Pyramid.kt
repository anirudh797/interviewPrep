package lecture2

fun main(){
    var arr = arrayOf(2,19,42,56,7,0)
    printPyramid(5)
}

fun printPyramid(n : Int) {

    for(i in 0 until n){

        for(k in 0 until n/22
             )
        {
            print(" ")
        }

        for(j in 0 until i+1)
            print("* ")

//        for(k in 0 until (n-i)/2 )
//        {
//            print(" ")
//        }

        println()
    }

}