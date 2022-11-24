package camino.corto;

import java.io.*;    
import java.util.*; 
   
public class BFSTraversal    
{    
    private int vertex;      
    private LinkedList<Integer> adj[];         
    private Queue<Integer> que;              
    BFSTraversal(int v)    
    {    
        vertex = v;    
        adj = new LinkedList[vertex];    
        for (int i=0; i<v; i++)    
        {    
            adj[i] = new LinkedList<>();    
        }    
        que = new LinkedList<Integer>();    
    }    
    void insertEdge(int v,int w)    
    {    
        adj[v].add(w);       
    }    
    void BFS(int n)    
    {    
        boolean nodes[] = new boolean[vertex];         
        int a = 0;    
        nodes[n]=true;                      
        que.add(n);         
        while (que.size() != 0)    
        {    
            n = que.poll();        
            System.out.print(n+" ");     
            for (int i = 0; i < adj[n].size(); i++)  
            {    
                a = adj[n].get(i);    
                if (!nodes[a])        
                {    
                    nodes[a] = true;    
                    que.add(a);    
                }    
            }      
        }    
    }
}  
