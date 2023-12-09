class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
class Queue:
    def __init__(self) -> None:
        self.head = None
        self.tail = None
    
    def peek(self):
        if self.head is None:
            print("None")
            return;
        print(self.head.data)
        return self.head.data

    def deque(self):
        if self.head is None:
            return;

        tmp = self.head
        self.head = self.head.next
        tmp.next = None
        return tmp.data
    
    def enqueue(self, value):
        node = Node(value)
        if self.tail is None:
            self.head = node
            self.tail = node
            return;
        
        self.tail.next = node
        self.tail = node


queue = Queue()
queue.enqueue(1)
queue.peek()
queue.enqueue(2)
queue.peek()
queue.enqueue(3)
queue.peek()
queue.enqueue(4)
queue.peek()
queue.enqueue(5)
queue.peek()
queue.deque()
queue.peek()
queue.deque()
queue.peek()
queue.deque()
queue.peek()
queue.deque()
queue.peek()
queue.deque()
queue.peek()