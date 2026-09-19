http://linkedin.com/in/vinod-raaj-b697597a  https://github.com/AnilDeshpande/UIThreadDemo/tree/longrunning-workder-demo linked in 
Results-driven Lead Android Engineer with 10+ years of experience building high-performance Android applications across OTT streaming, healthcare, and e-commerce domains. 
I specialize in Kotlin, Jetpack Compose, Clean Architecture, and scalable mobile solutions, with a strong focus on performance optimization, media playback, and user experience. 
Throughout my career, I have led complex Android initiatives, modernized legacy applications, reduced crashes, improved test coverage, 
and delivered production applications used by millions of users. I enjoy solving challenging technical problems, mentoring engineers, 
and collaborating with cross-functional teams to build reliable, maintainable, and impactful products. 
I am passionate about continuous learning and excited to cont    ribute to organizations building world-class mobile experiences. 
https://jobs.micro1.ai/post/success  
splunk  
How would you rate your proficiency with AWS? 

    Prepration interview .
State hoisting-design pattern
"State hoisting is the practice of moving state out of a Composable so it becomes stateless.
The parent or ViewModel owns the state and passes the current value and event callbacks to the child, 
following unidirectional data flow." data class A data class in Kotlin is a class specifically designed to hold data. 
It automatically provides common utility functions like equals(), hashCode(), toString(), copy(), 
and componentN() functions based on the properties defined in the primary constructor.  When should you NOT use data class?
* When the class has behavior-heavy logic (not just data)
When you don’t want copy() or destructuring
* When properties are not part of primary constructor
* When inheritance is required (data classes are final by default)
 Rules 
* Must have at least one parameter in primary constructor
* All parameters must be val or var
* Cannot be abstract, open, or sealed
 “copy() is used to create a new instance of a data class with some modified values while keeping the rest unchanged.
It is very useful in immutable state handling, especially in MVVM or MVI architecture.”  _uiState.value = _uiState.value.copy(isLoading = true)
 inline function “An inline function is a function where the compiler replaces the function call with the actual function body at compile time.
This helps reduce the overhead of function calls, especially when using higher-order functions with lambdas.”  The real benefit is:
* Avoids object creation for lambda
* Avoids function call overhead
* 
crossinline is used to prevent non-local return
 “Non-local return allows a lambda inside an inline function to return from the enclosing function. 
This is possible because inline functions replace the lambda at the call site. If we want to restrict this behaviour,
we use crossinline.”  Scope function  When you call such a function on an object with a lambda expression provided,
it forms a temporary scope. In this scope, you can access the object without its name. Such functions are called scope functions. 
There are five of them: let, run, with, apply, and also.
Let ,also ->it apply, run ->object run, with ->not a extension function
run combines object configuration and computation.
val result = run {
    val a = 10
    val b = 20
    a + b
}
val length = "Vinod".run {
    println(this)
    length
}
 sealed class  “A sealed class in Kotlin is used to represent a restricted class hierarchy where all possible subclasses are known at compile time. 
This makes it very useful for handling state in a type-safe way, especially with when expressions.”  “Both sealed class and enum class are used to represent restricted sets of values, but they differ in flexibility and use cases.” Enum
* Represents a fixed set of constants
* Each constant is a single instance 2. Data handling
* Enum → limited (same structure for all)
* Sealed → each type can have different data
* 👉 This is the biggest difference
* 
“In Kotlin, List is a read-only collection, meaning we cannot modify its contents through that reference, 
whereas MutableList allows modification like adding, removing, or updating elements.” Collections.synchronizedList() 
“Coroutines in Kotlin are a lightweight way to handle asynchronous programming. 
They help perform long-running tasks like network or database operations without blocking the main thread.”

🔥 Difference between launch and async
✅ launch
“Used for fire-and-forget tasks. It does not return a result, but returns a Job.” “Used when you need to return a result. 
It returns a Deferred, and we use await() to get the result.”
suspend function  A suspend function is a function that can be paused and resumed without blocking the underlying thread.
It is used for long-running operations like network or database calls.” “I handle API + DB operations using MVVM with coroutines,
repository pattern, and proper dispatcher management.” Java Interoperability (VERY IMPORTANT) 
“I use StateFlow in ViewModel to manage and expose UI state in a reactive and lifecycle-aware way.” 
“An extension function in Kotlin allows us to add new functionality to an existing class without modifying its source code or inheriting from it.
” “Extension functions do not actually modify the class; they are resolved statically at compile time.”
“We use abstract classes when we want to define a common base structure and force child classes to implement specific behavior.” 
“An interface in Kotlin is a contract that defines a set of abstract methods and properties that a class must implement. 
It is used to achieve abstraction and multiple inheritance of behavior.” 
eature	Interface	Abstract class
Multiple inheritance	✅ Yes	❌ No
State (variables)	Limited	Yes
Constructor	❌ No	✅ Yes
Use case	Contract	Base implementation
WorkManager
WorkManager is a Jetpack library for guaranteed background work that should run even if the app is killed or device restarts. workManager.getWorkInfoByIdLiveData(id)
States:
* ENQUEUED
* RUNNING
* SUCCEEDED
* FAILED
* BLOCKED
How do you handle large file upload reliably?
👉 Answer like this:
* Use WorkManager with network constraint
* Use retry with exponential backoff
* Use Foreground service inside worker for long tasks
 enqueueUniqueWork(..., KEEP)

👉 WorkManager persists work in DB → resumes automatically
setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK)

How does WorkManager store tasks?
👉 Uses internal SQLite DB
Foreground work in WorkManager?

setForegroundAsync(ForegroundInfo(...))
Long-running tasks (file upload, download) Can periodic work be exact?
👉 ❌ No 👉 It’s inexact (battery optimized)
What is expedited work?
👉 Runs immediately (like foreground priority) 👉 Limited quota
workManager.cancelWorkById(id)

"In my project, I used WorkManager for reliable background sync. 
I combined constraints + retry + unique work to avoid duplicate API calls and ensure data consistency even after app kill."

CoroutineScope defines the lifecycle of coroutines and ensures structured concurrency. It holds a Job and Dispatcher, 
and when the scope is cancelled, all child coroutines are cancelled. In Android, we use lifecycle-aware scopes like 
viewModelScope and lifecycleScope to avoid memory leaks and manage async work safely.  lambda A lambda is an expression that
describes a function. But instead of declaring a named function, you declare a function that has no name side effect 
In Jetpack Compose, a side effect is any operation that affects something outside the composable or should not happen during every recomposition.
Launch Mode Android provides 4 launch modes that control how Activities are created and maintained in the task back stack. Standard → Always new
SingleTop → Reuse if top
SingleTask → Reuse + clear above
SingleInstance → Separate task generic
Covariance in Kotlin generics allows a generic type of a subclass to be used where a generic type of its superclass is expected. It is declared using the out keyword.  
Coroutine cancellation. Hilt @Inject vs @Provides vs @Binds.

"Kotlin provides compile-time null safety, but Java doesn't have the same nullability system. Java values without nullability 
annotations can become platform types in Kotlin, so they can potentially cause NullPointerExceptions. I handle nullable values 
using safe calls, Elvis operators, and let, and avoid unnecessary !!. When I control the Java API, I use @Nullable and @NonNull
annotations so Kotlin can correctly understand the nullability contract."
