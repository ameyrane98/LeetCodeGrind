class Solution {
    /**
        you can do it by DFS -> using inRecursion Array
        OR  -------------BFS -> using Kahn's Algorithm
     */
   
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new LinkedList();
        boolean[] visited= new boolean[numCourses];
        boolean[] inRecursion= new boolean[numCourses];
        Stack<Integer> stck= new Stack();
     
        for(int i=0; i< numCourses; i++){
            adj.add(new LinkedList());
        }

        for(int i=0; i< prerequisites.length; i++){
                int[] courses= prerequisites[i];
                adj.get(courses[1]).add(courses[0]);
        }

        for(int i=0; i< numCourses; i++){
            if (!visited[i]) {
                if (dfs(adj, i, visited, inRecursion, stck)) {
                    return new int[0]; // Cycle detected, return empty array
                }
            }
        }
        System.out.println(stck);
        int[] res = new int[stck.size()];
        int index = 0;
        while (!stck.isEmpty()) {
            res[index++] = stck.pop();
        }

        return res;
    }

    boolean dfs(List<List<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion, Stack<Integer> stck) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.get(u)) {
            if (inRecursion[v]) {
                return true; // Cycle detected
            }
            if (!visited[v]) {
                if (dfs(adj, v, visited, inRecursion, stck)) {
                    return true;
                }
            }
        }

        inRecursion[u] = false;
        stck.push(u);
        return false;
    }

    /**
        Kahn's Algorithm
     */

    //  import java.util.*;

// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> adj = new ArrayList<>();
//         int[] inDegree = new int[numCourses];
//         Queue<Integer> queue = new LinkedList<>();
//         int[] order = new int[numCourses];
//         int index = 0;

//         // Step 1: Initialize adjacency list
//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Step 2: Build adjacency list and compute in-degrees
//         for (int[] pair : prerequisites) {
//             int course = pair[0];
//             int prereq = pair[1];
//             adj.get(prereq).add(course);
//             inDegree[course]++; // Increase in-degree of the dependent course
//         }

//         // Step 3: Enqueue nodes with in-degree 0
//         for (int i = 0; i < numCourses; i++) {
//             if (inDegree[i] == 0) {
//                 queue.add(i);
//             }
//         }

//         // Step 4: Process the queue using BFS
//         while (!queue.isEmpty()) {
//             int current = queue.poll();
//             order[index++] = current;

//             for (int neighbor : adj.get(current)) {
//                 inDegree[neighbor]--; // Remove dependency
//                 if (inDegree[neighbor] == 0) {
//                     queue.add(neighbor); // Add next independent course
//                 }
//             }
//         }

//         // Step 5: Check for cycles
//         return (index == numCourses) ? order : new int[0]; // If all courses are ordered, return result; otherwise, return empty array.
//     }
// }

}