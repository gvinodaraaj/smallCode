fun main() {
    val kotlin = "swiiss"
   
    println(firstNonRepeting2(kotlin))
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
