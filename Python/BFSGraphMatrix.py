def bfs(graph, source, value):
    seen = []
    prev = []
    for _ in range(len(graph)):
        seen.append(False)
    for _ in range(len(graph)):
        prev.append(-1)
    
    seen[source] = True
    queue = [source]
    while len(queue) != 0:
        current = queue.pop(0)
        if current == value:
            break

        adjs = graph[current]
        for i in range(len(adjs)):
            if adjs[i] == 0:
                continue

            if seen[i]:
                continue

            seen[i] = True
            prev[i] = current
            queue.append(i)

    current = value
    out = []
    while prev[current] != -1:
        out.append(current)
        current = prev[current]
    
    if len(out) != 0:
        out.reverse()
        return [source] + out    
    return []

graph = [
    [0, 1, 1, 0, 0],
    [0, 0, 0, 1, 0],
    [0, 0, 0, 0, 1],
    [1, 0, 0, 0, 0],
    [0, 0, 0, 1, 0]
]
print(bfs(graph, 0, 4))