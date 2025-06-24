import java.io.*;
import java.util.*;

class Graph {
  public static void main(String[] args) {
    
    Graph g = new Graph(5);
    
    g.add(0, 1, 5);
    g.add(1, 2, 2);
    g.add(1, 3, 1);
    g.add(2, 3, 7);
    g.add(3, 4, 6);
    
    System.out.println(g.shortestPath(0, 4));
    
    g.printGraph();
    
    
  }
  
  int graph[][];
  int size;
  
  public Graph(int size){
    this.size = size;
    graph = new int[size][size];
    
    for(int i = 0; i < graph.length; i++){
      for(int j = 0; j < size; j++){
        graph[i][j] = 0; 
      }
    }
    
  }
  
  public void add(int vertex1, int vertex2, int weight){
    graph[vertex1][vertex2] = weight;
    graph[vertex2][vertex1] = weight;
  }
  
  //Djikstra's shortest path algorithm
  public int shortestPath(int vertex1, int vertex2){
    
    //Array that represents the shortest distance from vertex1 to i
    int dist[] = new int[size];
    //Array that represents if i has been included or not
    boolean vertexIncluded[] = new boolean[size];
    
    //Initializing arrays
    for(int i = 0; i < size; i++){
      dist[i] = Integer.MAX_VALUE;
      vertexIncluded[i] = false;
    }
    
    //Source vertex's distance from itself is 0
    dist[vertex1] = 0;
    
    //Runs size - 1 times because source is already initialized
    for(int i = 0; i < size - 1; i++){
      
      //Represents the index of the minimum vertex to be added
      int minIndex = 0;
      //Keeps track of minimum edge value
      int min = Integer.MAX_VALUE;
      
      for(int j = 0; j < size; j++){
        //If vertex isn't included and its edge weight is so far least
        if(vertexIncluded[j] == false && dist[j] <= min){
          //Set min to new least edge value
          min = dist[j];
          //Keep track of the index of this vertex
          minIndex = j;
        }
      }
      
      //Least edge weight unincluded vertex found, set it to true
      vertexIncluded[minIndex] = true;
      
      for(int k = 0; k < size; k++){
        //If vertex isn't included, there is a connection to it, 
        //the connection to it exists in the MSG, and its distance
        //added to the distance of the MSG so far is less than the
        //distance that currently represents the vertex
         if(!vertexIncluded[k] && graph[minIndex][k] != 0 &&
            dist[minIndex] != Integer.MAX_VALUE && dist[minIndex]
            + graph[minIndex][k] < dist[k]){
           
           //Sets the distance of the vertex equal to new, less value
           dist[k] = dist[minIndex] + graph[minIndex][k];
         }
      }
      
      
    }
    
    return dist[vertex2];
  }
  
  public void printGraph(){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        System.out.print(graph[i][j] + " "); 
      }
      System.out.println();
    }
  }
  
}
