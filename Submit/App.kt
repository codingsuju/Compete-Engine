import java.util.*
import kotlin.math.*
private fun readLn()=readLine()!!
private fun readInt()=readLn().toInt()
private fun readLong()=readLn().toLong()
private fun readDouble()=readLn().toDouble()
private fun readStrings()=readLn().split(" ")
private fun readInts()=readStrings().map{it.toInt()}
private fun readLongs()=readStrings().map{it.toLong()}
private fun readDoubles()=readStrings().map{it.toDouble()}
val INF:Long = 10.0.pow(9).toLong()
val LINF:Long = 10.0.pow(18).toLong()
class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}
fun main(){
    println("Hello world")
}
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
class TensorTreeMap<K:Comparable<K>,V>:TreeMap<K,V>{
    constructor():super({a:K,b:K->a.compareTo(b)})
    constructor(lambda:(K,K)->Int):super(lambda)
    constructor(m:MutableMap<out K,out V>):super(m)
    constructor(m:SortedMap<K,out V>):super(m)
    override operator fun get(key:K):V{return super.get(key)!!}
    override fun clone():TensorTreeMap<K,V>{
        var newTensorTreeMap:TensorTreeMap<K,V> =TensorTreeMap()
        for((k,v) in this){newTensorTreeMap[k]=v}
        return newTensorTreeMap
    }
}
class TensorStack<T>():Stack<T>(){
    fun top():T{return super.peek()}
}
class TensorQueue<T>:ArrayDeque<T>,Queue<T>{
    constructor():super()
    constructor(n:Int):super(n)
    constructor(c:MutableCollection<out T>):super(c)
    fun front():T{return super.peek()}
    override fun poll():T{return super.poll()!!}
    override fun pop():T{return super.pollFirst()!!}
    override fun push(e:T){super.offer(e)}
}
class TensorDeque<T>:ArrayDeque<T>,Deque<T>{
    constructor():super()
    constructor(n:Int):super(n)
    constructor(c:MutableCollection<out T>):super(c)
    fun front():T{return super.peekFirst()!!}
    fun back():T{return super.peekLast()!!}
    fun pop_back():T{return super.pollLast()!!}
    fun pop_front():T{return super.pollFirst()!!}
}
class TensorPriorityQueue<T:Comparable<T>> :PriorityQueue<T>{
    constructor():super()
    constructor(n:Int):super(n)
    constructor(lambda:(T,T)->Int):super(lambda)
    constructor(n:Int,lambda:(T,T)->Int):super(n,lambda)
    constructor(c:MutableCollection<out T>):super(c)
    constructor(c:PriorityQueue<out T>):super(c)
    constructor(c:SortedSet<out T>):super(c)
}
class Tensor<T:Comparable<T>>(var n:Int,var defaultValue:T?,var preInitialize:Boolean):ArrayList<T?>(n),Comparable<Tensor<T>>{
    init{if(preInitialize==true)for(i in 0..(n-1))super.add(defaultValue)}
    constructor():this(10,null,false)
    constructor(n:Int):this(n,null,true)
    constructor(n:Int,defaultValue:T?):this(n,defaultValue,true)
    constructor(n:Int,preInitialize:Boolean):this(n,null,preInitialize)
    fun back():T{return super.get(super.size-1)!!}
    override fun clone():Tensor<T>{
        var m:Int=super.size
        var newTensor:Tensor<T> =Tensor(m,defaultValue)
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
