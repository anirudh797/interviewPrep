package lecture2.assignments

fun main(){

//    list()
//    1. https://leetcode.com/problems/richest-customer-wealth
//
//    2. https://leetcode.com/problems/running-sum-of-1d-array/
//
//    3. https://leetcode.com/problems/jewels-and-stones
//
//    4. https://leetcode.com/problems/minimum-absolute-difference
//
//    5. https://leetcode.com/problems/three-consecutive-odds
//
//    6. https://leetcode.com/problems/transpose-matrix
//
//    7. https://leetcode.com/problems/majority-element
//
//    8. https://leetcode.com/problems/move-zeroes


}

//Question 1
fun maximumWealth(accounts: Array<IntArray>): Int {

    var maxWealth = Integer.MIN_VALUE
    for(cust in accounts){
        var total=0
        for(wealth in cust){
            total+=wealth
        }
        maxWealth = Math.max(maxWealth,total)
    }

    return maxWealth
}


//Question 2
fun runningSum(nums: IntArray): IntArray {
    var prefixSum=0
    var numArray = IntArray(nums.size){0}
    for(idx in nums.indices){
        prefixSum+=nums[idx]
        numArray[idx] = prefixSum
    }

    return numArray
}


//Question 3
fun numJewelsInStones(jewels: String, stones: String): Int {

    //Mark all the jewels in a map
    var map = mutableMapOf<Int,Int>()
    for(jewel in jewels){
        var key = jewel - '0'
        map.put(key,1)
    }

    //count all the stones which are present in jewels map
    var tCount=0
    for(stone in stones){
        var count = map.get(stone-'0')
        if(count==1){
            tCount+=1
        }
    }
    return tCount
}

//Question 4
fun minimumAbsDifference(arr: IntArray): List<List<Int>> {


    arr.sort()
    var minDiff = Integer.MAX_VALUE
    for(idx in 0..arr.size-2){
        var ele = arr[idx]
        var nbr = arr[idx+1]
        minDiff= Math.min(nbr-ele,minDiff)
    }

    var res = List<List<Int>>(0){ listOf()}

    //find which all pairs have this minDiff
    for(idx in 0.. arr.size-2){
        var ele = arr[idx]
        var nbr = arr[idx+1]
        var diff = nbr-ele
        if(diff==minDiff){
            var pair = listOf(listOf<Int>(ele,nbr))
            res+=pair
        }
    }
    return res
}

//Question 5
fun threeConsecutiveOdds(arr: IntArray): Boolean {

    for(idx in 0..arr.size-3)
    { var first = arr[idx]
        var second = arr[idx+1]
        var third = arr[idx+2]
        if(first%2==1 && second%2==1 && third%2==1)
            return true
    }
    return false
}

//Question 6
fun transpose(matrix: Array<IntArray>): Array<IntArray> {

    var res = Array(matrix[0].size){IntArray(matrix.size)}
    for(row in 0..matrix.size-1){
        for(col in 0..matrix[row].size-1){
            res[col][row] = matrix[row][col]
        }
    }

    return res

}
//Question 7
fun majorityElement(nums: IntArray): Int {

    //Used moore voting algo

    var ele  = nums[0]
    var count=1
    for(idx in 1..nums.size-1){
        var e = nums[idx]
        if(e==ele){
            count+=1
        }
        else
            count-=1

        if(count==0){
            count=1
            ele = e
        }

    }

    return ele
}

//Question 8
fun moveZeroes(nums: IntArray): Unit {

    var idxFor0=nums.size-1
    var idx =0
    while(idx<idxFor0){
        var ele = nums[idx]
        // println(ele)
        if(ele==0){
            //shift all the elements in right to one position to their left
            shift(nums,idx+1,idxFor0)
            nums[idxFor0] = 0             //push this 0 at end
            idxFor0--;
        }
        else{
            idx++
        }
    }
}

fun shift(nums:IntArray, idx:Int, idxFor0: Int){

    for(i in idx..idxFor0){
        nums[i-1]=nums[i]
    }

}



fun list(){
    val anslist = List<List<Int>>(0){
        listOf()
    }.toMutableList()

    anslist+= listOf(listOf(2,4))
    anslist+= listOf(listOf(4,8))

    println(anslist)
}





