class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

class doubleLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
    
    def displayFromBeginning(self):
        tmp = self.head
        while tmp is not None:
            print(tmp.data, end = " ")
            tmp = tmp.next
    
    def displayFromEnd(self):
        tmp = self.tail
        while tmp is not None:
            print(tmp.data, end = " ")
            tmp = tmp.prev
    
    def insertAtBeginning(self, data):
        node = Node(data)
        tmp = self.head
        tmp.prev = node
        node.next = tmp
        self.head = node
    
    def insertAtEnd(self, data):
        node = Node(data)
        tmp = self.tail
        tmp.next = node
        node.prev = tmp
        self.tail = node
    
    def insertAtPosition(self, data, position):
        node = Node(data)
        tmp = self.head
        for i in range(1, position - 1):
            tmp = tmp.next
        node.prev = tmp
        node.next = tmp.next
        tmp.next.prev = node
        tmp.next = node
    
    def deleteAtBeginning(self):
        tmp = self.head
        self.head = tmp.next
        tmp.next = None
        self.head.prev = None
    
    def deleteAtEnd(self):
        prev = self.tail.prev
        current = self.tail
        prev.next = None
        current.prev = None
    
    def deleteAtPosition(self, position):
        prev = self.head
        current = self.head.next
        for i in range(1, position - 1):
            current = current.next
            prev = prev.next
        prev.next = current.next
        current.next.prev = prev
        current.next = None
        current.prev = None


linkList = doubleLinkedList()
n1 = Node(5)
n2 = Node(6)
n3 = Node(15)
n4 = Node(16)
n5 = Node(3)
n1.next = n2
n2.prev = n1
n2.next = n3
n3.prev = n2
n3.next = n4
n4.prev = n3
n4.next = n5
n5.prev = n4
linkList.head = n1
linkList.tail = n5
linkList.displayFromBeginning()
print()
linkList.displayFromEnd()
print()
linkList.insertAtBeginning(30)
linkList.displayFromBeginning()
print()
linkList.insertAtEnd(32)
linkList.displayFromBeginning()
print()
linkList.insertAtPosition(25, 4)
linkList.displayFromBeginning()
print()
linkList.deleteAtBeginning()
linkList.displayFromBeginning()
print()
linkList.deleteAtEnd()
linkList.displayFromBeginning()
print()
linkList.deleteAtPosition(4)
linkList.displayFromBeginning()
print()