package com.algospace.data_structures
import java.util.*
class TensorDeque<T>:ArrayDeque<T>,Deque<T>{
    constructor():super()
    constructor(n:Int):super(n)
    constructor(c:MutableCollection<out T>):super(c)
    fun front():T{return super.peekFirst()!!}
    fun back():T{return super.peekLast()!!}
    fun pop_back():T{return super.pollLast()!!}
    fun pop_front():T{return super.pollFirst()!!}
}
