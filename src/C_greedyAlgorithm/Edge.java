package C_greedyAlgorithm;
class Edge implements Comparable<Edge>  
		{  
		    int u;  
		    int v;  
		    int weight;  
		      
		      
		      
		    public Edge(int u, int v, int weight) {  
		        super();  
		        this.u = u;  
		        this.v = v;  
		        this.weight = weight;  
		    }  
		  
		  
		  
		    @Override  
		    public int compareTo(Edge e) {  
		        if(e.weight==weight)  
		        return 0;  
		        else if(weight<e.weight)  
		            return -1;  
		        else  
		            return 1;  
		              
		    }  
		      
		    public String toString()  
		    {  
		        return u+"--"+v+":"+weight;  
		    }  
		      
		}  