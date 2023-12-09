import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class MazeSolver {

    static int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static boolean walk(String[] maze, char wall, HashMap<String, Integer> curr, HashMap<String, Integer> end, boolean[][] seen, Stack<HashMap<String, Integer>> path){
        if(curr.get("x") < 0 || curr.get("x") >= maze[0].length() || curr.get("y") < 0 || curr.get("y") >= maze.length){
            return false;
        }

        if(maze[curr.get("y")].charAt(curr.get("x")) == wall){
            return false;
        }

        if(Objects.equals(curr.get("x"), end.get("x")) && Objects.equals(curr.get("y"), end.get("y"))){
            path.push(end);
            return true;
        }

        if(seen[curr.get("y")][curr.get("x")]){
            return false;
        }

        seen[curr.get("y")][curr.get("x")] = true;
        path.push(curr);
        for(int[] i: direction) {
            HashMap<String, Integer> newCurr = new HashMap<String, Integer>();
            newCurr.put("x", curr.get("x") + i[0]);
            newCurr.put("y", curr.get("y") + i[1]);
            if(walk(maze, wall, newCurr, end, seen, path)){
                return true;
            }
        }
        path.pop();
        return false;
    }

    public static Stack<HashMap<String, Integer>> solve(String[] maze, char wall, HashMap<String, Integer> start, HashMap<String, Integer> end){
        boolean[][] seen = new boolean[maze.length][maze[0].length()];
        Stack<HashMap<String, Integer>> path = new Stack<HashMap<String, Integer>>();
        for(int i = 0; i < maze.length; i++){
            Arrays.fill(seen[i], false);
        }
        walk(maze, wall, start, end, seen, path);
        return path;
    }

    public static void main(String[] args){
        String[] maze = new String[]{"xxxxxxxxxx x", "x        x x", "x        x x", "x xxxxxxxx x", "x          x", "x xxxxxxxxxx"};
        HashMap<String, Integer> start = new HashMap<String, Integer>();
        start.put("x", 10);
        start.put("y", 0);
        HashMap<String, Integer> end = new HashMap<String, Integer>();
        end.put("x", 1);
        end.put("y", 5);
        System.out.println(Arrays.toString(solve(maze, 'x', start, end).toArray()));
    }
}
