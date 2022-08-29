package lecture2.assignments

import java.lang.Exception
import java.util.Arrays.sort

fun main(){

//    Q1. Given an array of N integers. Your task is to print the sum of all of the integers.
//        calculateSum()

//    Q2. Given an array A[] of N integers and an index Key. Your task is to print the element present at
//    index key in the array.
//        calculateElement()

//    Q3. Given an sorted array A of size N. Find number of elements which are less than or equal to given
//    element X.
//      countElements()

//    Q4. You are given an array A of size N. You need to print elements of A in alternate order (starting
  //          from index 0).
//      printElementsInAlternateOrder()

//    Q5. Given an array Arr of N positive integers. Your task is to find the elements whose value is equal
//    to that of its index value ( Consider 1-based indexing ).
//    findElements()

    //Q6. Given an array of size N and you have to tell whether the array is perfect or not. An array is said
    //to be perfect if it's reverse array matches the original array. If the array is perfect then print
    //"PERFECT" else print "NOT PERFECT".
    //Example 1:
    //Input : Arr[] = {1, 2, 3, 2, 1}
    //Output : PERFECT
    //Explanation:
    //Here we can see we have [1, 2, 3, 2, 1]
    //if we reverse it we can find [1, 2, 3, 2, 1]
    //which is the same as before.
    //So, the answer is PERFECT.
    //Example 2:
    //Input : Arr[] = {1, 2, 3, 4, 5}
    //Output : NOT PERFECT

//    findPerfectOrNot()

    //Q7. Given an array of length N, at each step it is reduced by 1 element. In the first step the maximum
    //element would be removed, while in the second step minimum element of the remaining array would
    //be removed, in the third step again the maximum and so on. Continue this till the array contains only 1
    //element. And find the final element remaining in the array.
    //Example 1:
    //Input:
    //N = 7
    //A[] = {7, 8, 3, 4, 2, 9, 5}
    //Ouput:
    //5
    //Explanation:
    //In first step '9' would be removed, in 2nd step
    //'2' will be removed, in third step '8' will be
    //removed and so on. So the last remaining
    //element would be '5'.
    //Example 2:
    //Input:
    //N = 8
    //A[] = {8, 1, 2, 9, 4, 3, 7, 5}
    //Ouput:
    //4

//    findTheFinalElement()


    //Q8. Given an array of N distinct elements, the task is to find all elements in array except two greatest
    //elements in sorted order.
    //Example 1:
    //Input :
    //a[] = {2, 8, 7, 1, 5}
    //Output :
    //1 2 5
    //Explanation :
    //The output three elements have two or
    //more greater elements.
    //Example 2:
    //Input :
    //a[] = {7, -2, 3, 4, 9, -1}
    //Output :
    //-2 -1 3 4

//    findSmallerElements()

    //Q9. Write a program to find the sum of the given series 1+2+3+ . . . . . .(N terms)
    //Example 1:
    //Input:
    //N = 1
    //Output: 1
    //Explanation: For n = 1, sum will be 1.
    //Example 2:
    //Input:
    //N = 5
    //Output: 15
    //Explanation: For n = 5, sum will be 1
    //+ 2 + 3 + 4 + 5 = 15.

//    finSumUptoN()


    //Q10. Given a number N. Your task is to check whether it is fascinating or not.
    //Fascinating Number: When a number(should contain 3 digits or more) is multiplied by 2 and 3 ,and
    //when both these products are concatenated with the original number, then it results in all digits from 1
    //to 9 present exactly once.
    //Example 1:
    //Input:
    //N = 192
    //Output: Fascinating
    //Explanation: After multiplication with 2
    //and 3, and concatenating with original
    //number, number will become 192384576
    //which contains all digits from 1 to 9.
    //Example 2:
    //Input:
    //N = 853
    //Output: Not Fascinating
    //Explanation: It's not a fascinating
    //number.

//    checkIfFascinatingNumber()


    //Bonus Question
    //Given an array of even size N, task is to find minimum value that can be added to an element so that
    //array become balanced. An array is balanced if the sum of the left half of the array elements is equal
    //to the sum of right half.
    //Example 1:
    //Input:
    //N = 4
    //arr[] = {1, 5, 3, 2}
    //Output: 1
    //Explanation:
    //Sum of first 2 elements is 1 + 5 = 6,
    //Sum of last 2 elements is 3 + 2 = 5,
    //To make the array balanced you can add 1.
    //Example 2:
    //Input:
    //N = 6
    //arr[] = { 1, 2, 1, 2, 1, 3 }
    //Output: 2
    //Explanation:
    //Sum of first 3 elements is 1 + 2 + 1 = 4,
    //Sum of last three elements is 2 + 1 + 3 = 6,
    //To make the array balanced you can add 2.

    makeArrayBalanced()
}

// Bonus Ques
fun makeArrayBalanced() {
    val arrayint = Array<Int>(6) { readLine()!!.toInt() }
    var leftHalfSum=0
    var sum=0
    for(i in arrayint.indices){
        if(i<arrayint.size/2){
            leftHalfSum+=arrayint[i]
        }
        sum+=arrayint[i]
    }
    val rightHalfSum = sum -leftHalfSum
    if(leftHalfSum>rightHalfSum){
        println("Minimum value needed : ${leftHalfSum-rightHalfSum}")
    }else
        println("Minimum value needed : ${rightHalfSum-leftHalfSum}")


}

//Question 9
fun checkIfFascinatingNumber() {
    val n = readLine()!!.toInt()
    var productWith2 = n*2
    var productWith3 = n*3
    var finalNo = try {
        (n.toString() + productWith2.toString() + productWith3.toString()).toInt()
    }
    catch (ex : Exception ){
        println("Not fascinating")
        return
    }
        var arr = Array<Int>(9){0}

    //exhaust final No while maintaining a count for every element present in it
    while(finalNo!=0){
        val rem =finalNo%10
        if(rem==0) {
            println("Not fascinating")
            return
        }
        finalNo/=10
        arr[rem-1]+=1
        if(arr[rem-1]>1){
            println("Not fascinating")
            return
        }
    }
    if(n>0 && checkNumberSingleOccurence(arr)){
        println("Fascinating ")
    }
    else
        println("Not Fascinating ")

}

fun checkNumberSingleOccurence(arr: Array<Int>): Boolean {
    for(i in arr){
        if(i!=1)
            return false
    }
    return true
}


//Question 9
fun finSumUptoN() {
    val n = readLine()!!.toInt()
    val sum = (n*(n+1))/2
    println("Sum of $n terms will be : $sum")

}

fun findSmallerElements() {
    val arrayint = Array<Int>(4) { readLine()!!.toInt() }

    var max1 = Integer.MIN_VALUE ; var max2 = Integer.MIN_VALUE
    // find max and second max first
    for(i in arrayint){
        if(i > max1){
            max2 = max1
            max1=i
        }
        else if(i>max2){
            max2=i
        }
    }

    //print all elements which are not equal to max and SecondMax
    for(i in arrayint){
        if(i!= max1 && i!=max2){
            println("Found $i")
        }
    }
}

fun findTheFinalElement() {
    val arrayint = Array<Int>(6) { readLine()!!.toInt() }
    sort(arrayint)


    var n = arrayint.size
    if(n % 2 ==0){
        println("Final element will be ${arrayint[(n-1)/2]}")
    }
    else
        println("Final element will be ${arrayint[n/2]}")

}

fun findPerfectOrNot() {
    val arrayint = Array<Int>(5) { readLine()!!.toInt() }
    var i=0; var j=arrayint.size-1;
    while(i<j){
        if(arrayint[i]!=arrayint[j]){
            println("Not Perfect Array")
            return
        }
        i++
        j--
    }
    println("Perfect Array")

}

fun findElements() {
    val arrayint = Array<Int>(5) { readLine()!!.toInt() }

    for(x in arrayint.indices){
        if(x+1 == arrayint[x])
            println(arrayint[x])
    }
}

fun printElementsInAlternateOrder() {
    val arrayint = Array<Int>(5) { readLine()!!.toInt() }

    for(x in arrayint.indices){
        if(x%2==0)
            println(arrayint[x])
    }

}

fun countElements() {
    val arrayint = Array<Int>(5) { readLine()!!.toInt() }
    val ele = readLine()!!.toInt()
    var count=0
    for(x in arrayint){
        if(x<=ele){
            count+=1
        }
    }
    println(count)
}

fun calculateElement() {
    val arrayint = Array<Int>(5) { readLine()!!.toInt() }
    println("Enter the idx to find element")
    val idx = readLine()!!.toInt()

    println(arrayint[idx])
}

fun calculateSum() {
    val arrayint = Array<Int>(5) { readLine()!!.toInt() }

    var sum=0
    for(x in arrayint){
        sum+=x
    }
    println(sum)
}

//fun
