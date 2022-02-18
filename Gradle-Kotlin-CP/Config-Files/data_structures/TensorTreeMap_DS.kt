package com.algospace.data_structures
import java.util.*
import kotlin.collections.*
class TensorTreeMap<K:Comparable<K>,V>:TreeMap<K,V>{
    constructor():super({a:K,b:K->a.compareTo(b)})
    constructor(lambda:(K,K)->Int):super(lambda)
    constructor(m:MutableMap<out K,out V>):super(m)
    constructor(m:SortedMap<K,out V>):super(m)
    override operator fun get(key:K):V{return super.get(key)!!}
}
