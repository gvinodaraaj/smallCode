
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

fun emitNumbers(no:Int):Flow<Int> =flow{
    repeat(no){it->
        emit(it+1)
    }
}
fun evenNumbers(no: Int): Flow<Int> = flow {
    repeat(no){index->
        val num=index+1
        if(num %2==0) emit(num)
    }
}
