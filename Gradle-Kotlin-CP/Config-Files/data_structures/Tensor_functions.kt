package com.algospace.data_structures
import kotlin.math.*
import kotlin.collections.*
import java.util.*
fun <T:Comparable<T>> Tensor<T>.sort(lambda:((T,T)->Int)?=null){
    var m=this.size()
    var list:ArrayList<T> =ArrayList(m)
    for(i in 0..(m-1)){
        list.add(this[i])
    }
    if(lambda==null){
       list.sort()
    }
    else{
        list.sortWith(lambda)
    }
    for(i in 0..(m-1)){
        this[i]=list[i]
    }
}
fun <T:Comparable<T>> Tensor<T>.lower_bound(e:T):Int{
    var low=0
    var high=this.size()-1
    while(low<=high){
        var mid=low+(high-low)/2
        if(this[mid].compareTo(e)==1 || this[mid].compareTo(e)==0) high=mid-1
        else low=mid+1
    }
    return low
}
fun <T:Comparable<T>> Tensor<T>.upper_bound(e:T):Int{
    var low=0
    var high=this.size()-1
    while(low<=high){
        var mid=low+(high-low)/2
        if(this[mid].compareTo(e)==1) high=mid-1
        else low=mid+1
    }
    return low
}
fun <T:Comparable<T>> printTensor(tensor:Tensor<T>){
    for(i in 0..(tensor.size()-1))print("${tensor[i]} ")
    println()
}
fun <T:Comparable<T>> printTensorOfTensor(tensor:Tensor<Tensor<T>>){
    for(i in 0..(tensor.size()-1)){
        for(j in 0..(tensor[i].size()-1)){
            print("${tensor[i][j]} ")
        }
        println()
    }
}

fun <T:Comparable<T>> tensorOf(vararg t:T):Tensor<T>{
    var m=t.size
    var tensor=Tensor<T>(m)
    for(i in 0..(m-1))tensor[i]=t[i]
    return tensor
}
fun <T:Comparable<T>> Tensor<T>.min():T{
    if(this.size()==0){
        if(this.defaultValue==null){
            println("Empty Tensor, and defaultValue is null")
        }
        else return defaultValue!!
    }
    var ans=this[0]
    for(i in 1..(this.size()-1)){
        if(this[i].compareTo(ans)==-1)ans=this[i]
    }
    return ans
}
fun <T:Comparable<T>> Tensor<T>.max():T{
    if(this.size()==0){
        if(this.defaultValue==null){
            println("Empty Tensor, and defaultValue is null")
        }
        else return defaultValue!!
    }
    var ans=this[0]
    for(i in 1..(this.size()-1)){
        if(this[i].compareTo(ans)==1)ans=this[i]
    }
    return ans
}
fun Tensor<Int>.sum(i:Int,j:Int,f:LongArray):Long{
    return f[j+1]-f[i]
}
fun Tensor<Int>.prefixSum():LongArray{
    var n:Int=this.size()
    var f:LongArray =LongArray(n+1){0L}
    for(i in 0..(n-1))f[i+1]=this[i].toLong()+f[i]
    return f
}
@JvmName("ListToTensor")
fun <T:Comparable<T>> List<T>.toTensor():Tensor<T>{
    var m=this.size
    var tensor=Tensor<T>(m)
    for(i in 0..(m-1))tensor[i]=this.get(i)
    return tensor
}
@JvmName("MutableListToTensor")
fun <T:Comparable<T>> MutableList<T>.toTensor():Tensor<T>{
    var m=this.size
    var tensor=Tensor<T>(m)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
}
@JvmName("ArrayToTensor")
fun <T:Comparable<T>> Array<T>.toTensor():Tensor<T>{
    var m=this.size
    var tensor=Tensor<T>(m)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
} 
@JvmName("IntArrayToTensor")
fun IntArray.toTensor():Tensor<Int>{
    var m=this.size
    var tensor=Tensor<Int>(m)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
}
@JvmName("LongArrayToTensor")
fun LongArray.toTensor():Tensor<Long>{
    var m=this.size
    var tensor=Tensor<Long>(m)
    for(i in 0..(m-1))tensor[i]=this[i]
    return tensor
} 
@JvmName("ListOfListToTensor")
fun <T:Comparable<T>> getTensorOfTensor(list:List<List<T>>):Tensor<Tensor<T>>{
    var m=list.size
    var n=list[0].size
    var tensor=Tensor<Tensor<T>>(m)
    for(i in 0..(m-1)){
        var e=Tensor<T>(n)
        for(j in 0..(n-1)){
            e[j]=list[i][j]
        }
        tensor[i]=e
    }
    return tensor
}
@JvmName("MutableListOfListToTensor")
fun <T:Comparable<T>> getTensorOfTensor(list:MutableList<List<T>>):Tensor<Tensor<T>>{
    var m=list.size
    var n=list[0].size
    var tensor=Tensor<Tensor<T>>(m)
    for(i in 0..(m-1)){
        var e=Tensor<T>(n)
        for(j in 0..(n-1)){
            e[j]=list[i][j]
        }
        tensor[i]=e
    }
    return tensor
}
@JvmName("MutableListOfMutableListToTensor")
fun <T:Comparable<T>> getTensorOfTensor(list:MutableList<MutableList<T>>):Tensor<Tensor<T>>{
    var m=list.size
    var n=list[0].size
    var tensor=Tensor<Tensor<T>>(m)
    for(i in 0..(m-1)){
        var e=Tensor<T>(n)
        for(j in 0..(n-1)){
            e[j]=list[i][j]
        }
        tensor[i]=e
    }
    return tensor
}
fun <T:Comparable<T>> getListOfList(tensor:Tensor<Tensor<T>>):List<List<T>>{
    var m=tensor.size()
    var list:ArrayList<List<T>> =ArrayList(m)
    for(i in 0..(m-1)){
        var e=tensor[i].toList()
        list.add(e)
    }
    return list.toList()
}
fun <T:Comparable<T>> getMutableListOfList(tensor:Tensor<Tensor<T>>):MutableList<List<T>>{
    var m=tensor.size()
    var list:ArrayList<List<T>> =ArrayList(m)
    for(i in 0..(m-1)){
        var e=tensor[i].toList()
        list.add(e)
    }
    return list.toMutableList()
}
fun <T:Comparable<T>> getMutableListOfMutableList(tensor:Tensor<Tensor<T>>):MutableList<MutableList<T>>{
    var m=tensor.size()
    var list:ArrayList<MutableList<T>> =ArrayList(m)
    for(i in 0..(m-1)){
        var e=tensor[i].toMutableList()
        list.add(e)
    }
    return list.toMutableList()
}
