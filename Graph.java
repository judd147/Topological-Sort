package com.company;

import java.util.LinkedList;

public class Graph {
    //members of Graph class
    private LinkedList<Character> adj[];                                                                               //A linkedlist of vertices and their edges
    private boolean visited[];
    public int pre[];
    public int post[];
    public char vertex[];                                                                                             //An array of vertices

    //Constructor
    Graph(int n){
        adj = new LinkedList[n];
        visited = new boolean[n];
        pre = new int[n];
        post = new int[n];
        vertex = new char[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList();
            visited[i] = false;
            pre[i] = 0;
            post[i] = 0;
        }
    }

    public LinkedList getVertex(int i){
        return adj[i];
    }

    public void setVisited(int i){
        visited[i] = true;
    }

    public boolean getVisited(int i){
        return visited[i];
    }

    public void addVertex(char v, int i){
        adj[i].add(v);
        vertex[i] = v;
    }

    public void addEdge(char u, int i){
        adj[i].add(u);
    }
}
