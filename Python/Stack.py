class Node:
    def __init__(self, value):
        self.data = value
        self.prev = None

class Stack:
    length = 0
    head = None

    def peek(self):
        return self.head.data

    def push(self, value):
        self.length += 1
        node = Node(value)
        if self.head == None:
            self.head = node
            return;
        node.prev = self.head
        self.head = node
    
    def pop(self):
        self.length = max(0, self.length - 1)
        if self.length == 0:
            tmp = self.head
            self.head = None
            tmp.prev = None
            return tmp.data
        tmp = self.head
        self.head = tmp.prev
        tmp.prev = None
        return tmp.data


stack = Stack()
stack.push(1)
print(stack.peek())
stack.push(2)
print(stack.peek())
stack.push(3)
print(stack.peek())
stack.push(4)
print(stack.peek())
stack.push(5)
print(stack.peek())
print(stack.pop())
print(stack.peek())
print(stack.pop())
print(stack.peek())
print(stack.pop())
print(stack.peek())
print(stack.pop())
print(stack.peek())
print(stack.pop())