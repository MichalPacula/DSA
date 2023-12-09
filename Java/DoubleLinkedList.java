public class DoubleLinkedList {

    public static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int value){
            data = value;
        }
    }

    public static class LinkedList{
        private Node head;
        private Node tail;

        public void displayFromBeginning(){
            Node tmp = head;
            if(head != null) {
                while (tmp != null) {
                    System.out.println(tmp.data);
                    tmp = tmp.next;
                }
            } else{
              System.out.println("Linked List is empty!");
            }
        }

        public void displayFromEnd(){
            Node tmp = tail;
            if(tail != null) {
                while (tmp != null) {
                    System.out.println(tmp.data);
                    tmp = tmp.prev;
                }
            } else{
                System.out.println("Linked List is empty!");
            }
        }

        public void insertAtBeginning(int value){
            Node node = new Node(value);
            Node tmp = head;
            tmp.prev = node;
            node.next = tmp;
            head = node;
        }

        public void insertAtEnd(int value){
            Node node = new Node(value);
            Node tmp = tail;
            tmp.next = node;
            node.prev = tmp;
            tail = node;
        }

        public void insertAtPosition(int value, int position){
            Node node = new Node(value);
            Node tmp = head;
            for(int i = 1; i < position - 1; i++){
                tmp = tmp.next;
            }
            node.prev = tmp;
            node.next = tmp.next;
            tmp.next.prev = node;
            tmp.next = node;
        }

        public void deleteAtBeginning(){
            Node tmp = head;
            head = tmp.next;
            tmp.next = null;
            head.prev = null;
        }

        public void deleteAtEnd(){
            Node prev = tail.prev;
            Node curr = tail;
            prev.next = null;
            curr.prev = null;
        }

        public void deleteAtPosition(int position){
            Node prev = head;
            Node curr = head.next;
            for(int i = 1; i < position - 1; i++){
                prev = prev.next;
                curr = curr.next;
            }
            prev.next = curr.next;
            curr.next.prev = prev;
            curr.next = null;
            curr.prev = null;
        }
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        Node n1 = new Node(5);
        Node n2 = new Node(6);
        Node n3 = new Node(15);
        Node n4 = new Node(16);
        Node n5 = new Node(3);
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        linkedList.head = n1;
        linkedList.tail = n5;
        linkedList.displayFromBeginning();
        System.out.println();
        linkedList.displayFromEnd();
        System.out.println();
        linkedList.insertAtBeginning(30);
        linkedList.displayFromBeginning();
        System.out.println();
        linkedList.insertAtEnd(32);
        linkedList.displayFromBeginning();
        System.out.println();
        linkedList.insertAtPosition(25, 4);
        linkedList.displayFromBeginning();
        System.out.println();
        linkedList.deleteAtBeginning();
        linkedList.displayFromBeginning();
        System.out.println();
        linkedList.deleteAtEnd();
        linkedList.displayFromBeginning();
        System.out.println();
        linkedList.deleteAtPosition(4);
        linkedList.displayFromBeginning();
        System.out.println();
    }

}
