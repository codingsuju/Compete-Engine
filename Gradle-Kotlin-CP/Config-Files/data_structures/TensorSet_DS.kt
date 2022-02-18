package com.algospace.data_structures
import kotlin.collections.*
import java.util.*
class TensorSet<T>(var n:Int) :HashSet<T>(n){
    constructor():this(16)
    fun insert(e:T){super.add(e)}
    override fun clone():TensorSet<T>{
        var m=this.size
        var newTensorSet:TensorSet<T> =TensorSet(m)
        for(k in this){newTensorSet.add(k)}
        return newTensorSet
    }
}

