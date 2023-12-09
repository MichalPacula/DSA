public class SingleLinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int value){
            data = value;
        }
    }

    public static class LinkedList{
        private Node head;

        public void display(){
            if(head != null){
                Node tmp = head;
                while(tmp != null){
                    System.out.println(tmp.data);
                    tmp = tmp.next;
                }
            } else{
                System.out.println("Linked List is empty!");
            }
        }

        public void insertAtBeginning(int value){
            Node node = new Node(value);
            node.next = head;
            head = node;
        }

        public void insertAtEnd(int value){
            Node node = new Node(value);
            Node tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }

        public void insertAtPosition(int value, int position){
            Node node = new Node(value);
            Node tmp = head;
            for(int i = 1; i < position - 1; i++){
                tmp = tmp.next;
            }
            node.next = tmp.next;
            tmp.next = node;
        }

        public void deleteAtBeginning(){
            Node tmp = head;
            head = tmp.next;
            tmp.next = null;
        }

        public void deleteAtEnd(){
            Node prev = head;
            Node curr = head.next;
            while(curr.next != null){
                curr = curr.next;
                prev = prev.next;
            }
            prev.next = null;
        }

        public void deleteAtPosition(int position){
            Node prev = head;
            Node curr = head.next;
            for(int i = 1; i < position - 1; i++){
                curr = curr.next;
                prev = prev.next;
            }
            prev.next = curr.next;
            curr.next = null;
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
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        linkedList.head = n1;
        linkedList.display();
        System.out.println();
        linkedList.insertAtBeginning(30);
        linkedList.display();
        System.out.println();
        linkedList.insertAtEnd(32);
        linkedList.display();
        System.out.println();
        linkedList.insertAtPosition(25, 4);
        linkedList.display();
        System.out.println();
        linkedList.deleteAtBeginning();
        linkedList.display();
        System.out.println();
        linkedList.deleteAtEnd();
        linkedList.display();
        System.out.println();
        linkedList.deleteAtPosition(4);
        linkedList.display();
        System.out.println();
    }


}
