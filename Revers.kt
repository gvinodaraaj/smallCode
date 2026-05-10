fun main() {
    val kotlin = "myself is vinod hello"
    val arrCh = kotlin.toCharArray()
    var start=0
    reversString(arrCh,start,arrCh.size-1) // Reverse each word in place
    arrCh.forEachIndexed(){i,ch->
        if(ch==' ')
        {
            reversString(arrCh,start,i-1)
            start=i+1
        }
    }
    reversString(arrCh,start,arrCh.size-1)
    println(arrCh.joinToString(""))
}
  
fun reversString(arrCh:CharArray,start:Int,end:Int){
    var left=start
    var right=end
    while(left<right){
        val temp=arrCh[left]
        arrCh[left]=arrCh[right]
        arrCh[right]=temp
        left++
        right--
    }
}
