def walk(graph, current, value, seen, path):
    if seen[current]:
        return False
    
    path.append(current)
    if current == value:
        return True

    seen[current] = True

    listOfEdges = graph[current]
    for i in range(len(listOfEdges)):
        edge = listOfEdges[i]
        if walk(graph, edge["to"], value, seen, path):
            return True

    path.pop()
    return False

def dfs(graph, source, value):
    seen = []
    path = []
    for i in range(len(graph)):
        seen.append(False)
    
    walk(graph, source, value, seen, path)

    if len(path) == 0:
        return []
    
    return path