package com.algospace.data_structures
import kotlin.collections.*
import java.util.*
class TensorSet<T>(var n:Int) :HashSet<T>(n){
    constructor():this(16)
    fun insert(e:T){super.add(e)}
}

