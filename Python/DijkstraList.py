import math
def hasUnvisited(seen, dists):
    for i in range(len(seen)):
        if not seen[i] and dists[i] < math.inf:
            return True
    
    return False

def getLowestUnvisited(seen, dists):
    index = -1
    lowestDistance = math.inf

    for i in range(len(seen)):
        if seen[i]:
            continue

        if lowestDistance > dists[i]:
            lowestDistance = dists[i]
            index = i
    
    return index

def dijkstra(source, value, graph):
    seen = []
    prev = []
    dists = []
    for i in range(len(graph)):
        seen.append(False)
    for i in range(len(graph)):
        prev.append(-1)
    for i in range(len(graph)):
        dists.append(math.inf)
    
    dists[source] = 0

    while hasUnvisited(seen, dists):
        current = getLowestUnvisited(seen, dists)
        seen[current] = True

        listOfEdges = graph[current]
        for i in range(len(listOfEdges)):
            edge = listOfEdges[i]
            if seen[edge["to"]]:
                continue

            dist = dists[current] + edge["weight"]
            if dist < dists[edge["to"]]:
                dists[edge["to"]] = dist
                prev[edge["to"]] = current
    
    out = []
    current = value
    while prev[current] != -1:
        out.append(current)
        current = prev[current]
    out.append(source)
    out.reverse()
    return out

graph = [
    [{"to": 1, "weight": 1}, {"to": 2, "weight": 5}],
    [{"to": 2, "weight": 7}, {"to": 3, "weight": 6}],
    [{"to": 4, "weight": 1}],
    [{"to": 1, "weight": 1}, {"to": 2, "weight": 1}],
    []
]

print(dijkstra(0, 4, graph))