public class BinarySearchTreeDFS {
    Node head;
    public class Node{
        int data;
        Node left;
        Node right;

        public Node(int value){
            data = value;
            left = null;
            right = null;
        }
    }

    public boolean search(Node current, int value){
        if(current == null){
            return false;
        }

        if(current.data == value){
            return true;
        }

        if(current.data < value){
            return search(current.right, value);
        }

        return search(current.left, value);
    }

    public boolean depthFirstSearch(int value){
        return search(head, value);
    }
}
