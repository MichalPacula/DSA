import java.util.*;
import java.util.Queue;

public class BFSGraphMatrix {
    public static LinkedList<Integer> bfs(int[][] graph, int source, int value){
        boolean[] seen = new boolean[graph.length];
        int[] prev = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            seen[i] = false;
        }
        for(int i = 0; i < graph.length; i++){
            prev[i] = -1;
        }

        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        do{
           int current = queue.remove();
           if(current == value){
               break;
           }

           int[] adjs = graph[current];
           for(int i = 0; i < adjs.length; i++){
               if(adjs[i] == 0){
                   continue;
               }
               if(seen[i]){
                   continue;
               }
               seen[i] = true;
               prev[i] = current;
               queue.add(i);
           }
        } while(!queue.isEmpty());

        int current = value;
        LinkedList<Integer> out = new LinkedList<>();
        int i = 0;
        while(prev[current] != -1){
            out.add(current);
            current = prev[current];
            i++;
        }

        if(!out.isEmpty()){
            Collections.reverse(out);
            out.add(0, source);
            return out;
        }
        return new LinkedList<>();
    }

    public static void main(String[] args){
        int[][] graph = new int[][]{{0, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 1, 0}};
        System.out.println(bfs(graph, 0, 4));
    }
}
