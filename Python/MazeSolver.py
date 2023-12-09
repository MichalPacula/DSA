direction = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def walk(maze, wall, curr, end, seen, path):
    if (curr["x"] < 0 or curr["x"] >= len(maze[0])) or (curr["y"] < 0 or curr["y"] >= len(maze)):
        return False
    
    if maze[curr["y"]][curr["x"]] == wall:
        return False
    
    if curr["y"] == end["y"] and curr["x"] == end["x"]:
        path.append(end)
        return True
    
    if seen[curr["y"]][curr["x"]]:
        return False
    
    seen[curr["y"]][curr["x"]] = True
    path.append(curr)
    for i in direction:
        if walk(maze, wall, {"x": curr["x"] + i[0], "y": curr["y"] + i[1]}, end, seen, path):
            return True
    path.pop()

    return False

def solve(maze, wall, start, end):
    seen = []
    path = []
    for i in range(len(maze)):
        seen.append(len(maze[0]) * [False])
    
    walk(maze, wall, start, end, seen, path)
    return path

print(solve([
    "xxxxxxxxxx x",
    "x        x x",
    "x        x x",
    "x xxxxxxxx x",
    "x          x",
    "x xxxxxxxxxx"
], "x", {"x": 10, "y": 0}, {"x": 1, "y": 5}))