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