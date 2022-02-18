package com.algospace.data_structures
import kotlin.collections.*
import java.util.*
class TensorMap<K,V>(var n:Int,var defaultValue:V?) :HashMap<K,V>(n){
    constructor():this(16,null)
    constructor(n:Int):this(n,null)
    override operator fun get(key:K):V{
        if(this.contains(key)==false) return defaultValue!!
        return super.get(key)!!
    }
    override fun clone():TensorMap<K,V>{
        var m=this.size
        var newTensorMap:TensorMap<K,V> =TensorMap(m)
        for((k,v) in this){newTensorMap[k]=v}
        return newTensorMap
    }
} 
