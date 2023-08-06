Here is a Java console application that solves the problem:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of courses:");
        int numCourses = scanner.nextInt();
        System.out.println("Enter the number of prerequisites:");
        int numPrerequisites = scanner.nextInt();
        int[][] prerequisites = new int[numPrerequisites][2];
        for (int i = 0; i < numPrerequisites; i++) {
            System.out.println("Enter prerequisite " + (i + 1) + ":");
            prerequisites[i][0] = scanner.nextInt();
            prerequisites[i][1] = scanner.nextInt();
        }
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int[] prerequisite : prerequisites)
            graph[prerequisite[1]].add(prerequisite[0]);

        for (int i = 0; i < numCourses; i++)
            if (!visited[i])
                if (isCyclic(i, visited, stack, graph))
                    return false;

        return true;
    }

    private static boolean isCyclic(int i, boolean[] visited, boolean[] stack, ArrayList<Integer>[] graph) {
        if (stack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;
        stack[i] = true;

        for (Integer neighbor : graph[i])
            if (isCyclic(neighbor, visited, stack, graph))
                return true;

        stack[i] = false;

        return false;
    }
}
```

This console application first asks for the number of courses and prerequisites. Then it asks for each prerequisite pair. After that, it prints whether all courses can be finished or not. The solution uses depth-first search to detect cycles in the graph. If a cycle is detected, it means that there is a circular dependency between courses and not all courses can be finished.