package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Character> stack = new Stack<>();
    static int clock = 0;

    public static void main(String[] args)
            throws IOException {
        InputStream txt = new FileInputStream("D:\\Liyao\\2019 Fall\\CSC 222\\shabi\\test2.txt");          //Create the inputstream to access the file
        Scanner snjr = new Scanner(txt);
        int n = snjr.nextInt();                                                                                         //Read the number of vertices
        Graph G = new Graph(n);                                                                                         //Create a graph object
        String str = snjr.nextLine();                                                                                   //Finish reading the first line
        int index = 0;
        while (snjr.hasNext()){                                                                                        //Add vertices and edges
            str = snjr.nextLine();
           G.addVertex(str.charAt(0),index);
            for (int i = 1; i < str.length(); i++){
                G.addEdge(str.charAt(i),index);
            }
            index++;
        }
        dfs(G);
        while (!stack.isEmpty())                                                                                       //Print the graph in topologically sorted order
            System.out.print(stack.pop()+" ");
    }

    public static void dfs(Graph G){                                                                                  //depth-first search
        for (int i = 0; i < G.pre.length; i++){
            if (G.getVisited(i) == false){
                explore(G,i);
            }
        }
    }

    public static void explore(Graph G, int i){
        G.setVisited(i);                                                                                                //Set this vertex to visited
        previsit(G,i);
        for (int k = 1; k < G.getVertex(i).size(); k++){                                                               //explore edges
            for (int j = 0; j < G.vertex.length; j++){
                if (G.getVertex(i).get(k).equals(G.vertex[j]) && G.getVisited(j) == false)
                    explore(G,j);
                if (G.getVertex(i).get(k).equals(G.vertex[j]) && G.pre[j] != 0 && G.post[j] == 0) {
                    System.out.println("Warning: Cycle detected");
                    System.exit(0);
                }
            }
        }
        postvisit(G,i);
        stack.push(G.vertex[i]);                                                                                       //After postvisit, push vertex to the stack
    }

    public static void previsit(Graph G, int i){
        G.pre[i] = clock;
        clock = clock + 1;
    }

    public static void postvisit(Graph G, int i){
        G.post[i] = clock;
        clock = clock + 1;
    }
}