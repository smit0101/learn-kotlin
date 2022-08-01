import java.util.LinkedList
import java.util.Queue



class Graph(private val adj:ArrayList<MutableSet<Int>>){
    fun add(source:Int,value:MutableSet<Int>){
        adj.add(source,value)
    }

    fun traversal(src:Int, des:Int){
        val visited = MutableList(adj.size){false}
        val queue:Queue<Int> = LinkedList()

        queue.add(src)
        visited[src] = true
        while(queue.isNotEmpty()){
            val cur = queue.poll()
            println(cur)
            if(cur == des) break
            for(value in adj[cur]){
                if(!visited[value]){
                    visited[value] = true
                    queue.add(value)
                }
            }
        }
        println(queue)

    }

    fun print(){
        for((index,value) in adj.withIndex()){
            print("$index -> $value")
            println()
        }
    }

}
fun main() {
   val gh = Graph(ArrayList())
    gh.add(0, mutableSetOf(1,2))
    gh.add(1, mutableSetOf(2))
    gh.add(2, mutableSetOf(0,3))
    gh.add(3, mutableSetOf(3))
    gh.print()

    gh.traversal(2,5)
}