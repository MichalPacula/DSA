class Node:
    left = None
    right = None
    data = 0
    
    def __init__(self, value: int) -> None:
        self.data = value

class BinaryTree:
    head = None
    def __init__(self):
        pass
    def walkPreOrder(self, current: Node, path):
        if current == None:
            return path
            
        path.append(current.data)
        self.walkPreOrder(current.left, path)
        self.walkPreOrder(current.right, path)
        return path
        
    def preOrderTraversal(self) -> list(int):
        return self.walkPreOrder(self.head, [])
        
    def walkInOrder(self, current: Node, path):
        if current == None:
            return path
            
        self.walkInOrder(current.left, path)
        path.append(current.data)
        self.walkInOrder(current.right, path)
        return path
        
    def inOrderTraversal(self) -> list(int):
        return self.walkInOrder(self.head, [])
        
    def walkPostOrder(self, current: Node, path):
        if current == None:
            return path
            
        self.walkPostOrder(current.left, path)
        self.walkPostOrder(current.right, path)
        path.append(current.data)
        return path
        
    def postOrderTraversal(self) -> list(int):
        return self.walkPostOrder(self.head, [])
        
    def breadthFirstSearch(self, value):
        queue = [self.head]
        while len(queue) != 0:
            current = queue.pop(0)
            if current == None:
                continue

            if current.data == value:
                return True
            
            queue.append(current.left)
            queue.append(current.right)
        
        return False