package Busqueda;

import java.util.*;  
  
class DFSTraversal {  
  private LinkedList<Integer> adj[];   
  private boolean visited[];  
   
  DFSTraversal(int V)
  {  
    adj = new LinkedList[V];  
    visited = new boolean[V];  
  
    for (int i = 0; i < V; i++)  
      adj[i] = new LinkedList<Integer>();  
  }  
  
    
  void insertEdge(int src, int dest) {  
    adj[src].add(dest);  
  }  
  
  void DFS(int vertex) {  
    visited[vertex] = true;  
    System.out.print(vertex + " ");  
  
    Iterator<Integer> it = adj[vertex].listIterator();  
    while (it.hasNext()) {  
      int n = it.next();  
      if (!visited[n])  
        DFS(n);  
    }  
  }  
}