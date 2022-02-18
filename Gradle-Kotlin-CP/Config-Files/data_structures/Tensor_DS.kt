package com.algospace.data_structures
import kotlin.math.*
import kotlin.collections.*
import java.util.*
class Tensor<T:Comparable<T>>(var n:Int,var defaultValue:T?,var preInitialize:Boolean):ArrayList<T?>(n),Comparable<Tensor<T>>{
    init{if(preInitialize==true)for(i in 0..(n-1))super.add(defaultValue)}
    constructor():this(10,null,false)
    constructor(n:Int):this(n,null,true)
    constructor(n:Int,defaultValue:T?):this(n,defaultValue,true)
    constructor(n:Int,preInitialize:Boolean):this(n,null,preInitialize)
    fun back():T{return super.get(super.size-1)!!}
    override fun clone():Tensor<T>{
        var m:Int=super.size
        var newTensor:Tensor<T> =Tensor(n,defaultValue)
        for(i in 0..(m-1))newTensor[i]=this[i]
        return newTensor
    }
    override operator fun get(index:Int):T{return super.get(index)!!}
    fun front():T{return super.get(0)!!}
    fun push_back(e:T){super.add(e)}
    fun push_front(e:T){super.add(0,e)}
    fun pop_back(){super.removeAt(super.size-1)}
    fun pop_front(){super.removeAt(0)}
    operator fun set(index:Int,element:T):T?{return super.set(index,element)}
    fun setDefault(e:T){this.defaultValue=e}
    @JvmName("Size of Tensor")
    fun size():Int{ return super.size}
    override fun compareTo(other:Tensor<T>):Int{
        var ans=0
        var m=minOf(this.size(),other.size())
        for(i in 0..(m-1)){
            if(this[i].compareTo(other[i])==-1){
                ans=-1
                break
            }
            else if(this[i].compareTo(other[i])==1){
                ans=1
                break
            }
        }
        if(ans==0){
            if(this.size()<other.size())ans=-1
            else if(this.size()>other.size())ans=1
        }
        return ans
    }
    fun toList():List<T>{
        var m=this.size()
        var list:ArrayList<T> =ArrayList(m)
        for(i in 0..(m-1))list.add(super.get(i)!!)
        return list.toList()
    }
    fun toMutableList():MutableList<T>{
        var m=this.size()
        var list:ArrayList<T> =ArrayList(m)
        for(i in 0..(m-1))list.add(super.get(i)!!)
        return list.toMutableList()
    }
}
