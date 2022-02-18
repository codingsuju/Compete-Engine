package com.algospace.data_structures
import java.util.*
class TensorPriorityQueue<T:Comparable<T>> :PriorityQueue<T>{
    constructor():super()
    constructor(n:Int):super(n)
    constructor(lambda:(T,T)->Int):super(lambda)
    constructor(n:Int,lambda:(T,T)->Int):super(n,lambda)
    constructor(c:MutableCollection<out T>):super(c)
    constructor(c:PriorityQueue<out T>):super(c)
    constructor(c:SortedSet<out T>):super(c)
}
