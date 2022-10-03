package lecture2.assignments


fun main(){
//    https://leetcode.com/problems/find-common-characters/
//        findShortestSubArray(intArrayOf(1,2,2,1))


//https://leetcode.com/problems/third-maximum-number/
//    thirdMax2(intArrayOf(4,5,6))


//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//    findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1))


//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
//    minMoves(intArrayOf(1,2,3))


//https://leetcode.com/problems/assign-cookies/
//    findContentChildren(intArrayOf(2,4), intArrayOf(1,1,1))


//https://leetcode.com/problems/degree-of-an-array/
    findShortestSubArray(intArrayOf(3,5,6,5,2,2))


//https://leetcode.com/problems/can-place-flowers/
//    canPlaceFlowers(intArrayOf(1,0,0,0,1,0),2)


//https://leetcode.com/problems/plus-one/
//    plusOne2(intArrayOf(9,9,9))


//https://leetcode.com/problems/single-number/
//    singleNumber(intArrayOf(4,4,1,1,2))


//https://leetcode.com/problems/single-number-ii/ - Bit Manipulation (Not done in class)


//https://leetcode.com/problems/single-number-iii/ - Bit Manipulation (Not done in class)


//https://leetcode.com/problems/multiply-strings/
        multiplyStrings("0","210")

//https://leetcode.com/problems/valid-tic-tac-toe-state/
//        validTicTacToe() //done using java

//https://leetcode.com/problems/ones-and-zeroes/ - dp(not done in class)

}

fun findShortestSubArray2(nums: IntArray): Int {
    val hm: MutableMap<Int, Int> = HashMap()
    var deg = 1
    for (ele in nums) {
        if (hm.containsKey(ele)) {
            hm[ele] = hm[ele]!! + 1
            deg = Math.max(deg, hm[ele]!!)
        } else hm[ele] = 1
    }
    println(deg)
    if (deg == 1) return 1
    var ans = Int.MAX_VALUE
    var winl = 0
    var winr = 0
    hm.clear()
    while (winl <= winr && winr < nums.size) {
        val ele = nums[winr]
        if (hm.containsKey(ele)) {
            //update count
            val `val` = hm[ele]!! + 1
            hm[ele] = `val`
            if (hm[ele] == deg) {
                //update winLeft
                while (winl <= winr && nums[winl] != ele) {
                    if (hm.containsKey(nums[winl])) {
                        val freq = hm[nums[winl]]!!
                        if (freq > 1) {
                            hm[nums[winl]] = freq - 1
                        } else hm.remove(nums[winl])
                    }
                    winl++
                }
                println(nums[winl].toString() + " " + nums[winr])
                ans = Math.min(ans, winr - winl + 1)
            }
        } else {
            //add in hm
            hm[ele] = 1
        }
        winr++
    }
    return ans
}

fun minMoves(nums: IntArray): Int {
    var min = Int.MAX_VALUE
    for (i in nums.indices) {
        min = Math.min(min, nums[i])
    }
    var res = 0
    for (ele in nums) {
        res += (ele - min)
    }
    return res
}

fun findShortestSubArray(nums: IntArray): Int {
    val hm: MutableMap<Int, Int> = HashMap()
    var deg = 1
    for (ele in nums) {
        if (hm.containsKey(ele)) {
            hm[ele] = hm[ele]!! + 1
            deg = Math.max(deg, hm[ele]!!)
        } else hm[ele] = 1
    }
    println(deg)
    if (deg == 1) return 1
    var ans = Int.MAX_VALUE
    var winl = 0
    var winr = 0
    hm.clear()
    while (winl <= winr && winr < nums.size) {
        val ele = nums[winr]
        if (hm.containsKey(ele)) {
            //update count
            val `val` = hm[ele]!! + 1
            hm[ele] = `val`
            if (hm[ele] == deg) {
                //update winLeft
                while (winl <= winr && nums[winl] != ele) {
                    if (hm.containsKey(nums[winl])) {
                        val freq = hm[nums[winl]]!!
                        if (freq > 1) {
                            hm[nums[winl]] = freq - 1
                        } else hm.remove(nums[winl])
                    }
                    winl++
                }
                println(nums[winl].toString() + " " + nums[winr])
                ans = Math.min(ans, winr - winl + 1)
            }
        } else {
            //add in hm
            hm[ele] = 1
        }
        winr++
    }
    return ans
}

//public boolean validTicTacToe(String[] board) {
//    char winRow='a';
//    char winCol='a';
//    char winDiag='a';
//    int xFreq=0;
//    int oFreq=0;
//    for(int i=0; i<3; i++){ // for row
//        String str = board[i];
//        for(int j=0; j<3; j++){ // for col
//            if(str.charAt(j)=='X'){
//                xFreq++;
//            }
//            else if(str.charAt(j)=='O'){
//                oFreq++;
//            }
//        }
//    }
//
//    char b[][]={board[0].toCharArray(),board[1].toCharArray(),board[2].toCharArray()};
//    winRow = checkWinnerRow(b);
//    winCol =checkWinnerCol(b);
//    winDiag=checkWinnerDiag(b);
//
//    //winner present
//
//    if(oFreq>xFreq)
//        return false;
//
//    if(xFreq-oFreq==0 && (winRow=='X' || winCol =='X' || winDiag =='X' )){
//        return false;
//    }
//
//    if(xFreq-oFreq==1 && (winRow=='O' || winCol =='O' || winDiag =='O')){
//        return false;
//    }
//
//    if(xFreq-oFreq>=2)
//        return false;
//
//    return true;
//}
//
//char checkWinnerRow(char board[][]){
//    var res =0;
//    for(int i=0; i<3; i++){
//        if(board[i][0]=='X' && board[i][1]=='X' && board[i][2]=='X')
//            return 'X';
//
//        if(board[i][0]=='O' && board[i][1]=='O' && board[i][2]=='O')
//            return 'O';
//    }
//    return 'a';
//}
//
//char checkWinnerCol(char board[][]){
//    var res =0;
//    for(int i=0; i<3; i++){
//        if(board[0][i]=='X' && board[1][i]=='X' && board[2][i]=='X')
//            return 'X';
//
//        if(board[0][i]=='O' && board[1][i]=='O' && board[2][i]=='O')
//            return 'O';
//    }
//    return 'a';
//}
//
//char checkWinnerDiag(char board[][]){
//    var res =0;
//    if((board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X') || (board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X'))
//        return 'X';
//
//
//    if((board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')  ||
//        (board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O'))
//        return 'O';
//
//    return 'a';
//}


    fun multiplyStrings(num1: String, num2: String): String {

        if(num1.equals("0") || num2.equals("0")) return "0"

        var res = ""
        var pow = 0
        for(idx in num1.length-1 downTo 0){
            var a = num1[idx]-'0'
            var j=num2.length-1
            var temp=""
            var lz = pow
            while(lz>0){
                temp+="0"
                lz--
            }
            var carry=0
            while(carry>0 || j>=0){
                var b = if(j<0) 0 else num2[j]-'0'
                var mul = a*b + carry
                var rem = mul%10
                temp=temp+rem
                carry = mul/10
                j--
            }
            // println(temp)
            res = add(res,temp)
            pow+=1
        }

        return res.reversed()
    }




fun add(res:String , temp:String) : String{
    var carry=0
    var i=0;
    var j=0;
    var ans=""
    while(i<res.length || j<temp.length || carry >0){
        var a = if(i>=res.length) 0 else { res[i]-'0'}
        var b = if(j>=temp.length) 0 else { temp[j]-'0'}
        var sum = a+b+carry
        var rem = sum%10
        carry = sum/10
        ans=ans+rem
        i++
        j++
    }
    // println(ans)
    return ans
}

fun singleNumber(nums: IntArray): Int {

    var ans =0
    for(ele in nums){
        ans = ans xor ele
    }

    return ans
}


fun thirdMax2(nums: IntArray): Int {

    var ans = mutableListOf<Int>()
nums.sort()

    var fMax=Long.MIN_VALUE
    var sMax=Long.MIN_VALUE
    var tMax=Long.MIN_VALUE

    for(ch in nums){

        var ele =ch.toLong()

        if(ele > fMax ){
            tMax=sMax
            sMax=fMax
            fMax=ele

        }
        else if(ele > sMax && ele!=fMax){
            tMax=sMax
            sMax=ele
        }
        else if(ele >tMax && ele!=sMax && ele!=fMax){
            tMax=ele
        }
    }
    if(tMax==Long.MIN_VALUE)
        return fMax.toInt()

    return tMax.toInt()
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {

    nums.sort()

    var ans = mutableListOf<Int>()

    for(idx in 0..nums.size-1){
        var tar = Math.abs(nums[idx])
        if(nums[tar-1]>0){
            nums[tar-1]*=-1
        }
    }

    for(idx in nums.indices){
        if(nums[idx]>0){
            ans.add(idx+1)
        }
    }

    return ans.toList()

}

fun findContentChildren(g: IntArray, s: IntArray): Int {

    g.sort()
    s.sort()
    var n = g.size
    var m = s.size
    var i=0;
    var j=0;
    var count=0
    while(i<n && j<m){
        var greed =g[i]
        while(j<m && s[j]<greed){
            j++
        }
        if(j<m && s[j]>=greed){
            count++
        }
        i++
        j++

    }
    return count
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {

    if(n==0)
        return true
    var idx=0
    var count=n
    while(idx<flowerbed.size){

        if(flowerbed[idx]==1)
            idx+=2

        else{
            //check adjacent for this idx
            if((idx-1>=0 && flowerbed[idx-1] == 1 )|| (idx+1<flowerbed.size && flowerbed[idx+1]==1))
                idx+=1

            else{
                count--
                flowerbed[idx]=1
                idx+=2
            }

        }
        if(count==0)
            break;
    }

    if(count==0)
        return true

    return false
}

fun plusOne2(digits: IntArray): IntArray {
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

    return (sum.reversed()).toIntArray()
}