package dev.algorithms.graph.adjacencyMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private final ArrayList<Node> nodes;
    private final int[][] matrix;

    Graph(int size){
        nodes = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst) {
        return matrix[src][dst] == 1;
    }

    public void print() {
        System.out.print("  ");
        for (Node node : nodes) {
            System.out.print(node.getData() + " ");
        }
        System.out.println();
        for(int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).getData() + " ");
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
            }
    }

    public void depthFirstSearch(int src){
        boolean[] visited = new boolean[matrix.length];
        dFSHelper(src, visited);
    }

    private void dFSHelper(int src, boolean[] visited) {
        if(visited[src]){
            return;
        }
        else {
            visited[src] = true;
            System.out.println(nodes.get(src).getData() + " = visited");
        }

        for (int i = 0; i < matrix[src].length; i++){
            if(matrix[src][i] == 1) {
                dFSHelper(i, visited);
            }
        }
    }
    public void breadthFirstSearch(int src){
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[matrix.length];

            queue.offer(src);
            visited[src] = true;

            while(queue.size() != 0){
                src = queue.poll();
                System.out.println(nodes.get(src).getData() + " = visited");

                for(int i = 0; i < matrix[src].length; i++) {
                    if(matrix[src][i] == 1 && !visited[i]){
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
    }

}
