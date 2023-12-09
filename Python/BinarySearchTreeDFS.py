class Node:
    data = 0
    left = None
    right = None

def search(current: Node, value: int) -> bool:
    if current == None:
        return False
    if current == value:
        return True
    if current.data < value:
        return search(current.right, value)
    return search(current.left, value)

def dfs(head: Node, value: int) -> bool:
    return search(head, value)