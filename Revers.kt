
// import kotlinx.coroutines.*
// import kotlinx.coroutines.flow.*
// import java.util.Date
// import java.util.Locale
// import java.util.TimeZone
// import java.text.SimpleDateFormat
fun main() {
    runBlocking{
    val time = TimeStampFlow()
   val flowTime=time.getFlow(4)
   flowTime.collect{
        println(it)
   }
    }

}

class TimeStampFlow(){
    val dformate="dd-MM-yyyy hh:mm:ss a"
    val timeFormate=SimpleDateFormat(dformate,Locale.getDefault()).apply{
    timeZone = TimeZone.getTimeZone("Asia/Kolkata")}
    fun getFlow(times:Int):Flow<String> =flow{
    repeat(times){index->
        delay(1000)
     val text=timeFormate.format(Date(System.currentTimeMillis()))
      emit("acquired count $index and time $text")
    }    
    }
}
import java.util.LinkedHashMap
fun main() {
val lruCache = LruCache<Int,String>(3)
    lruCache.putc(1,"rudra")
    lruCache.putc(2,"vinod")
    lruCache.putc(3,"vanitha")
    lruCache.getC(1)
    lruCache.putc(4,"raj")
println(lruCache.toString())
}
class LruCache<k,v>(private val capacity:Int){
    private val  cache=object:LinkedHashMap<k,v>(capacity,0.75f,true){
        override fun removeEldestEntry(eldest:MutableMap.MutableEntry<k,v>?):Boolean{
            return size>capacity
        }
    }
    fun getC(key:k):v?{
        return cache[key]
    }
    fun putc(key:k,inp:v){
        cache.put(key,inp)
    }
    fun removec(key:k){
        cache.remove(key)
    }
    override fun toString():String{
	return cache.toString()}
}

fun emitNumbers(no:Int):Flow<Int> =flow{
    repeat(no){it->
        emit(it+1)
    }
}
 flowInt.filter{it%2==0}.collect{
       println(it)
   }
  val flowInt=emitNumbers(10)
   flowInt.filter{it%2==0}.map{it*it}.collect{
       println(it)
   }
    }
fun evenNumbers(no: Int): Flow<Int> = flow {
    repeat(no){index->
        val num=index+1
        if(num %2==0) emit(num)
    }
}
fun main() {
    runBlocking {
        val flowInt = emitNumbers(10)
            .filter { it % 2 == 0 }
            .map { it * 10 }

        flowInt.collect {
            println(it)
        }
    }
}

fun emitNumbers(no: Int): Flow<Int> = flow {
    repeat(no) {
        delay(300)
        emit(it + 1)
    }
}
