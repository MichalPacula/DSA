public class Stack {

    public static class Node{
        int data;
        Node prev;

        public Node(int value){
            data = value;
        }
    }

    public static class StackClass{
        private Node head;
        public int length = 0;

        public int peek(){
            return head.data;
        }

        public void push(int value){
            length++;
            Node node = new Node(value);
            if(head == null){
                head = node;
                return;
            }
            node.prev = head;
            head = node;
        }

        public int pop(){
            length = Math.max(0, length - 1);
            if(length == 0){
                Node tmp = head;
                head = null;
                tmp.prev = null;
                return tmp.data;
            }
            Node tmp = head;
            head = tmp.prev;
            tmp.prev = null;
            return tmp.data;
        }
    }

    public static void main(String[] args){
        StackClass stack = new StackClass();
        stack.push(1);
        System.out.println(stack.peek());
        stack.push(2);
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.peek());
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
