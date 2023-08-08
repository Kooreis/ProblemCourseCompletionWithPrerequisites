public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int[] prerequisite : prerequisites)
            graph[prerequisite[1]].add(prerequisite[0]);
    }