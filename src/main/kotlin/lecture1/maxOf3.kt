package lecture1

fun main(args: Array<String>) {

    var ans = findMax(22, 22, 22)
    println(ans)
}


fun findMax(n1: Int, n2: Int, n3: Int): Int {

    return if (n1 > n2 && n1 > n3) {
        n1
    } else if (n2 > n1 && n2 > n3)
        n2
    else
        n3
}
