fun main() {
    val kotlin = "swiiss"
   
    println(firstNonRepeting2(kotlin))
}
fun main() {
    val kotlin = "aaabbccccda"
   
    println(strCompres(kotlin))
}
fun strCompres(a: String): String {
    if (a.isEmpty()) return ""
    val result = StringBuilder()
    var count = 1
    for (i in 1 until a.length) {
        if (a[i] == a[i - 1]) {
            count++
        } else {
            result.append(a[i - 1])
            result.append(count)
            count = 1
        }
    }
    result.append(a.last())
    result.append(count)
    return result.toString()
}
 fun firstNonRepeting(a:String):String{
     val result=a.groupBy{it}.asSequence().firstOrNull{ it.value.size == 1 }
        ?.key
        ?.toString()
        ?: "No non-repeating character"
     return result
 }
  fun firstNonRepeting2(a:String):String{
     val map = LinkedHashMap<Char, Int>()
     a.forEach(){ch->
         map[ch]= map.getOrDefault(ch,0)+1
     }
     return map.asSequence().firstOrNull{ it.value == 1 }
        ?.key
        ?.toString()
        ?: "No non-repeating character"
 }
