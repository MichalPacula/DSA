import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversals {
    Node head;

    public static class Node{
        Node left;
        Node right;
        int data;

        public Node(int value){
            data = value;
        }
    }

    public ArrayList<Integer> walkPreOrder(Node current, ArrayList<Integer> path){
        if(current == null){
            return path;
        }

        path.add(current.data);
        walkPreOrder(current.left, path);
        walkPreOrder(current.right, path);
        return path;
    }

    public ArrayList<Integer> preOrderTraversal(){
        return walkPreOrder(head, new ArrayList<Integer>());
    }

    public static ArrayList<Integer> walkInOrder(Node current, ArrayList<Integer> path){
        if(current == null){
            return path;
        }

        walkInOrder(current.left, path);
        path.add(current.data);
        walkInOrder(current.right, path);
        return path;
    }

    public ArrayList<Integer> inOrderTraversal(){
        return walkInOrder(head, new ArrayList<Integer>());
    }

    public ArrayList<Integer> walkPostOrder(Node current, ArrayList<Integer> path){
        if(current == null){
            return path;
        }

        walkPostOrder(current.left, path);
        walkPostOrder(current.right, path);
        path.add(current.data);
        return path;
    }

    public ArrayList<Integer> postOrderTraversal(){
        return walkPostOrder(head, new ArrayList<Integer>());
    }

    public boolean breadthFirstSearch(int value){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            if(current == null){
                continue;
            }

            if(current.data == value){
                return true;
            }

            queue.add(current.left);
            queue.add(current.right);
        }

        return false;

    }

}
