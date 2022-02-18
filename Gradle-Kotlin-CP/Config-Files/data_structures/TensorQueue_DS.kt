package com.algospace.data_structures
import java.util.*
class TensorQueue<T>:ArrayDeque<T>,Queue<T>{
    constructor():super()
    constructor(n:Int):super(n)
    constructor(c:MutableCollection<out T>):super(c)
    fun front():T{return super.peek()}
    override fun poll():T{return super.poll()!!}
    override fun pop():T{return super.pollFirst()!!}
    override fun push(e:T){super.offer(e)}
}
