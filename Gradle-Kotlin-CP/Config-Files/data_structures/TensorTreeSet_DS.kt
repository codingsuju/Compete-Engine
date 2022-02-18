package com.algospace.data_structures
import java.util.*
import kotlin.collections.*
class TensorTreeSet<T:Comparable<T>>:TreeSet<T>{
    constructor():super({a:T,b:T->a.compareTo(b)})
    constructor(lambda:(T,T)->Int):super(lambda)
    constructor(m:MutableCollection<out T>):super(m)
    constructor(m:SortedSet<T>):super(m)
    fun insert(e:T){super.add(e)}
    fun find(e:T):Boolean{return super.contains(e)}
    override fun clone():TensorTreeSet<T>{
        var newTensorTreeSet:TensorTreeSet<T> =TensorTreeSet()
        for(k in this){newTensorTreeSet.add(k)}
        return newTensorTreeSet
    }
}
