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
    }
}