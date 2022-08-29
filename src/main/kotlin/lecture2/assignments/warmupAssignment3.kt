package lecture2.assignments


fun main() {
//    https://leetcode.com/problems/happy-number/ - checked discussion for this
//     isHappy(121)


//https://leetcode.com/problems/power-of-two/
//    isPowerOfTwo(12)

//https://leetcode.com/problems/valid-anagram/
//   val flag = isAnagram("car","rac")
//    println(flag)

//https://leetcode.com/problems/ugly-number/
//    isUgly(24)

//https://leetcode.com/problems/move-zeroes/
//    moveZeroes(IntArray(2){5})

//https://leetcode.com/problems/reverse-vowels-of-a-string/
//    reverseVowels("anirudh")

//https://leetcode.com/problems/third-maximum-number/
//    thirdMax(IntArray(3, ))

//https://leetcode.com/problems/find-the-difference/
//    findTheDifference("","y")

//https://leetcode.com/problems/add-digits/
//    addDigits(50)

//https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
//    getLucky("zbax",2)

}


fun isPowerOfTwo(n: Int): Boolean {
    if(n==1)
        return true

    var i=1
    var res = powerOf2(i.toLong(),n.toLong())
    return res
}

fun powerOf2(i:Long, n:Long) : Boolean{
    if(i==n)
        return true

    if(i>n)
        return false

    return powerOf2(i*2,n)

}

private fun getNext(n: Int): Int {
    var n = n
    var totalSum = 0
    while (n > 0) {
        val d = n % 10
        n = n / 10
        totalSum += d * d
    }
    return totalSum
}

fun isHappy(n: Int): Boolean {
    var n = n
    val seen: MutableSet<Int> = HashSet()
    while (n != 1 && !seen.contains(n)) {
        seen.add(n)
        n = getNext(n)
    }
    return n == 1
}


//fun moveZeroes(int[] nums)
//{
//    var first=0;
//    var second=0;
//
//    while(second<nums.length)
//    {
//        if(nums[second]!=0)
//        {
//            int temp=nums[first];
//            nums[first]=nums[second];
//            nums[second]=temp;
//            first++;
//        }
//        second++;
//    }
//
//}



fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    var mp = mutableMapOf<Int, Int>()

    //fill the map with count of each aplhabet in s
    for (ch in s) {
        var key = ch - 'a'
        if (mp.containsKey(key)) {
            mp[key] = (mp.get(key)?.plus(1) ?: return false)
        } else mp[key] = 1
    }

    //decrease the count in mp
    for (ch in t) {
        var key = ch - 'a'
        if (mp.containsKey(key)) {
            var count = mp.get(key)
            if (count != null) {
                mp.put(key, count - 1)
            }
        } else
            return false
    }

    //check if freq is 0 for every key in map
    mp.forEach { entry ->
        var key = entry.key
        var value = entry.value
        if (value != 0)
            return false
    }
    return true
}


fun isUgly(num: Int): Boolean {
    var n = num
    while (n > 1) {
        if (n % 2 == 0) n = n / 2
        else if (n % 3 == 0) n = n / 3
        else if (n % 5 == 0) n = n / 5
        else
            return false
    }
    if (n == 1)
        return true
    return false
}


fun reverseVowels(str: String): String {

    var s = str.toMutableList()
    var i = 0
    var j = str.length - 1
    while (i < j) {

        if (isVowel(s[i]) == true && isVowel(s[j]) == true) {
            var temp = s[i]
            s[i] = s[j]
            s[j] = temp
            i++;
            j--;
        } else {
            if (isVowel(s[i])) {
                j--;
            } else
                i++;
        }

    }
    return s.joinToString("")

}

fun isVowel(ch: Char): Boolean {
    if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
        return true

    return false
}

fun thirdMax(arr: IntArray): Int {

    var max = Long.MIN_VALUE
    print(max)
    var smax= Long.MIN_VALUE
    var tmax = Long.MIN_VALUE
    var flag = false

    for(n in arr){

        var nums = n.toLong()

        if(nums>max){
            tmax=smax
            smax=max
            max=nums
        }
        else if(nums>smax && nums!=max){
            tmax=smax
            smax=nums

        }
        else if(nums>=tmax && nums!=smax && nums!=max){
            tmax=nums
        }

    }

    if(tmax==Long.MIN_VALUE)
        return max.toInt()

    return tmax.toInt()

}


fun findTheDifference(s: String, t: String) {
    var i=0
    var j=0
    var mp = mutableMapOf<Char,Int>()
    while(i<s.length || j<t.length){

        if(i<s.length){
            var key = s[i]
            if(mp.containsKey(key)== true){
                mp[key] = mp.get(key)?.plus(1)?:0
            }
            else
                mp[key] =1
            i++
        }

        if(j<t.length){
            var key = t[j]
            if(mp.containsKey(key)== true && mp.get(key)!! >0){
                mp[key] = mp.get(key)?.minus(1)?:0
            }
            else
                mp[key] =1
                j++
        }
    }

    for (mutableEntry in mp) {
        if(mutableEntry.value==1){
            println(mutableEntry.key)
        }
    }
}

fun addDigits(n: Int): Int {

    var num=n
    if(num/10 == 0)
        return num

    var sum=0
    while(num>0){
        var rem = num%10
        sum=sum+rem
        num=num/10
    }

    return addDigits(sum)
}

fun getLucky(s: String, k: Int): Int {

    println(s[0]-'a' +1)
    var l=k
    var num = convertFromString(s)
    println(num)
    var sum=0
    while(l>0){
        num.forEach {
            sum+= it-'0'
        }
        num = sum.toString()
        println("new num : $num")
        sum=0
        l-=1
    }

    return num.toInt()

}

fun convertFromString(s: String): String {

    var str =""
    s.forEach {
        var value = it -'a'+1
//        println("value : $value")
        str+=value
//        println(str)
    }
    return str
}
