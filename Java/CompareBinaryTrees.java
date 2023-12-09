public class CompareBinaryTrees {
    Node head;
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int value){
            data = value;
            left = null;
            right = null;
        }
    }

    public boolean compare(Node a, Node b){
        if(a == null && b == null){
            return true;
        }

        if (a == null || b == null){
            return false;
        }

        if (a.data != b.data){
            return false;
        }

        return compare(a.left, b.left) && compare(a.right, b.right);
    }
}
