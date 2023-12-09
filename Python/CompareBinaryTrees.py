class Node:
    data = 0
    left = None
    right = None

def compare(a: Node, b: Node) -> bool:
    if a == None and b == None:
        return True
    if a == None or b == None:
        return False
    if a.data != b.data:
        return False
    
    return compare(a.left, b.left) and compare(a.right, b.right)