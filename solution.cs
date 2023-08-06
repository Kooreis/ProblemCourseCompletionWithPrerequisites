Here is a C# console application that solves the problem:

```CSharp
using System;
using System.Collections.Generic;

class Program
{
    static void Main(string[] args)
    {
        int numCourses = 4;
        int[][] prerequisites = new int[][] {
            new int[] {1, 0},
            new int[] {2, 1},
            new int[] {3, 2},
            new int[] {1, 3}
        };

        bool canFinish = CanFinish(numCourses, prerequisites);
        Console.WriteLine(canFinish);
    }

    public static bool CanFinish(int numCourses, int[][] prerequisites)
    {
        Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
        for (int i = 0; i < numCourses; i++)
            graph[i] = new List<int>();

        foreach (var prerequisite in prerequisites)
            graph[prerequisite[1]].Add(prerequisite[0]);

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (IsCyclic(i, visited, graph))
                return false;

        return true;
    }

    private static bool IsCyclic(int course, int[] visited, Dictionary<int, List<int>> graph)
    {
        if (visited[course] == 1)
            return true;

        if (visited[course] == 2)
            return false;

        visited[course] = 1;
        foreach (var prerequisite in graph[course])
            if (IsCyclic(prerequisite, visited, graph))
                return true;

        visited[course] = 2;
        return false;
    }
}
```

This program uses depth-first search to detect cycles in the graph. If a cycle is detected, it means that there is a circular dependency between courses and not all courses can be finished. If no cycle is detected, it means that all courses can be finished.