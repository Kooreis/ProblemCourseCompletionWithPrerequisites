Here is a Python console application that solves the problem:

```python
from collections import defaultdict

def canFinish(numCourses, prerequisites):
    graph = defaultdict(list)
    for x, y in prerequisites:
        graph[x].append(y)

    visited = [0 for _ in range(numCourses)]
    def dfs(i):
        if visited[i] == -1:
            return False
        if visited[i] == 1:
            return True
        visited[i] = -1
        for j in graph[i]:
            if not dfs(j):
                return False
        visited[i] = 1
        return True

    for i in range(numCourses):
        if not dfs(i):
            return False
    return True

numCourses = int(input("Enter the number of courses: "))
prerequisites = []
n = int(input("Enter the number of prerequisites: "))
for _ in range(n):
    prerequisite = tuple(map(int, input("Enter the prerequisite (format: course prerequisite): ").split()))
    prerequisites.append(prerequisite)

print(canFinish(numCourses, prerequisites))
```

This Python console application first creates a directed graph from the prerequisites, then uses Depth-First Search (DFS) to detect if there is a cycle in the graph. If a cycle is detected, it means that not all courses can be finished, so it returns False. If no cycle is detected, it means that all courses can be finished, so it returns True.