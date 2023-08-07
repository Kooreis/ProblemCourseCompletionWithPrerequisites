from collections import defaultdict

def canFinish(numCourses, prerequisites):
    graph = defaultdict(list)
    for x, y in prerequisites:
        graph[x].append(y)