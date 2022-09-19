package lecture2.assignments

import java.lang.Integer.min
import java.lang.Math.max
import java.util.*

fun main(){
//    1. https://leetcode.com/problems/two-sum/
//            twoSum(arrayOf(2,4,5,6), 8)

//    2. https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//        twoSum2(intArrayOf(2,4,5,6), 8)


//    3. https://leetcode.com/problems/merge-sorted-array/
//            mergeSortedArray(intArrayOf(1,2,3,0,0,0),3, intArrayOf(2,5,6),3)

//    4. https://leetcode.com/problems/pascals-triangle/
//     var ans = generate(5)

//    5. https://leetcode.com/problems/pascals-triangle-ii/
//        getRow(5)

//    6. https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//      maxProfit(intArrayOf(2,18,5,9,7))

//    7. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/


//    8. https://leetcode.com/problems/majority-element/
//        arrayMajorityElement(intArrayOf(5,9,2,17,2,2,2))

//    9. https://leetcode.com/problems/majority-element-ii/


//    10.https://leetcode.com/problems/missing-ranges/ (premium ques)

//    11.https://leetcode.com/problems/3sum/
//         threeSum( intArrayOf(-1,0,1,2,-1,-4))

//    12.https://leetcode.com/problems/3sum-smaller/

//    13.https://leetcode.com/problems/3sum-closest/
//        threeSumClosest(intArrayOf(0,3,4,-2,-4),2)

//    14.https://leetcode.com/problems/4sum/
        fourSum(intArrayOf(1,0,-1,0,-2,2),0)

//    15.https://leetcode.com/problems/rotate-image/
//    rotate(Array<IntArray>(arrayOf(5,1,9,11), intArrayOf(2,4,8,10), intArrayOf(,3,6,7))

//      plusOne(intArrayOf(9,9,9))

}

fun twoSum(nums: Array<Int>, target: Int): IntArray {

    var hm = hashMapOf<Int,Int>()
    for(idx in nums.indices){
        var ele = nums[idx]
        if(hm.contains(target-ele)){
            return intArrayOf(idx,hm[target-ele]?:-1)
        }
        else
            hm[ele] = idx
    }

    return intArrayOf(2,4)
}



fun twoSum2(numbers: IntArray, target: Int): IntArray {

    var i=0
    var j=numbers.size-1
    while(i<j){

        var sum = numbers[i]+numbers[j]
        if(sum== target)
            return intArrayOf(i+1,j+1)


        if(sum>target){
            j--
        }

        else i++

    }

    return intArrayOf(0,0)
}

fun generate(n: Int): List<List<Int>> {

    var ans = listOf<List<Int>>().toMutableList()
    for(i in 0 until n) {
        var list = mutableListOf<Int>()
        print("$i : ")
        for (j in 0 .. i) {
            print("$j, ")
            if (j == i || j == 0) {
                list.add(1)
            } else {
                var ele = ans[i-1][j-1] + ans[i-1][j]
                list.add(ele)
            }
        }
        ans.add(list)
        println(ans)
    }

    println(ans)
    return ans.toList()

}

fun getRow(n: Int): List<Int> {

    var ans = listOf<List<Int>>().toMutableList()
    for(i in 0 until n+1) {
        var list = mutableListOf<Int>()
        print("$i : ")
        for (j in 0 .. i) {
            print("$j, ")
            if (j == i || j == 0) {
                list.add(1)
            } else {
                var ele = ans[i-1][j-1] + ans[i-1][j]
                list.add(ele)
            }
        }
        ans.add(list)
        println(ans)
    }

    println(ans)
    return ans[n]
}

fun maxProfit(prices: IntArray): Int {

    var minPrice = Int.MAX_VALUE
    var maxProfit = Int.MIN_VALUE
    for(price in prices){

        minPrice = min(minPrice, price)
        maxProfit = max(maxProfit , price - minPrice)
    }

    println(maxProfit)
    return maxProfit

}

fun arrayMajorityElement(nums: IntArray): Int {

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

fun threeSum(n: IntArray ) : List<List<Int>> {

    var nums = n.sorted().toMutableList()
    println(nums)

    var res = listOf<List<Int>>().toMutableList()
    for(idx in nums.indices){
        var tar = -nums[idx]
        if(idx >0 && nums[idx]==nums[idx-1]){
            continue
        }
        findTwoSum(nums,idx+1,res,tar)
    }

    println(res)
    return res
}

fun findTwoSum(nums: MutableList<Int>, idx: Int, res: MutableList<List<Int>>, tar: Int) {
    var i=idx
    var j=nums.size-1
    while(i<j){

        var sum = nums[i]+nums[j]
        if(sum >tar){
            j--
        }
        else if(sum==tar){
            res.add(listOf(tar*-1,nums[i],nums[j]))
            while(i<j && nums[i] == nums[i+1]){
                i++;
            }
            while(j>i && nums[j]==nums[j-1]){
                j--
            }
            i++
            j--

        }
        else i++
    }

}

fun threeSumClosest(n: IntArray, target: Int): Int {

    var nums = n.sorted().toMutableList()
    var res =Integer.MAX_VALUE
    var diff=Integer.MAX_VALUE
    for(idx in 0..nums.size-1){
        var tar = nums[idx]
        if(idx >0 && nums[idx]==nums[idx-1]){
            continue
        }

        var i = idx+1
        var j= nums.size-1
        while(i<j){
            var sum = nums[idx] + nums[i] + nums[j]
            if(Math.abs(target-sum)<Math.abs(diff)){
                diff = target-sum
            }
            if(sum<target){
                i++
            }
            else
                j--
        }
    }

    return target - diff
}

fun rotate(matrix: Array<IntArray>): Unit {

    matrix.toMutableList()

    //transpose
    for( i in 0..matrix.size-1){

        for( j in 0..matrix[i].size-1){

            if(j<i)
            {var temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i]=temp
            }
        }
    }

    //switching columns
    var first = 0
    var last = matrix[0].size-1

    while(first<last){
        for(row in 0..matrix.size-1){
            var temp = matrix[row][first]
            matrix[row][first] = matrix[row][last]
            matrix[row][last]= temp
        }
        first++
        last--
    }

}

fun mergeSortedArray(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i=0
    var j=0
    var k=0
    while(i<m && j<n){

        if(nums1[i]<=nums2[j]){
            i++
        }
        else {
            var temp=nums1[i]
            while(j<n && nums2[j]<nums1[i]){
                nums1[i]=nums2[j]
                i++
                j++
            }
            nums1[i]=temp
        }
        println("${nums1.contentToString()} ----- ${nums2.contentToString()}")
    }
    println("$i------$j")
    while(i+1<(m+n) && j<n){
        nums1[i+1]=nums2[j]
        i++
        j++
    }
    println(nums1.contentToString())
}


fun plusOne(digits: IntArray): IntArray {

    var carry=1
    var sum = intArrayOf().toMutableList()
    var idx= digits.size-1
    while(carry>0 && idx>=0 ){
        var temp = digits[idx]+carry
        sum.add(temp%10)
        if(temp>9){
            carry=1
        }
        else
            carry=0
        idx--
    }
    while(idx>=0){
        sum.add(digits[idx])
        idx--
    }
    if(carry>0)
        sum.add(1)

   var s = (sum.reversed()).toIntArray()
    println(s.contentToString())
    return s
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {

    nums.sort()
    var ans = listOf<List<Int>>().toMutableList()
    for(i in 0..nums.size-3) {

        for (temp in i + 1 until nums.size) {

            var j = temp

            var k = i + 1
            var l = j - 1
            while (k < nums.size && l < nums.size && k < l) {
                var sum = nums[i] + nums[j] + nums[k] + nums[l]
                if (sum > target) {
                    l--
                } else if (sum < target) {
                    k++
                } else {
                    ans.add(listOf(nums[i], nums[j], nums[k], nums[l]))
                    k++
                    l--
                    while (k + 1 < l && nums[k] == nums[k + 1])
                        k++

                    while (l - 1 > k && nums[l] == nums[l - 1])
                        l--

                    println(ans)
                }
            }
        }
    }

    println(ans)
    return ans

}