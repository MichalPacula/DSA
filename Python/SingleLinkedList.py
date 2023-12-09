class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
    
    def display(self):
        if self.head is None:
            print("Linked list is empty")
        else:
            tmp = self.head
            while tmp is not None:
                print(tmp.data, end=" ")
                tmp = tmp.next
    
    def insertAtBeginning(self, data):
        node = Node(data)
        node.next = self.head
        self.head = node
    
    def insertAtEnd(self, data):
        node = Node(data)
        tmp = self.head
        while tmp.next is not None:
            tmp = tmp.next
        tmp.next = node
    
    def insertAtPosition(self, data, position):
        node = Node(data)
        tmp = self.head
        for i in range(1, position - 1):
            tmp = tmp.next
        node.next = tmp.next
        tmp.next = node
    
    def deleteAtBeginning(self):
        tmp = self.head
        self.head = tmp.next
        tmp.next = None

    def deleteAtEnd(self):
        prev = self.head
        current = self.head.next
        while current.next is not None:
            current = current.next
            prev = prev.next
        prev.next = None
    
    def deleteAtPosition(self, position):
        prev = self.head
        current = self.head.next
        for i in range(1, position - 1):
            current = current.next
            prev = prev.next
        prev.next = current.next
        current.next = None

linkList = LinkedList()
n1 = Node(5)
n2 = Node(6)
n3 = Node(15)
n4 = Node(16)
n5 = Node(3)
n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
linkList.head = n1
linkList.display()
print()
linkList.insertAtBeginning(30)
linkList.display()
print()
linkList.insertAtEnd(32)
linkList.display()
print()
linkList.insertAtPosition(25, 4)
linkList.display()
print()
linkList.deleteAtBeginning()
linkList.display()
print()
linkList.deleteAtEnd()
linkList.display()
print()
linkList.deleteAtPosition(4)
linkList.display()
print()