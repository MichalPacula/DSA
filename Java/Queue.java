public class Queue {
    public static class Node{
        int data;
        Node next;
        public Node(int value){
            this.data = value;
        }
    }

    public static class QueueClass{
        private Node head;
        private Node tail;

        public void peek(){
            if(head == null){
                System.out.println("Queue is empty!");
            } else{
                System.out.println(head.data);
            }
        }

        public int deque(){
            if(head == null){
                return -1;
            } else{
                Node tmp = head;
                head = head.next;
                tmp.next = null;
                return tmp.data;
            }
        }

        public void enqueue(int value){
            Node node = new Node(value);
            if(tail == null){
                head = node;
                tail = node;
                return;
            }
            tail.next = node;
            tail = node;
        }
    }

    public static void main(String[] args){
        QueueClass queue = new QueueClass();
        queue.enqueue(1);
        queue.peek();
        queue.enqueue(2);
        queue.peek();
        queue.enqueue(3);
        queue.peek();
        queue.enqueue(4);
        queue.peek();
        queue.enqueue(5);
        queue.peek();
        queue.deque();
        queue.peek();
        queue.deque();
        queue.peek();
        queue.deque();
        queue.peek();
        queue.deque();
        queue.peek();
        queue.deque();
        queue.peek();
    }
}
